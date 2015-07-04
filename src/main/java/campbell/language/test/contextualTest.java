package campbell.language.test;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;
import static org.junit.Assert.assertEquals;

/**
 * Testing for contextual errors
 */
public class contextualTest {

    /**
     * Files for different test cases
     */
    String[] files = {"correctAssignmentDeclaration.ham", "src/main/java/campbell/language/test/correctAssignmentDeclaration.hs",
                        "declaredTypeAfterAssign.ham", "src/main/java/campbell/language/test/declaredTypeAfterAssign.hs",
                        "declaredTypeScopeAbove.ham", "src/main/java/campbell/language/test/declaredTypeScopeAbove.hs",
                        "declaredTypeScopeWithin.ham", "src/main/java/campbell/language/test/declaredTypeScopeWithin.hs",
                        "wrongTypeAssigned.ham", "src/main/java/campbell/language/test/wrongTypeAssigned.hs",
                        "correctFunction.ham", "src/main/java/campbell/language/test/correctFunction.hs",
                        "wrongReturnTypeFunction.ham", "src/main/java/campbell/language/test/wrongReturnTypeFunction.hs",
                        "wrongAmountArgumentsFunction.ham", "src/main/java/campbell/language/test/wrongAmountArgumentsFunction.hs",
                        "wrongTypedArgumentsFunction.ham", "src/main/java/campbell/language/test/wrongTypedArgumentsFunction.hs",
                        "correctAssignmentWithFunction.ham", "src/main/java/campbell/language/test/correctAssignmentWithFunction.hs",
                        "addIntBool.ham", "src/main/java/campbell/language/test/addIntBool.hs",
                        "andIntBool.ham", "src/main/java/campbell/language/test/andIntBool.hs",
                        "andBools.ham", "src/main/java/campbell/language/test/andBools.hs",
                        "andInts.ham", "src/main/java/campbell/language/test/andInts.hs",
                        "addInts.ham", "src/main/java/campbell/language/test/addInts.hs",
                        "andBooleanFunctions.ham", "src/main/java/campbell/language/test/andBooleanFunctions.hs",
                        "addIntFunctions.ham", "src/main/java/campbell/language/test/addIntFunctions.hs",
                        "addBooleans.ham", "src/main/java/campbell/language/test/addBooleans.hs",
                        "noArgumentsGivenFunction.ham", "src/main/java/campbell/language/test/noArgumentsGivenFunction.hs",
                        "unneededArgumentsGivenFunction.ham", "src/main/java/campbell/language/test/unneededArgumentsGivenFunction.hs",
                        "getProperty.ham", "src/main/java/campbell/language/test/getProperty.hs"};

    /**
     * Method that compiles a program from a given input to a given output
     * @param input - .ham file to be compiled
     * @param output - .hs file (path) to be made
     * @throws IOException
     */
    public static void compileProgram(URL input, String output) throws IOException {
        Program p = parseFrom(input.openStream());
        p.setScope(null);
        p.findDefinitions();
        p.findImpls();
        p.checkType();

        campbell.roborovski.model.Program program = p.toRoborovski();
        program.compile(new SprockellEmitter(new FileWriter(output)));
    }

    /**
     * Returns a URL for a given file located in the same package as this class
     * @param file
     * @return
     */
    public URL getURL(String file) {
        return this.getClass().getResource(file);
    }

