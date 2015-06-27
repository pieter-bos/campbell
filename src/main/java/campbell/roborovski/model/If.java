package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;

public class If extends Statement {
    private final Expression condition;
    private final Block thenBlock;
    private final Block elseBlock;

    public If(Expression condition, Block thenBlock, Block elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        condition.compile(emitter, block);
        emitter.pop(SprockellRegister.a);
        emitter.branchAbsolute(SprockellRegister.a, thenBlock.getOffset());
        emitter.jumpAbsolute(elseBlock.getOffset());
        thenBlock.compile(emitter, block);
        emitter.jumpAbsolute(getOffset() + getSize());
        elseBlock.compile(emitter, block);
    }

    @Override
    public void setOffset(int offset) {
        condition.setOffset(offset);
        thenBlock.setOffset(offset + condition.getSize() + 3);
        elseBlock.setOffset(offset + condition.getSize() + 3 + thenBlock.getSize() + 1);
    }

    @Override
    public int getSize() {
        return condition.getSize() + thenBlock.getSize() + elseBlock.getSize() + 4;
    }

    public Block getThenBlock() {
        return thenBlock;
    }

    public Block getElseBlock() {
        return elseBlock;
    }
}
