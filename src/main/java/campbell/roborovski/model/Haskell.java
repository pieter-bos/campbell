package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

/**
 * Haskell representation in Roborovski
 */
public class Haskell extends Statement {
    /**
     * String of Haskell code
     */
    private String haskell;

    public Haskell(String haskell) {
        this.haskell = haskell;
    }

    /**
     * Generates SprIl/Sprockell code for this Haskell statement
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        emitter.emitRaw(haskell);

        end(emitter);
    }

    /**
     * Sets the offset of this statement
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Returns the number of instructions for this Haskell statement
     * @return
     */
    @Override
    public int getSize() {
        return 1;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        return 0;
    }
}
