package campbell.roborovski.model;

public class Variable {
    private final String name;
    private Integer offset = null;
    private Block block;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return 1;
    }

    public Integer getOffset() {
        return offset;
    }

    public int getScopeOffset(Block block) {
        int offset = 0;

        while(block != this.block) {
            offset++;
            block = block.getSuperBlock();
        }

        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
