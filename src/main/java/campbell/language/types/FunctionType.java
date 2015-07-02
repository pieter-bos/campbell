package campbell.language.types;

/**
 * Type for functions
 */
public class FunctionType extends Type {
    /**
     * Type of what should be returned by the function
     */
    private Type returnType;

    /**
     * Type of the argument of this function type
     */
    private Type argument;

    public FunctionType(Type returnType, Type argument) {
        this.returnType = returnType;
        this.argument = argument;
    }

    /**
     * Returns the name of function type
     * @return
     */
    //TODO: Should this be filled in?
    @Override
    public String getName() {
        return null;
    }

    /**
     * Replaces a given type by another given type within this function type
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        if(returnType.getName().equals(replace.getName())) {
            returnType = replaceWith;
        } else {
            returnType.replaceType(replace, replaceWith);
        }

        if(argument.getName().equals(replace.getName())) {
            argument = replaceWith;
        } else {
            returnType.replaceType(replace, replaceWith);
        }
    }

    /**
     * Returns the return type of this function type
     * @return
     */
    public Type getReturnType() {
        return returnType;
    }

    /**
     * Makes a hashcode of this function type
     * @return
     */
    @Override
    public int hashCode() {
        return (returnType.hashCode() * 139) ^ argument.hashCode();
    }

    /**
     * Checks whether a given object is of this function type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof FunctionType && returnType.equals(((FunctionType) other).returnType) && argument.equals(((FunctionType) other).argument);
    }
}