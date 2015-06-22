package campbell.language.types;

import campbell.language.model.NotImplementedException;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashSet;
import java.util.Set;

public abstract class PrimitiveType extends Type {
    public static final Set<String> PRIMITIVE_TYPES = new HashSet<>();

    static {
        PRIMITIVE_TYPES.add("int");
        PRIMITIVE_TYPES.add("bool");
    }

    public static boolean isPrimitive(String type) {
        return PRIMITIVE_TYPES.contains(type);
    }

    public static Type fromId(String id) {
        switch(id) {
            case "int":
                return new IntType();
            case "bool":
                return new BoolType();
        }

        throw new NotImplementedException("There is no implementation of the primitive type " + id);
    }
}
