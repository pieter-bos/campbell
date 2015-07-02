package campbell.language.types;

/**
 * Type representing Booleans
 */
public class BoolType extends PrimitiveType {
    /**
     * Returns the string representation of bool type
     * @return
     */
    @Override
    public String toString() {
        return "bool";
    }

    /**
     * Returns the name of bool type
     * @return
     */
    @Override
    public String getName() {
        return "bool";
    }

    /**
     * Replaces a given type by another given type within this BoolType
     *
     * BoolType contains no types and therefore does nothing
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    /**
     * Makes a hashcode of bool type
     * @return
     */
    @Override
    public int hashCode() {
        return "bool".hashCode();
    }

    /**
     * Checks whether given object is of this type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof BoolType;
    }
}
