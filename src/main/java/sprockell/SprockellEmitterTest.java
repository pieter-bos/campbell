package sprockell;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Test for the SprockellEmitter
 */
public class SprockellEmitterTest {
    /**
     * Test for an example file
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        SprockellEmitter emitter = new SprockellEmitter(new FileWriter("/home/sophie/Downloads/Campbell/campbell/example.ham"));

        emitter.close();
    }
}
