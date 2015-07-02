package campbell.language.types;

/**
 * Type for Integers
 */
public class IntType extends PrimitiveType {
    /**
     * Returns a string representation of int type
     * @return
     */
    @Override
    public String toString() {
        return "int";
    }

    /**
     * Returns the name of int type
     * @return
     */
    @Override
    public String getName() {
        return "int";
    }

    /**
    * Replaces a given type by another given type within this int type
    *
    * Int type contains no types and therefore does nothing
    * @param replace - type that should be replaced
    * @param replaceWith - replacement type
    */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    /**
     * Makes a hashcode of int type
     * @return
     */
    @Override
    public int hashCode() {
        return "int".hashCode();
    }

    /**
     * Checks whether a given object is of int type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof IntType;
    }
}
