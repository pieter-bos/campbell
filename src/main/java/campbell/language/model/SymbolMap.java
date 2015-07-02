package campbell.language.model;

import java.util.HashMap;

/**
 * Extended HashMap that will contain only unique keys (symbol names)
 */
public class SymbolMap<T, K extends Node> extends HashMap<T, K> {
    /**
     * Method that puts a new value in the map
     *
     * If the key is already in the map, it shall throw a CompileException
     * @param key - symbol name
     * @param value - node from AST
     * @return
     */
    @Override
    public K put(T key, K value) {
        if(this.containsKey(key)) {
            Node clash = this.get(key);
            throw new CompileException(value, String.format("Duplicate symbol name, clashes with symbol at %d:%d", clash.getLine(), clash.getCol()));
        }

        return super.put(key, value);
    }
}
