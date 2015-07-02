package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * ConstExpression that represents constants (integers) in Roborovski
 */
public class ConstExpression extends Expression {
    /**
     * Value of the expression
     */
    private int data;

    public ConstExpression(int data) {
        this.data = data;
    }

    /**
     * Generates SprIl/Sprockell code for this constant expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        emitter.emitConst(data, SprockellRegister.a);
        emitter.push(SprockellRegister.a, "Const: " + data);

        end(emitter);
    }

    /**
     * Generates SprIl/Sprockell code for this constant expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        compile(emitter, block);
    }

    /**
     * Sets the offset for this constant expression
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Returns the number of instructions for this expression
     * @return
     */
    @Override
    public int getSize() {
        return 2;
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
