package campbell.language.test;

import campbell.language.model.CompileException;
import campbell.language.model.NotImplementedException;
import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * Created by sophie on 7/1/15.
 */
public class typeCheckTest {
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
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongDeclaredFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/noArgumentsGivenFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/unneededArgumentsGivenFunction",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongDeclaredIf",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongDeclaredClass",
            "/home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/language/test/wrongArgumentsClass"};

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

    @Test
    public void testCorrectAssignment() {
        try {
            compileProgram(files[0] + ".ham", files[0] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeclarationAfterAssignment() {
        try {
            compileProgram(files[1] + ".ham", files[1] + ".hs");
        } catch (CompileException e) {
            // Expect a compile exception: Undeclared variable i used
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testDeclarationScopeAbove() {
        try {
            compileProgram(files[2] + ".ham", files[2] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeclarationScopeWithin() {
        try {
            compileProgram(files[3] + ".ham", files[3] + ".hs");
        } catch (CompileException e) {
            // Expect a compile exception: Undeclared variable i used
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrongTypedAssignment() {
//        try {
//            //compileProgram(files[4]+".ham", files[4] + ".hs");
//            // TODO: Deze krijgt niet de juiste compile exception, 2e argument heeft niet meer het juiste type "not callable"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testCorrectFunction() {
        try {
            compileProgram(files[5] + ".ham", files[5] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrongReturnTypeFunction() {
        try {
            compileProgram(files[6] + ".ham", files[6] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Type of return expression (bool) does not correspond to the function's contract (int)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrongAmountArgumentsFunction() {
//        try {
//            //compileProgram(files[7]+".ham", files[7] + ".hs");
//            //TODO: Deze krijgt niet de juiste compile exception, "Type int is not callable"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testWrongTypedArgumentsFunction() {
//        try {
//            compileProgram(files[8]+".ham", files[8] + ".hs");
        //TODO: Deze krijgt ook niet de juiste compile exception, "Type int is not callable"
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testWrongAssigmentFunction() {
        try {
            compileProgram(files[9] + ".ham", files[9] + ".hs");
        } catch (CompileException e) {
            // Expected, maar TODO: Niet juiste compile exception, should get incompatible types, not "type int is not callable"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCorrectAssignmentFunction() {
//        try {
//            compileProgram(files[10]+".ham", files[10] + ".hs");
        // Hetzelfde issue als alle andere, currying werkt nog niet TODO: Fix currying, fix everything
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testAddingIntBool() {
        try {
            compileProgram(files[11] + ".ham", files[11] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i + j)
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testAndIntBool() {
        try {
            compileProgram(files[12] + ".ham", files[12] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i & j)
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testAndBools() {
        try {
            compileProgram(files[13] + ".ham", files[13] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testAndInts() {
        try {
            compileProgram(files[14] + ".ham", files[14] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception: Incorrect type in expression: (i & j)
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testAddInts() {
        try {
            compileProgram(files[15] + ".ham", files[15] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

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

    @Test
    public void testAddIntFunctions() {
        try {
            compileProgram(files[17] + ".ham", files[17] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testAddBooleans() {
        try {
            compileProgram(files[18] + ".ham", files[18] + ".hs");
        } catch (CompileException e) {
            // Expected compile exception : Cannot apply this operator to the given arguments: a, b
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testAndBooleanFunctions() {
        try {
            compileProgram(files[19] + ".ham", files[19] + ".hs");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongDeclaredFunction() {
        try {
            compileProgram(files[20] + ".ham", files[20] + ".hs");
        } catch (NotImplementedException e) {
            //Expected NotImplementedException : Class of int is not implemented (it parses funn as a class because it does not correspond to the fun keyword
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testNoArgumentsGivenFunction() {
//        try {
//            compileProgram(files[21] + ".ham", files[21] + ".hs");
        // Should catch CompileException, TODO: Function gaat stuk indien geen argumenten gegeven die wel verwacht zijn
        // Het gaat niet echt stuk, maar het geeft wel een verkeerde error (namelijk n type error
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
    }

    @Test
    public void testUnneededArgumentsFunction() {
        try {
            compileProgram(files[22] + ".ham", files[22] + ".hs");
        } catch (CompileException e) {
            //Dit hoort net als bij alle andere dingen een andere foutmelding te geven, zal gefixt zijn als currying werkt
            // TODO: IndexOutOfBoundsException als je te veel argumenten aan function geeft
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongDeclaredIf() {
        try {
            compileProgram(files[23] + ".ham", files[23] + ".hs");
        } catch (NotImplementedException e) {
            // Expected NotImplementedException: Does not recognize keyword of if-statement as it is typed incorrectly
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongDeclaredClass() {
        try {
            compileProgram(files[24] + ".ham", files[24] + ".hs");
        } catch (NotImplementedException e) {
            // Expected NotImplementedException: Does not recognize keyword of class statement as it is typed incorrectly
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongArgumentsClass() {
        try {
            compileProgram(files[24] + ".ham", files[24] + ".hs");
        } catch (NotImplementedException e) {
            // Expected NotImplementedException: Does not recognize type of argument as it is typed incorrectly
            // Thus it expects a class to be defined with this type
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}