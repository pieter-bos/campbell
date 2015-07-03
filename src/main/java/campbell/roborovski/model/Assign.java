package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * Assign represents an assignment in Roborovski
 */
public class Assign extends Statement {
    /**
     * Expression on the left side of the assignment
     */
    private final Expression left;

    /**
     * Expression on the right side of the assignment
     */
    private final Expression right;

    public Assign(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Generates SprIl/Sprockell code for this assignment
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        left.compileReference(emitter, block);
        right.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.pop(SprockellRegister.b);
        emitter.store(SprockellRegister.a, SprockellRegister.b, "assign");

        end(emitter);
    }

    /**
     * Sets the offset of this assignment
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        left.setOffset(offset);
        right.setOffset(offset + left.getSize());
    }

    /**
     * Returns the number of instructions of this assignment
     * @return
     */
    @Override
    public int getSize() {
        return left.getSize() + right.getSize() + 3;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        right.stackOffset = 1;
        return Math.max(left.calcSpill(), right.calcSpill() + 1);
    }
}
