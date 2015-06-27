package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

public abstract class Expression extends Statement {
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        throw new RuntimeException("Internal error: cannot evaluate an expression of type " + this.getClass() + " to a memory address");
    }
}
