package sprockell;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class SprockellEmitterTest {
    @Test
    public void test() throws IOException {
        SprockellEmitter emitter = new SprockellEmitter(new FileWriter("/home/pieter/blaat.hs"));

        emitter.close();
    }
}
