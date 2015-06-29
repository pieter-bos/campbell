package campbell.roborovski.model;

import sprockell.SprockellEmitter;

import java.io.IOException;

public class Haskell extends Statement {
    private String haskell;

    public Haskell(String haskell) {
        this.haskell = haskell;
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.emitRaw(haskell);
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
