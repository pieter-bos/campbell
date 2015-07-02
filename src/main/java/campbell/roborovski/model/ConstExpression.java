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
        start(emitter);

        emitter.emitConst(data, SprockellRegister.a);
        emitter.push(SprockellRegister.a, "Const: " + data);

        end(emitter);
    }

    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        compile(emitter, block);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public int calcSpill() {
        return 1;
    }
}
