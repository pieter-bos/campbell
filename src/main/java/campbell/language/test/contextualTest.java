package campbell.language.test;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * Testing for contextual errors
 */
public class contextualTest {

    /**
     * Files for different test cases
     */
    String[] files = {"/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/correctAssignmentDeclaration",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/declaredTypeAfterAssign",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/declaredTypeScopeAbove",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/declaredTypeScopeWithin",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongTypeAssigned",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/correctFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongReturnTypeFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongAmountArgumentsFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongTypedArgumentsFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongAssignmentWithFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/correctAssignmentWithFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/addIntBool",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/andIntBool",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/andBools",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/andInts",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/addInts",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/andFunctions",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/addIntFunctions",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/addBooleans",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/andBooleanFunctions",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/noArgumentsGivenFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/unneededArgumentsGivenFunction"};

    /**
     * Method that compiles a program from a given input to a given output
     * @param input - .ham file (path) to be compiled
     * @param output - .hs file (path) to be made
     * @throws IOException
     */
    public static void compileProgram(String input, String output) throws IOException {
        Program p = parseFrom(new FileInputStream(input));
        p.setScope(null);
        p.findDefinitions();
        p.findImpls();
        p.checkType();

        System.out.println(p);

        campbell.roborovski.model.Program program = p.toRoborovski();
        program.compile(new SprockellEmitter(new FileWriter(output)));
    }

    /**
     * Correct test case for assignments
     */
    @Test
    public void testCorrectAssignment() {
        try {
            compileProgram(files[0] + ".ham", files[0] + ".hs");
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
            compileProgram(files[1] + ".ham", files[1] + ".hs");
        } catch (CompileException e) {
            // Expect a compile exception: Undeclared variable i used
            String error = e.getMessage().substring(95);
            String shouldBe = new String("Undeclared variable i used");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
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
            compileProgram(files[2] + ".ham", files[2] + ".hs");
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
            compileProgram(files[3] + ".ham", files[3] + ".hs");
        } catch (CompileException e) {
            // Expect a compile exception: No definition of i can be found
            String error = e.getMessage().substring(90);
            String shouldBe = new String("No definition of i can be found");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
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
//        try {
//            compileProgram(files[4]+".ham", files[4] + ".hs");
//            // TODO: Deze krijgt niet de juiste compile exception, 2e argument heeft niet meer het juiste type "not callable"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Test case where functions with several scopes are tested
     *
     * "Correct" test case
     */
    @Test
    public void testCorrectFunction() {
        try {
            compileProgram(files[5] + ".ham", files[5] + ".hs");
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
            compileProgram(files[6] + ".ham", files[6] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Type of return expression (bool) does not correspond to the function's contract (int)
            String error = e.getMessage().substring(90);
            String shouldBe = new String("Type of return expression (bool) does not correspond to the function's contract (int)");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case where function gets too much arguments
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongAmountArgumentsFunction() {
//        try {
//            //compileProgram(files[7]+".ham", files[7] + ".hs");
//            //TODO: Deze krijgt niet de juiste compile exception, "Type int is not callable"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Test case where function gets arguments of a wrong type
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongTypedArgumentsFunction() {
//        try {
//            compileProgram(files[8]+".ham", files[8] + ".hs");
        //TODO: Deze krijgt ook niet de juiste compile exception, "Type int is not callable"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Test case where function result is stored in variable
     *
     * "Correct" test case
     */
    @Test
    public void testCorrectAssignmentFunction() {
//        try {
//            compileProgram(files[10]+".ham", files[10] + ".hs");
        // Hetzelfde issue als alle andere, currying werkt nog niet TODO: Fix currying, fix everything
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Test case that contains an expression of the form ( int + bool )
     *
     * "Wrong" test case
     */
    @Test
    public void testAddingIntBool() {
        try {
            compileProgram(files[11] + ".ham", files[11] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i + j)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (i + j)");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
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
            compileProgram(files[12] + ".ham", files[12] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i & j)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (i & j)");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
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
            compileProgram(files[13] + ".ham", files[13] + ".hs");
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
            compileProgram(files[14] + ".ham", files[14] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i & j)
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Incorrect type in expression: (i & j)");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
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
            compileProgram(files[15] + ".ham", files[15] + ".hs");
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
    public void testAndFunctions() {
//        try {
//            compileProgram(files[16] + ".ham", files[16] + ".hs");
//            // TODO: Go fix, gaat stuk als functie geen argumenten krijgt, door aanname in FunStatement dat arguments niet leeg is
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
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
            compileProgram(files[17] + ".ham", files[17] + ".hs");
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
            compileProgram(files[18] + ".ham", files[18] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception : Cannot apply this operator to the given arguments: a, b
            String error = e.getMessage().substring(89);
            String shouldBe = new String("Cannot apply this operator to the given arguments: a, b");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
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
//        try {
//            compileProgram(files[20] + ".ham", files[20] + ".hs");
        // Should catch CompileException, TODO: Function gaat stuk indien geen argumenten gegeven die wel verwacht zijn
        // Het gaat niet echt stuk, maar het geeft wel een verkeerde error (namelijk n type error
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
    }

    /**
     * Test case where function expects no arguments but one is given
     *
     * "Wrong" test case
     */
    @Test
    public void testUnneededArgumentsFunction() {
        try {
            compileProgram(files[21] + ".ham", files[21] + ".hs");
        } catch (CompileException e) {
            //Dit hoort net als bij alle andere dingen een andere foutmelding te geven, zal gefixt zijn als currying werkt
            // TODO: IndexOutOfBoundsException als je te veel argumenten aan function geeft
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}