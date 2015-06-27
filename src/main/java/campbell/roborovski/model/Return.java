package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class Return extends Statement {
    private final Function func;
    private Expression value;

    public Return(Expression value, Function func) {
        this.value = value;
        this.func = func;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        value.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.load(func.requireVariable("ret").getOffset(block), SprockellRegister.b);
        emitter.load(func.requireVariable("sp").getOffset(block), SprockellRegister.sp);
        emitter.jump(SprockellRegister.b);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        value.setOffset(offset);
    }

    @Override
    public int getSize() {
        return value.getSize() + 4;
    }
}
