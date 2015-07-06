package campbell.language.test;

import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * Testing for concurrency issues
 */
public class concurrencyTest {

    /**
     * Files for different test cases
     */
    String[] files = {"correctConcurrency.ham", "src/main/java/campbell/language/test/correctConcurrency.hs",
            "failConcurrency.ham", "src/main/java/campbell/language/test/failConcurrency.hs",
            "multipleLocks.ham", "src/main/java/campbell/language/test/multipleLocks.hs"};

    /**
     * Method that compiles a program from a given input to a given output
     * @param input - .ham file to be compiled
     * @param output - .hs file (path) to be made
     * @throws IOException
     */
    public static void compileProgram(URL input, String output) throws IOException {
        Program p = parseFrom(input.openStream());
        Program std = parseFrom(ClassLoader.getSystemResourceAsStream("std.ham"));
        p = p.merge(std);
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
     * Test case with correct usage of locks and join
     *
     * "Correct" test case
     */
    @Test
    public void testCorrectConcurrency() {
        try {
            compileProgram(getURL(files[0]), files[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case with multiple threads that do not lock, but do join
     *
     * "Wrong" test case
     */
    @Test
    public void testFailConcurrency() {
        try {
            compileProgram(getURL(files[2]), files[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test case that tries to lock on the same thing twice
     *
     * "Wrong" test case
     */
    @Test
    public void testMultipleLocks() {
        try {
            compileProgram(getURL(files[4]), files[5]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
