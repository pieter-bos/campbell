package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

/**
 * Expression representation in Roborovski
 */
public abstract class Expression extends Statement {
    /**
     * Offset on the stack
     */
    protected int stackOffset = 0;

    /**
     * May evaluate Expression by generating SprIl/Sprockell code for this expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        throw new RuntimeException("Internal error: cannot evaluate an expression of type " + this.getClass() + " to a memory address");
    }
}
