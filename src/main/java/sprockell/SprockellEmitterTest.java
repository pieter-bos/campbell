package sprockell;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class SprockellEmitterTest {
    @Test
    public void test() throws IOException {
        SprockellEmitter emitter = new SprockellEmitter(new FileWriter("/home/sophie/Downloads/Campbell/campbell/example.ham"));

        emitter.close();
    }
}
