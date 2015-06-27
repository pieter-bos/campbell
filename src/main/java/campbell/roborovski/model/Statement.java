package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

public abstract class Statement {
    protected int offset = -1;

    public abstract void compile(SprockellEmitter emitter, Block block) throws IOException;

    public int getOffset() {
        return offset;
    }

    public abstract void setOffset(int offset);

    public abstract int getSize();
}
