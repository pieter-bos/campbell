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
        start(emitter);

        value.compile(emitter, block);
        emitter.pop(SprockellRegister.a, "Return value");

        emitter.push(SprockellRegister.sp);
        emitter.pop(SprockellRegister.c);

        emitter.emitConst(func.requireVariable("ret").getScopeOffset(block), SprockellRegister.d);
        emitter.branchAbsolute(SprockellRegister.d, getOffset() + value.getSize() + 6);
        emitter.jumpAbsolute(getOffset() + value.getSize() + 10);
        emitter.load(SprockellRegister.c, SprockellRegister.c);
        emitter.emitConst(1, SprockellRegister.b);
        emitter.compute(SprockellCompute.Sub, SprockellRegister.d, SprockellRegister.b, SprockellRegister.d);
        emitter.jumpAbsolute(getOffset() + value.getSize() + 4);

        emitter.emitConst(func.requireVariable("ret").getOffset(), SprockellRegister.d);
        emitter.compute(SprockellCompute.Add, SprockellRegister.c, SprockellRegister.d, SprockellRegister.c);
        emitter.load(SprockellRegister.c, SprockellRegister.b, "Return address");

        emitter.push(SprockellRegister.sp);
        emitter.pop(SprockellRegister.c);

        emitter.emitConst(func.requireVariable("sp").getScopeOffset(block), SprockellRegister.d);
        emitter.branchAbsolute(SprockellRegister.d, getOffset() + value.getSize() + 18);
        emitter.jumpAbsolute(getOffset() + value.getSize() + 22);
        emitter.load(SprockellRegister.c, SprockellRegister.c);
        emitter.emitConst(1, SprockellRegister.e);
        emitter.compute(SprockellCompute.Sub, SprockellRegister.d, SprockellRegister.e, SprockellRegister.d);
        emitter.jumpAbsolute(getOffset() + value.getSize() + 16);

        emitter.emitConst(func.requireVariable("sp").getOffset(), SprockellRegister.d);
        emitter.compute(SprockellCompute.Add, SprockellRegister.c, SprockellRegister.d, SprockellRegister.c);
        emitter.load(SprockellRegister.c, SprockellRegister.sp, "Restore SP");

        emitter.jump(SprockellRegister.b, "Jump to return address");

        end(emitter);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        value.setOffset(offset);
    }

    @Override
    public int getSize() {
        return value.getSize() + 26;
    }

    @Override
    public int calcSpill() {
        return Math.max(1, value.calcSpill());
    }
}
