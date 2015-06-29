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
        System.out.println("Stack offset is " + stackOffset);
        emitter.emitConst(var.getOffset(block) + stackOffset, SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.a, SprockellRegister.a);
        emitter.load(SprockellRegister.a, SprockellRegister.a);
        emitter.push(SprockellRegister.a, "SP[" + var.getOffset(block) + "]: " + var.getName());
    }

    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        System.out.println("Stack offset is " + stackOffset);
        emitter.emitConst(var.getOffset(block) + stackOffset, SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.a, SprockellRegister.a);
        emitter.nop();
        emitter.push(SprockellRegister.a, "SP+" + var.getOffset(block) + ": " + var.getName());
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
