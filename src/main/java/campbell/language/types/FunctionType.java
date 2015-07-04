package campbell.language.types;

import util.HashList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Type for functions
 */
public class FunctionType extends Type {
    /**
     * Type of what should be returned by the function
     */
    private Type returnType;
    private List<Type> arguments;

    public FunctionType(Type returnType, List<? extends Type> arguments) {
        this.returnType = returnType;
        this.arguments = new HashList<>();
        this.arguments.addAll(arguments);
    }

    /**
     * Returns the name of function type.
     * Method should be unused.
     * @return null
     */
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

        for(int i = 0; i < arguments.size(); i++) {
            if(arguments.get(i).getName().equals(replace.getName())) {
                arguments.set(i, replaceWith);
            }
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
        int result = (returnType.hashCode() * 139);

        for(Type t : arguments) {
            result = (result << 12) ^ result;
            result *= 139;
            result ^= t.hashCode();
        }

        return result;
    }

    /**
     * Checks whether a given object is of this function type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof FunctionType && returnType.equals(((FunctionType) other).returnType) && arguments.equals(((FunctionType) other).arguments);
    }

    @Override
    public String toString() {
        String result = "(";

        for(Type t : arguments) {
            result += t + " -> ";
        }

        return result + returnType + ")";
    }

    public List<? extends Type> getArguments() {
        return arguments;
    }
}