package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * BinaryExpression represents a binary expression in Roborvoski
 */
public class BinaryExpression extends Expression {
    /**
     * Enum containing all possible operands:
     * LessThan, GreaterThan, LessThanEquals, GreaterThanEquals, Equals, NotEquals,
     * Add, Subtract, Multiply, Divide, Modulo, Left shift, Right shift, And, Or and Xor
     */
    public enum BinaryOp {
        LessThan(SprockellCompute.LessThan),
        GreaterThan(SprockellCompute.GreaterThan),
        LessThanEquals(SprockellCompute.LessThanEquals),
        GreaterThanEquals(SprockellCompute.GreaterThanEquals),
        Equals(SprockellCompute.Equal),
        NotEquals(SprockellCompute.NotEqual),
        Add(SprockellCompute.Add),
        Subtract(SprockellCompute.Sub),
        Multiply(SprockellCompute.Mul),
        Divide(SprockellCompute.Div),
        Modulo(SprockellCompute.Mod),
        LSH(SprockellCompute.LShift),
        RSH(SprockellCompute.RShift),
        And(SprockellCompute.And),
        Or(SprockellCompute.Or),
        Xor(SprockellCompute.Xor);

        /**
         * Compute operand for SprIl/Sprockell
         */
        private SprockellCompute compute;

        BinaryOp(SprockellCompute compute) {
            this.compute = compute;
        }

        /**
         * Returns compute operand for SprIl/Sprockell
         * @return
         */
        public SprockellCompute getCompute() {
            return compute;
        }

    }

    /**
     * Expression on the left side
     */
    private final Expression left;

    /**
     * Operand of the expression
     */
    private final BinaryOp op;

    /**
     * Expression on the right side
     */
    private final Expression right;

    public BinaryExpression(Expression left, BinaryOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    /**
     * Generates SprIl/Sprockell code for this binary expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        left.stackOffset = stackOffset;
        right.stackOffset = stackOffset + 1;

        left.compile(emitter, block);
        right.compile(emitter, block);
        emitter.pop(SprockellRegister.b);
        emitter.pop(SprockellRegister.a);
        emitter.compute(op.getCompute(), SprockellRegister.a, SprockellRegister.b, SprockellRegister.a, "compute " + op);
        emitter.push(SprockellRegister.a);

        end(emitter);
    }

    /**
     * Sets the offset of this expression
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        left.setOffset(offset);
        right.setOffset(offset + left.getSize());
    }

    /**
     * Returns the number of instructions for this expression
     * @return
     */
    @Override
    public int getSize() {
        return left.getSize() + right.getSize() + 4;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        left.stackOffset = stackOffset;
        right.stackOffset = stackOffset + 1;

        return Math.max(left.calcSpill(), right.calcSpill() + 1);
    }
}
