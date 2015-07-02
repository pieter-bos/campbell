package campbell.language.types;

import util.HashList;

import java.util.List;

/**
 * Type for classes
 */
public class ClassType extends Type {
    /**
     * Name of the type
     */
    private final String name;

    /**
     * Types of the parameters of the class
     */
    private final HashList<Type> parametricTypes;

    public ClassType(String name, List<Type> parametricTypes) {
        this.name = name;
        this.parametricTypes = new HashList<>();
        this.parametricTypes.addAll(parametricTypes);
    }

    /**
     * Returns a string representation of this class type
     * @return
     */
    @Override
    public String toString() {
        if(parametricTypes.size() == 0) {
            return name;
        } else {
            String result = name + "<";

            boolean firstType = true;

            for(Type t : parametricTypes) {
                if(!firstType) {
                    result += ", ";
                }

                firstType = false;

                result += t.toString();
            }

            result += ">";

            return result;
        }
    }

    /**
     * Returns the name of this class type
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
    * Replaces a given type by another given type within this class type
    *
    * @param replace - type that should be replaced
    * @param replaceWith - replacement type
    */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        parametricTypes.replaceAll(t -> t.getName().equals(replace.getName()) ? replaceWith : t);
    }

    /**
     * Returns the parametric types of this class type
     * @return
     */
    public List<Type> getParametricTypes() {
        return parametricTypes;
    }

    /**
     * Makes a hashcode of this class type
     * @return
     */
    @Override
    public int hashCode() {
        return (parametricTypes.hashCode() * 137) ^ name.hashCode();
    }

    /**
     * Checks whether given object is of this class type
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof ClassType && name.equals(((ClassType) other).getName()) && parametricTypes.equals(((ClassType) other).parametricTypes);
    }
}
