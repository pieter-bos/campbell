package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

/**
 * Shared variable representation in Roborovski
 */
public class SharedVariableExpression extends Expression {
    /**
     * Variable that is shared
     */
    private final Variable variable;

    public SharedVariableExpression(Variable variable) {
        this.variable = variable;
    }

    /**
     * Generate SprIl/Sprockell code for this shared variable expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        emitter.emitConst(variable.getOffset(), SprockellRegister.a);
        emitter.read(SprockellRegister.a);
        emitter.receive(SprockellRegister.a);
        emitter.push(SprockellRegister.a, "shared var");

        end(emitter);
    }

    /**
     * May evaluate expression by generating SprIl/Sprockell code for this shared variable expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitConst(variable.getOffset(), SprockellRegister.a);
        emitter.push(SprockellRegister.a, "shared var ref");
        emitter.nop();
        emitter.nop();
    }

    /**
     * Sets the offset for this shared variable expression
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Returns the size of this shared variable expression
     * @return
     */
    @Override
    public int getSize() {
        return 4;
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
