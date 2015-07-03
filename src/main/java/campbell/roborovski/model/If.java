package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * If representation in Roborovski
 */
public class If extends Statement {
    /**
     * Condition of the if statement
     */
    private final Expression condition;

    /**
     * Block of statements,  executed if condition is true
     */
    private final Block thenBlock;

    /**
     * Block of statements, exeuted if condition is false
     */
    private final Block elseBlock;

    public If(Expression condition, Block thenBlock, Block elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    /**
     * Generates SprIl/Sprockell code for this if statement
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        condition.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.branchAbsolute(SprockellRegister.a, thenBlock.getOffset(), "if true");
        emitter.jumpAbsolute(elseBlock.getOffset(), "if false");
        thenBlock.compile(emitter, block);
        emitter.jumpAbsolute(getOffset() + getSize(), "then end");
        elseBlock.compile(emitter, block);

        end(emitter);
    }

    /**
     * Sets the offset of this if statement, its blocks and its condition
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        condition.setOffset(offset);
        thenBlock.setOffset(offset + condition.getSize() + 3);
        elseBlock.setOffset(offset + condition.getSize() + 3 + thenBlock.getSize() + 1);
    }

    /**
     * Returns the number of instructions for this if statement
     * @return
     */
    @Override
    public int getSize() {
        return condition.getSize() + thenBlock.getSize() + elseBlock.getSize() + 4;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        return Math.max(Math.max(thenBlock.calcSpill(), elseBlock.calcSpill()), condition.calcSpill());
    }

    /**
     * Returns the then block of this if statement
     * @return
     */
    public Block getThenBlock() {
        return thenBlock;
    }

    /**
     * Returns the else block of this if statement
     * @return
     */
    public Block getElseBlock() {
        return elseBlock;
    }
}