    /**
     * Correct test case for assignments
     */
    @Test
    public void testCorrectAssignment() {
        try {
            compileProgram(getURL(files[0]), files[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where declaration is after the assignment
     *
     * "Wrong" test case
     */
    @Test
    public void testDeclarationAfterAssignment() {
        try {
            compileProgram(getURL(files[2]), files[3]);
        } catch (CompileException e) {
            // Expect a compile exception: Undeclared variable i used
            String error = e.getMessage().substring(95);
            String shouldBe = new String("Undeclared variable i used");
            assertEquals(error, shouldBe);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test case where declaration is in a scope above the current scope
     *
     * "Correct" test case
     */
    @Test
    public void testDeclarationScopeAbove() {
        try {
            compileProgram(getURL(files[4]), files[5]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where declaration is in a scope within the current scope
     *
     * "Wrong" test case
     */
    @Test
    public void testDeclarationScopeWithin() {
        try {
            compileProgram(getURL(files[6]), files[7]);
        } catch (CompileException e) {
            // Expect a compile exception: No definition of i can be found
            String error = e.getMessage().substring(95);
            String shouldBe = new String("Usage of nonexistant symbol i");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where value is assigned to a variable with a different type
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongTypedAssignment() {
        try {
            compileProgram(getURL(files[8]), files[9]);
        } catch (CompileException e) {
            // Expect a compile exception: Type error: left expression is of type bool whereas right is of type int
            String error = e.getMessage().substring(102);
            String shouldBe = new String("left expression is of type bool whereas right is of type int");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where functions with several scopes are tested
     *
     * "Correct" test case
     */
    @Test
    public void testCorrectFunction() {
        try {
            compileProgram(getURL(files[10]), files[11]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where function returns something of an incorrect type
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongReturnTypeFunction() {
        try {
            compileProgram(getURL(files[12]), files[13]);
        } catch (CompileException e) {
            // Expected compile exception: Type of return expression (bool) does not correspond to the function's contract (int)
            String error = e.getMessage().substring(90);
            String shouldBe = new String("Type of return expression (bool) does not correspond to the function's contract (int)");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where function gets too many arguments
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongAmountArgumentsFunction() {
        try {
            compileProgram(getURL(files[14]), files[15]);
        } catch (CompileException e) {
            // Expected compile exception: Type error: left expression is of type int where right is of type FunctionType
            String error = e.getMessage().substring(90);
            String shouldBe = new String("Type error: left expression is of type int whereas right is of type (null -> int)");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where function gets arguments of a wrong type
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongTypedArgumentsFunction() {
        try {
            compileProgram(getURL(files[16]), files[17]);
        } catch (CompileException e) {
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Argument in call expression add(true, 2) should be of type int not bool");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where function result is stored in variable
     *
     * "Correct" test case
     */
    @Test
    public void testCorrectAssignmentFunction() {
        try {
            compileProgram(getURL(files[18]), files[19]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case that contains an expression of the form ( int + bool )
     *
     * "Wrong" test case
     */
    @Test
    public void testAddingIntBool() {
        try {
            compileProgram(getURL(files[20]), files[21]);
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i + j)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (i + j)");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case that contains an expression of the form ( int & bool )
     *
     * "Wrong" test case
     */
    @Test
    public void testAndIntBool() {
        try {
            compileProgram(getURL(files[22]), files[23]);
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i & j)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (i & j)");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case that contains an expression of the form ( bool & bool )
     *
     * "Correct" test case
     */
    @Test
    public void testAndBools() {
        try {
            compileProgram(getURL(files[24]), files[25]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case that contains an expression of the form ( int & int )
     *
     * "Wrong" test case
     */
    @Test
    public void testAndInts() {
        try {
            compileProgram(getURL(files[26]), files[27]);
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i & j)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (i & j)");
            assertEquals(error,shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case that contains an expression of the form ( int + int )
     *
     * "Correct" test case
     */
    @Test
    public void testAddInts() {
        try {
            compileProgram(getURL(files[28]), files[29]);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case that contains an expression of the form ( fun & fun )
     * Where fun are functions with return type bool
     *
     * "Correct" test case
     */
    @Test
    public void testAndBooleanFunctions() {
        try {
            compileProgram(getURL(files[30]), files[31]);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case that contains an experssion of the form ( fun + fun )
     * Where fun are functions with return type int
     *
     * "Correct" test case
     */
    @Test
    public void testAddIntFunctions() {
        try {
            compileProgram(getURL(files[32]), files[33]);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case that contains an expression of the form ( bool + bool )
     *
     * "Wrong" test case
     */
    @Test
    public void testAddBooleans() {
        try {
            compileProgram(getURL(files[34]), files[35]);
        } catch (CompileException e) {
            // Expected compile exception : Incorrect type in expression: (a + b)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (a + b)");
            assertEquals(error,shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case where function expects arguments but none are given
     *
     * "Wrong" test case
     */
    @Test
    public void testNoArgumentsGivenFunction() {
        try {
            compileProgram(getURL(files[36]), files[37]);
        } catch (CompileException e) {
            // Expected compile exception : Type error: left expression is of type int whereas right is of type FunctionType
            String error = e.getMessage().substring(90);
            String shouldBe = new String("Type error: left expression is of type int whereas right is of type (null -> int)");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case where function expects no arguments but one is given
     *
     * "Wrong" test case
     */
    @Test
    public void testUnneededArgumentsFunction() {
        try {
            compileProgram(getURL(files[38]), files[39]);
        } catch (CompileException e) {
            // Expected Compile exception: Called function takes up to 0 arguments, but 1 were given.
            String error = e.getMessage().substring(89);
            String shouldBe = "Called function takes up to 0 arguments, but 1 were given.";
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    // Property opvragen die bestaat
    @Test
    public void testGetProperty() {
        try {
            compileProgram(getURL(files[40]), files[41]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Property opvragen die niet bestaat

    // Genest property opvragen (class in class in class)

    // Functie aanroepen in class



}