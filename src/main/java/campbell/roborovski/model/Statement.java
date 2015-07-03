package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

/**
 * Statement is an enveloping class for all statements in Roborovski
 */
public abstract class Statement {
    /**
     * Offset of the statement
     */
    protected int offset = -1;

    /**
     * Stores offset
     * Used for debugging to see whether calculated size complies with expected size
     */
    private int start;

    /**
     * Abstract method for generating SprIl/Sprockell code for statements
     * @param emitter
     * @param block
     * @throws IOException
     */
    public abstract void compile(SprockellEmitter emitter, Block block) throws IOException;

    /**
     * Start variable is set to offset (location of emitter)
     * @param emitter
     */
    public void start(SprockellEmitter emitter) {
        start = emitter.getLoc();

        if(start != getOffset()) {
            System.err.println("Offset is not the start: Expected = " + getOffset() + ", Actual = " + start + "\n" + this.toString());
        }

    }

    public void end(SprockellEmitter emitter) {
        if(emitter.getLoc() - start != getSize()) {
            throw new RuntimeException("Internal error: The size of statement " + this.getClass() + " does not match its actual instruction count. Expected = "
                    + getSize() + ", Actual = " + (emitter.getLoc() - start) + "\n"
                    + this.toString());
        }
    }

    /**
     * Returns the offset of this statement
     * @return
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Abstract method for setting the offset of a statement
     * @param offset
     */
    public abstract void setOffset(int offset);

    /**
     * Abstract method for returning the number of instructions (SprIl) for this statement
     * @return
     */
    public abstract int getSize();

    /**
     * Abstract method to calculate how many values are spilled on the stack
     * @return
     */
    public abstract int calcSpill();
}
