package campbell.roborovski.model;

import com.sun.org.apache.xpath.internal.operations.Div;
import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class BinaryExpression extends Expression {
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

        private SprockellCompute compute;

        BinaryOp(SprockellCompute compute) {
            this.compute = compute;
        }

        public SprockellCompute getCompute() {
            return compute;
        }

    }
    private final Expression left;
    private final BinaryOp op;
    private final Expression right;

    public BinaryExpression(Expression left, BinaryOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

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

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        left.setOffset(offset);
        right.setOffset(offset + left.getSize());
    }

    @Override
    public int getSize() {
        return left.getSize() + right.getSize() + 4;
    }

    @Override
    public int calcSpill() {
        left.stackOffset = stackOffset;
        right.stackOffset = stackOffset + 1;

        return Math.max(left.calcSpill(), right.calcSpill() + 1);
    }
}
