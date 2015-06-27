package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class ConstExpression extends Expression {
    private int data;

    public ConstExpression(int data) {
        this.data = data;
    }


    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitConst(data, SprockellRegister.a);
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
