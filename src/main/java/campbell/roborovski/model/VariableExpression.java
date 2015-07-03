package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * VariableExpression calculates a Variable in Roborovski
 */
public class VariableExpression extends Expression {
    /**
     * Variable that is wanted
     */
    private Variable var;

    public VariableExpression(Variable var) {
        this.var = var;
    }

    /**
     * Generates SprIl/Sprockell code for this variable expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        emitter.push(SprockellRegister.sp);
        emitter.pop(SprockellRegister.b);
        emitter.emitConst(stackOffset, SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.a, SprockellRegister.b);

        emitter.emitConst(var.getScopeOffset(block), SprockellRegister.a);
        emitter.branchAbsolute(SprockellRegister.a, getOffset() + 7);
        emitter.jumpAbsolute(getOffset() + 11);
        emitter.load(SprockellRegister.b, SprockellRegister.b);
        emitter.emitConst(1, SprockellRegister.c);
        emitter.compute(SprockellCompute.Sub, SprockellRegister.a, SprockellRegister.c, SprockellRegister.a);
        emitter.jumpAbsolute(getOffset() + 5);

        emitter.emitConst(var.getOffset(), SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.a, SprockellRegister.a);
        emitter.load(SprockellRegister.a, SprockellRegister.a);
        emitter.push(SprockellRegister.a, "SP: " + var.getName());

        end(emitter);
    }

    /**
     * Generates SprIl/Sprockell code for this variable expression
     * Calculates memory address of where to find the variable
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        emitter.push(SprockellRegister.sp);
        emitter.pop(SprockellRegister.b);
        emitter.emitConst(stackOffset, SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.a, SprockellRegister.b);

        emitter.emitConst(var.getScopeOffset(block), SprockellRegister.a);
        emitter.branchAbsolute(SprockellRegister.a, getOffset() + 7);
        emitter.jumpAbsolute(getOffset() + 11);
        emitter.load(SprockellRegister.b, SprockellRegister.b);
        emitter.emitConst(1, SprockellRegister.c);
        emitter.compute(SprockellCompute.Sub, SprockellRegister.a, SprockellRegister.c, SprockellRegister.a);
        emitter.jumpAbsolute(getOffset() + 5);

        emitter.emitConst(var.getOffset(), SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.a, SprockellRegister.a);
        emitter.nop();
        emitter.push(SprockellRegister.a, "SP-ref: " + var.getName());

        end(emitter);
    }

    /**
     * Sets the offset of this variable expression
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Returns the number of instructinos for this variable expression
     * @return
     */
    @Override
    public int getSize() {
        return 15;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        return 1;
    }
}
