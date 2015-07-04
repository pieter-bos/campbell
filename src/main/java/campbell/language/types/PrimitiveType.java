package campbell.language.types;

import campbell.language.model.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

/**
 * PrimitiveType is an enveloping abstract class for all primitive types: Integers and Booleans
 */
public abstract class PrimitiveType extends Type {
    /**
     * Set which contains all primitive types
     */
    public static final Set<String> PRIMITIVE_TYPES = new HashSet<>();

    /**
     * Adds all primitive types to the set
     */
    static {
        PRIMITIVE_TYPES.add("int");
        PRIMITIVE_TYPES.add("bool");
        PRIMITIVE_TYPES.add("void");
    }

    /**
     * Checks whether a given type is a primitive type
     * @param type
     * @return
     */
    public static boolean isPrimitive(String type) {
        return PRIMITIVE_TYPES.contains(type);
    }

    /**
     * Returns the type based on a given string
     *
     * If this fails, it shall throw a NotImplementedException
     * Should give a string that represents a primitive type
     * @param id
     * @return
     */
    public static Type fromId(String id) {
        switch(id) {
            case "int":
                return new IntType();
            case "bool":
                return new BoolType();
            case "void":
                return new VoidType();
        }

        throw new NotImplementedException("There is no implementation of the primitive type " + id);
    }
}
