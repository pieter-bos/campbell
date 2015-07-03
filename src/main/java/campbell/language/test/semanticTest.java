package campbell.language.test;

import campbell.language.model.scoped.Program;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * Created by sophie on 7/3/15.
 */
public class semanticTest {

    String[] files = {"isPrime.ham", "isPrime.hs"};

    /**
     * Method that compiles a program from a given input to a given output
     * @param input - .ham file (path) to be compiled
     * @param output - .hs file (path) to be made
     * @throws IOException
     */
    public static void compileProgram(URL input, String output) throws IOException {
        Program p = parseFrom(input.openStream());
        p.setScope(null);
        p.findDefinitions();
        p.findImpls();
        p.checkType();
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
}
