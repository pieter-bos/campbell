package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * DotExpression represents the getting of a variable from a class in Roborovski
 */
public class DotExpression extends Expression {
    /**
     * Pointer to the struct
     */
    private final Expression expr;

    /**
     * Block of memory (compound type)
     */
    private Struct struct;

    /**
     * Property that is wanted from the struct
     */
    private final String property;

    public DotExpression(Expression expr, Struct struct, String property) {
        this.expr = expr;
        this.struct = struct;
        this.property = property;
    }

    /**
     * Generates SprIl/Sprockell code for this dot expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        expr.stackOffset = stackOffset;
        expr.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.emitConst(struct.getOffset(property), SprockellRegister.b);
        emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.a);
        emitter.load(SprockellRegister.a, SprockellRegister.a);
        emitter.push(SprockellRegister.a);

        end(emitter);
    }

    /**
     * Generates SprIl/Sprockell code for this dot expression
     * Calculates memory address of where to find the property
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        expr.stackOffset = stackOffset;
        expr.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.emitConst(struct.getOffset(property), SprockellRegister.b);
        emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.a);
        emitter.nop();
        emitter.push(SprockellRegister.a);

        end(emitter);
    }

    /**
     * Sets the offset of this dot expressino
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        expr.setOffset(offset);
    }

    /**
     * Returns the number of instructions for this dot expression
     * @return
     */
    @Override
    public int getSize() {
        return expr.getSize() + 5;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        expr.stackOffset = stackOffset;
        return Math.max(expr.calcSpill(), 1);
    }
}
