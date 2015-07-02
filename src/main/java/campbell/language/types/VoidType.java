package campbell.language.types;

/**
 * Type for void (nothing)
 */
public class VoidType extends PrimitiveType {
    /**
     * Returns the name of the void type
     * @return
     */
    @Override
    public String getName() {
        return "void";
    }

    /**
     * Replaces a given type by another given type within this void type
     *
     * Void type contains no types and therefore does nothing
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    /**
     * Makes a hashcode of the void type
     * @return
     */
    @Override
    public int hashCode() {
        return "void".hashCode();
    }

    /**
     * Checks whether a given object is of the void type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof VoidType;
    }
}
