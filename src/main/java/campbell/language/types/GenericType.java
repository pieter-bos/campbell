package campbell.language.types;

/**
 * Type for generics
 */
public class GenericType extends Type {
    /**
     * Name of the generic type
     */
    private String name;

    public GenericType(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of this generic type
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the name of this generic type
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Replaces a given type by another given type within this generic type
     *
     * Generic type contains no types and therefore does nothing
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    /**
     * Makes a hashcode of this generic type
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode() ^ 0x1a2b3c4d;
    }

    /**
     * Checks whether a given object is of this generic type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof GenericType && name.equals(((GenericType) other).name);
    }
}
