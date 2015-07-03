package campbell.language.test;

import campbell.language.model.NotImplementedException;
import campbell.language.model.scoped.Program;
import org.junit.Test;
import sprockell.SprockellEmitter;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import static campbell.language.model.scoped.Program.parseFrom;

/**
 * Testing for syntax errors
 */
public class syntaxTest {

    String[] files = {"wrongDeclaredFunction.ham", "wrongDeclaredFunction.hs",
                    "wrongDeclaredIf.ham", "wrongDeclaredIf.hs",
                    "wrongDeclaredClass.ham","wrongDeclaredClass.hs",
                    "wrongArgumentsClass.ham","wrongArgumentsClass.hs"};

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

        System.out.println(p);

        campbell.roborovski.model.Program program = p.toRoborovski();
        program.compile(new SprockellEmitter(new FileWriter(output)));
    }

    @Test
    public void testWrongDeclaredFunction() {
        try {
            URL input = this.getClass().getResource(files[0]);
            compileProgram(input, files[1]);
        } catch (NotImplementedException e) {
            //Expected NotImplementedException : Class of int is not implemented (it parses funn as a class because it does not correspond to the fun keyword
            String error = e.getMessage().substring(0);
            String shouldBe = new String("Class of int is not implemented");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongDeclaredIf() {
        try {
            URL input = this.getClass().getResource(files[2]);
            compileProgram(input, files[3]);
        } catch (NotImplementedException e) {
            // Expected NotImplementedException: Does not recognize keyword of if-statement as it is typed incorrectly
            String error = e.getMessage().substring(0);
            String shouldBe = new String("There is no implementation of the rule class x");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongDeclaredClass() {
        try {
            URL input = this.getClass().getResource(files[4]);
            compileProgram(input, files[5]);
        } catch (NotImplementedException e) {
            // Expected NotImplementedException: Does not recognize keyword of class statement as it is typed incorrectly
            String error = e.getMessage().substring(0);
            String shouldBe = new String("There is no implementation of the rule class x");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testWrongArgumentsClass() {
        try {
            URL input = this.getClass().getResource(files[6]);
            compileProgram(input, files[7]);
        } catch (NotImplementedException e) {
            // Expected NotImplementedException: Does not recognize type of argument as it is typed incorrectly
            // Thus it expects a class to be defined with this type
            String error = e.getMessage().substring(0);
            String shouldBe = new String("Class of add is not implemented");
            System.out.println("Exception thrown: "+error);
            System.out.println("Expected: "+shouldBe);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
