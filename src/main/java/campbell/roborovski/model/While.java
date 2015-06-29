package campbell.roborovski.model;


import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.LinkedList;

public class While extends Block {
    private final Expression condition;

    public While(Expression condition) {
        this.condition = condition;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        condition.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.branchAbsolute(SprockellRegister.a, getOffset() + condition.getSize() + 3, "while true");
        emitter.jumpAbsolute(getOffset() + getSize(), "while false");
        super.compile(emitter, block);
        emitter.jumpAbsolute(getOffset(), "while end");
    }

    @Override
    public void setOffset(int offset) {
        condition.setOffset(offset);
        super.setOffset(offset + condition.getSize() + 3);
        this.offset = offset;
    }

    @Override
    public int getSize() {
        return condition.getSize() + 3 + super.getSize() + 1;
    }
}
