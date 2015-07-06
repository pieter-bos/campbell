package campbell.language.test;

import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * Testing for semantic issues
 */
public class semanticTest {

    String[] files = {"isPrime.ham", "src/main/java/campbell/language/test/isPrime.hs",
                        "infiniteLoop.ham", "src/main/java/campbell/language/test/infiniteLoop.hs",
                        "divideZero.ham", "src/main/java/campbell/language/test/divideZero.hs"};

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
     * Test case that generates a file with an algorithm to check whether a given number is prime
     *
     * Number to check for prime-ness should be entered in the .ham file
     * After this test the Haskell file should be run to check whether it is correct
     */
    @Test
    public void generateIsPrime() {
        try {
            URL input = this.getClass().getResource(files[0]);
            compileProgram(input, files[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case that runs into an infinite loop
     */
    @Test
    public void generateInfiniteLoop() {
        try {
            URL input = this.getClass().getResource(files[2]);
            compileProgram(input, files[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case that tries to divide by zero
     */
    @Test
    public void generateDivideZero() {
        try {
            URL input = this.getClass().getResource(files[4]);
            compileProgram(input, files[5]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
