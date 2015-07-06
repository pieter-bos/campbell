package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * While loop representation in Roborovski
 */
public class While extends Block {
    /**
     * Condition of the loop
     */
    private final Expression condition;

    public While(Expression condition) {
        this.condition = condition;
    }

    /**
     * Generates SprIl/Sprockell code for this while loop
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        condition.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.branchAbsolute(SprockellRegister.a, getOffset() + condition.getSize() + 3, "while true");
        emitter.jumpAbsolute(getOffset() + getSize(), "while false");
        super.compile(emitter, block);
        emitter.jumpAbsolute(getOffset(), "while end");
    }

    /**
     * Sets the offset of this loop, its condition and its scope (super block)
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        condition.setOffset(offset);
        super.setOffset(offset + condition.getSize() + 3);
        this.offset = offset;
    }

    /**
     * Returns the number of instructions for this while loop
     * @return
     */
    @Override
    public int getSize() {
        return condition.getSize() + 3 + super.getSize() + 1;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        return Math.max(super.calcSpill(), condition.calcSpill());
    }
}
