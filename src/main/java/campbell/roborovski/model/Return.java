package campbell.roborovski.model;

import sprockell.SprockellCompute;
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
        emitter.pop(SprockellRegister.a, "Return value");

        emitter.emitConst(func.requireVariable("ret").getOffset(block), SprockellRegister.c);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.c, SprockellRegister.c);
        emitter.load(SprockellRegister.c, SprockellRegister.b, "Return address: SP[" + func.requireVariable("ret").getOffset(block) + "]");

        emitter.emitConst(func.requireVariable("sp").getOffset(block), SprockellRegister.c);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.c, SprockellRegister.c);
        emitter.load(SprockellRegister.c, SprockellRegister.sp, "Restore SP: SP[" + func.requireVariable("sp").getOffset(block) + "]");

        emitter.jump(SprockellRegister.b, "Jump to return address");
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        value.setOffset(offset);
    }

    @Override
    public int getSize() {
        return value.getSize() + 8;
    }
}
