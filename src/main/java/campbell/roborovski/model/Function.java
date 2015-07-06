package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

/**
 * Function is a reference to the actual Function from Campbell in Roborovski
 */
public class Function extends Block {

    /**
     * Block of statements in the function
     */
    private Block statementBlock = new Block();

    /**
     * Block where function is defined
     */
    private Block block;

    public Function() {
        statementBlock.superBlock = this;
    }

    /**
     * Calculates the offsets of this block (all its variables and statements)
     */
    @Override
    public void calcOffsets() {
        statementBlock.addStatement(new Return(new ConstExpression(0), this));

        addVariable(new Variable("ret"));
        addVariable(new Variable("sp"));

        int size = 1;

        for(Variable var : variables) {
            size += var.getSize();
        }

        int current = size;

        for(Variable var : variables) {
            current -= var.getSize();
            var.setOffset(current);
        }

        statementBlock.calcOffsets();
    }

    /**
     * Adds a statement to the statement block
     * @param stat
     */
    @Override
    public void addStatement(Statement stat) {
        statementBlock.addStatement(stat);
    }

    /**
     * Generates SprIl/Sprockell code for this function
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        statementBlock.compile(emitter, this);
    }

    /**
     * Sets the offset of this block, its return and statements
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
        statementBlock.setOffset(offset);
    }

    @Override
    public int calcSpill() {
        statementBlock.calcSpill();
        return super.calcSpill();
    }

    /**
     * Returns the number of instructions for this function
     * @return
     */
    @Override
    public int getSize() {
        return statementBlock.getSize();
    }

    /**
     * Returns the statement block of this function
     * @return
     */
    public Block getStatementBlock() {
        return statementBlock;
    }

    /**
     * Sets the block from which the function is called
     * @param block
     */
    public void setBlock(Block block) {
        this.block = block;
    }

    /**
     * Gets the block from which the function is called
     * @return
     */
    public Block getBlock() {
        return block;
    }
}
