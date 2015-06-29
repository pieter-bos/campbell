package campbell.roborovski.model;


import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class DotExpression extends Expression {
    private final Expression expr;
    private Struct struct;
    private final String property;

    public DotExpression(Expression expr, Struct struct, String property) {
        this.expr = expr;
        this.struct = struct;
        this.property = property;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        expr.stackOffset = stackOffset;
        expr.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.emitConst(struct.getOffset(property), SprockellRegister.b);
        emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.a);
        emitter.load(SprockellRegister.a, SprockellRegister.a);
        emitter.push(SprockellRegister.a);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        expr.setOffset(offset);
    }

    @Override
    public int getSize() {
        return expr.getSize() + 5;
    }
}
