package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class Assign extends Statement {
    private final Expression left;
    private final Expression right;

    public Assign(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

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

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        left.setOffset(offset);
        right.setOffset(offset + left.getSize());
    }

    @Override
    public int getSize() {
        return left.getSize() + right.getSize() + 3;
    }

    @Override
    public int calcSpill() {
        right.stackOffset = 1;
        return Math.max(left.calcSpill(), right.calcSpill() + 1);
    }
}
