package campbell.language.model;

import campbell.language.model.CompileException;
import campbell.language.model.Node;
import campbell.language.model.Statement;

import java.util.HashMap;

public class SymbolMap<T, K extends Node> extends HashMap<T, K> {
    @Override
    public K put(T key, K value) {
        if(this.containsKey(key)) {
            Node clash = this.get(key);
            throw new CompileException(value, String.format("Duplicate symbol name, clashes with symbol at %d:%d", clash.getLine(), clash.getCol()));
        }

        return super.put(key, value);
    }
}
