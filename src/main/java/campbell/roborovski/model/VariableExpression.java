package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class VariableExpression extends Expression {
    private Variable var;

    public VariableExpression(Variable var) {
        this.var = var;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitConst(var.getOffset(block), SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.a, SprockellRegister.a);
        emitter.load(SprockellRegister.a, SprockellRegister.a);
        emitter.push(SprockellRegister.a);
    }

    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitConst(var.getOffset(block), SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.a, SprockellRegister.a);
        emitter.nop();
        emitter.push(SprockellRegister.a);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getSize() {
        return 4;
    }
}
