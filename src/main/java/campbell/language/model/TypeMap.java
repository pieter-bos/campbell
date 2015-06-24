package campbell.language.model;

import campbell.language.types.Type;

import java.util.HashMap;

public class TypeMap<T, K extends Type> extends HashMap<T, K> {
    @Override
    public K put(T key, K value) {
        if(this.containsKey(key)) {
            Type clash = this.get(key);
            throw new CompileException(value.getImplementation(), String.format("Duplicate type name, clashes with type at %d:%d", clash.getImplementation().getLine(), clash.getImplementation().getCol()));
        }

        return super.put(key, value);
    }
}
