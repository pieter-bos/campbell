package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class SharedVariableExpression extends Expression {
    private final Variable variable;

    public SharedVariableExpression(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        emitter.emitConst(variable.getOffset(), SprockellRegister.a);
        emitter.read(SprockellRegister.a);
        emitter.receive(SprockellRegister.a);
        emitter.push(SprockellRegister.a, "shared var");

        end(emitter);
    }

    @Override
    public void compileReference(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitConst(variable.getOffset(), SprockellRegister.a);
        emitter.push(SprockellRegister.a, "shared var ref");
        emitter.nop();
        emitter.nop();
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public int calcSpill() {
        return 1;
    }
}
