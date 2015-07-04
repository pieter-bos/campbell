package campbell.language.test;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.Program;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;
import static org.junit.Assert.assertEquals;

/**
 * Testing for syntax errors
 */
public class syntaxTest {

    String[] files = {"wrongDeclaredFunction.ham", "src/main/java/campbell/language/test/wrongDeclaredFunction.hs",
                    "wrongDeclaredIf.ham", "src/main/java/campbell/language/test/wrongDeclaredIf.hs",
                    "wrongDeclaredClass.ham","src/main/java/campbell/language/test/wrongDeclaredClass.hs",
                    "wrongArgumentsClass.ham","src/main/java/campbell/language/test/wrongArgumentsClass.hs",
                    "example.ham", "src/main/java/campbell/language/test/example.hs"};

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
    }

    /**
     * Test case where function is wrongly declared, its keyword looks like "funn" instead of "fun"
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongDeclaredFunction() {
        try {
            URL input = this.getClass().getResource(files[0]);
            compileProgram(input, files[1]);
        } catch (CompileException e) {
            //Expected NotImplementedException : Compile error while processing a [@5,0:0='OPEN_BLOCK',<34>,2:1] at 2:1: ...
            String error = e.getMessage();
            String shouldBe =  "Compile error while processing a [@5,0:0='OPEN_BLOCK',<34>,2:1] at 2:1:\n" +
                    "extraneous input 'OPEN_BLOCK' expecting {<EOF>, CLASS, WHILE, IMPL, TRAIT, IF, RETURN, UNSAFE, TRUE, FALSE, FUN, FOR, BROKET_OPEN, BROKET_CLOSE, LTE, GTE, EQ, PAREN_OPEN, DOT, PLUS, MINUS, STAR, SLASH, PERCENT, INT, IDENTIFIER, NEQ, LSH, RSH, AND, OR, XOR, HASKELL}";
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case where if is wrongly declared, its keyword looks like "iff" instead of "if"
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongDeclaredIf() {
        try {
            URL input = this.getClass().getResource(files[2]);
            compileProgram(input, files[3]);
        } catch (CompileException e) {
            // Expected NotImplementedException: Does not recognize keyword of if-statement as it is typed incorrectly
            String error = e.getMessage();
            String shouldBe = new String("Compile error while processing a [@2,0:0='OPEN_BLOCK',<34>,2:1] at 2:1:\n" +
                    "extraneous input 'OPEN_BLOCK' expecting {<EOF>, CLASS, WHILE, IMPL, TRAIT, IF, RETURN, UNSAFE, TRUE, FALSE, FUN, FOR, BROKET_OPEN, BROKET_CLOSE, LTE, GTE, EQ, PAREN_OPEN, DOT, PLUS, MINUS, STAR, SLASH, PERCENT, INT, IDENTIFIER, NEQ, LSH, RSH, AND, OR, XOR, HASKELL}");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case where class is wrongly declared, its keyword looks like "claass" instead of "class"
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongDeclaredClass() {
        try {
            URL input = this.getClass().getResource(files[4]);
            compileProgram(input, files[5]);
        } catch (CompileException e) {
            // Expected NotImplementedException: Compile error while processing a [@5,0:0='OPEN_BLOCK',<34>,2:1] at 2:1: no viable alternative at input 'Adder<T>OPEN_BLOCK'
            String error = e.getMessage();
            String shouldBe = new String("Compile error while processing a [@5,0:0='OPEN_BLOCK',<34>,2:1] at 2:1:\nno viable alternative at input 'Adder<T>OPEN_BLOCK'");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case where argument of class is spelled wrong, it therefore sees it as a generic argument
     *
     * "Wrong" test case
     */
    @Test
    public void testWrongArgumentsClass() {
        try {
            URL input = this.getClass().getResource(files[6]);
            compileProgram(input, files[7]);
        } catch (CompileException e) {
            // Expected NotImplementedException: Compile error while processing a [@22,0:0='>',<16>,6:6] at 6:6: no viable alternative at input 'Adder<>'
            String error = e.getMessage();
            String shouldBe = new String("Compile error while processing a [@22,0:0='>',<16>,6:6] at 6:6:\nno viable alternative at input 'Adder<>'");
            assertEquals(error, shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Test case with multiple functions and scopes defined
     *
     * "Correct" test case
     */
    @Test
    public void testCorrectSyntax() {
        try {
            URL input = this.getClass().getResource(files[8]);
            compileProgram(input, files[9]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
