package campbell.roborovski.model;

/**
 * Variable representation, data structure, in Roborovski
 */
public class Variable {
    /**
     * Name of the variable
     */
    private final String name;

    /**
     * Offset of the variable
     */
    private Integer offset = null;

    /**
     * Block in which the variable occurs
     */
    private Block block;

    public Variable(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the variable
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of instructions for this variable
     * @return
     */
    public int getSize() {
        return 1;
    }

    /**
     * Returns the offset of this variable
     * @return
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Returns the offset of the scope of the variable
     * @param block
     * @return
     */
    public int getScopeOffset(Block block) {
        int offset = 0;

        while(block != this.block) {
            offset++;
            block = block.getSuperBlock();
        }

        return offset;
    }

    /**
     * Sets the offset of this variable
     * @param offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Sets the super block (scope) of this variable
     * @param block
     */
    public void setBlock(Block block) {
        this.block = block;
    }
}
