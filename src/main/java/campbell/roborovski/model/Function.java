package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Function extends Block {
    private Return ret = new Return(new ConstExpression(0), this);
    private Block statementBlock = new Block();
    private Block block;

    public Function() {
        statementBlock.superBlock = this;
    }

    @Override
    public void calcOffsets() {
        int size = 0;

        for(Variable var : variables) {
            size += var.getSize();
        }

        int current = size;

        for(Variable var : variables) {
            current -= var.getSize();
            var.setOffset(current);
        }

        Variable ret = new Variable("ret");
        Variable sp = new Variable("sp");

        addVariable(ret);
        addVariable(sp);

        ret.setOffset(size);
        sp.setOffset(size + 1);

        statementBlock.calcOffsets();
    }

    @Override
    public void addStatement(Statement stat) {
        statementBlock.addStatement(stat);
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        statementBlock.compile(emitter, this);
        ret.compile(emitter, this);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        statementBlock.setOffset(offset);
        ret.setOffset(offset + statementBlock.getSize());
    }

    @Override
    public int getSize() {
        return statementBlock.getSize() + ret.getSize();
    }

    public Block getStatementBlock() {
        return statementBlock;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
