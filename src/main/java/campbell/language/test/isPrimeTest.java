package campbell.language.test;

import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * This class will test the file "isPrime.ham"
 *
 * Used for the listing of the extended test program
 */
public class isPrimeTest {
    String[] files = {"isPrime.ham",
            "src/main/java/campbell/language/test/isPrime.hs"};

    /**
     * Method that compiles a program from a
     * given input to a given output
     * @param input - .ham file to be compiled
     * @param output - .hs file (path) to be made
     * @throws IOException
     */
    public static void compileProgram(URL input, String output)
            throws IOException {
        Program p = parseFrom(input.openStream());
        p.setScope(null);
        p.findDefinitions();
        p.findImpls();
        p.checkType();

        System.out.println(p);

        campbell.roborovski.model.Program program
                = p.toRoborovski();

        program.compile(
                new SprockellEmitter(
                        new FileWriter(output)
                )
        );
    }


    /**
     * Test case that generates a file with an algorithm
     * to check whether a given number is prime
     *
     * Number to check for primeness should be entered
     * in the .ham file
     *
     * After this test the Haskell file should be run to
     * check whether it is correct
     */
    @Test
    public void generateIsPrime() {
        try {
            URL input = this.getClass().getResource(
                    files[0]
            );
            compileProgram(input, files[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
