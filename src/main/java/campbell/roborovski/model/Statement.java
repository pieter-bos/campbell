package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

public abstract class Statement {
    protected int offset = -1;
    private int start;

    public abstract void compile(SprockellEmitter emitter, Block block) throws IOException;

    public void start(SprockellEmitter emitter) {
        start = emitter.getLoc();
    }

    public void end(SprockellEmitter emitter) {
        if(emitter.getLoc() - start != getSize()) {
            throw new RuntimeException("Internal error: The size of statement " + this.getClass() + " does not match its actual instruction count. Expected = "
                    + getSize() + ", Actual = " + (emitter.getLoc() - start) + "\n"
                    + this.toString());
        }
    }

    public int getOffset() {
        return offset;
    }

    public abstract void setOffset(int offset);

    public abstract int getSize();

    public abstract int calcSpill();
}
