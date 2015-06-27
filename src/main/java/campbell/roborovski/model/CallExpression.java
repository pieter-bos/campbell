package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.List;

public class CallExpression extends Expression {
    private final Expression callee;
    private final List<Expression> arguments;

    public CallExpression(Expression callee, List<Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.push(SprockellRegister.sp);
        emitter.emitConst(getOffset() + getSize() - 1, SprockellRegister.a);
        emitter.push(SprockellRegister.a);

        for(Expression arg : arguments) {
            arg.compile(emitter, block);
        }

        callee.compile(emitter, block);

        emitter.pop(SprockellRegister.a);
        emitter.jump(SprockellRegister.a);
        emitter.push(SprockellRegister.a);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;

        int current = offset + 3;

        for(Expression arg : arguments) {
            arg.setOffset(current);
            current += arg.getSize();
        }

        callee.setOffset(current);
    }

    @Override
    public int getSize() {
        int size = 6 + callee.getSize();

        for(Expression arg : arguments) {
            size += arg.getSize();
        }

        return size;
    }
}
