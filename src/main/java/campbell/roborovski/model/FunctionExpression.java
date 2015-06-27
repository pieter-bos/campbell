package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class FunctionExpression extends Expression {
    private Function func;

    public FunctionExpression(Function func) {
        this.func = func;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitConst(func.getOffset(), SprockellRegister.a);
        emitter.push(SprockellRegister.a);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getSize() {
        return 2;
    }
}
