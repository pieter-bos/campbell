package campbell.roborovski.model;

import campbell.language.types.Type;

public class Variable {
    public static final Variable RET = new Variable("ret");
    public static final Variable SP = new Variable("sp");

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

    public Integer getOffset(Block block) {
        if(offset == null) {
            return null;
        }

        int offset = this.offset;

        while(block != this.block) {
            offset += block.getVarStackSize();
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
