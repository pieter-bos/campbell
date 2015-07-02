package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * Return representation in Roborovski
 */
public class Return extends Statement {
    /**
     * Function from which you return
     */
    private final Function func;

    /**
     * Value to be returned
     */
    private Expression value;

    public Return(Expression value, Function func) {
        this.value = value;
        this.func = func;
    }

    /**
     * Generates SprIl/Sprockell code for this return statement
     * @param emitter
     * @param block
     * @throws IOException
     */
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

    /**
     * Sets the offset for this and its value
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        value.setOffset(offset);
    }

    /**
     * Returns the number of instructions for this return
     * @return
     */
    @Override
    public int getSize() {
        return value.getSize() + 26;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        return Math.max(1, value.calcSpill());
    }
}
