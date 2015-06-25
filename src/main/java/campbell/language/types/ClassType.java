package campbell.language.types;

import campbell.language.model.CompileException;
import util.HashList;

import java.util.List;

public class ClassType extends Type {
    private final String name;
    private final HashList<Type> parametricTypes;

    public ClassType(String name, List<Type> parametricTypes) {
        this.name = name;
        this.parametricTypes = new HashList<>();
        this.parametricTypes.addAll(parametricTypes);
    }

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        parametricTypes.replaceAll(t -> t.getName().equals(replace.getName()) ? replaceWith : t);
    }

    public List<Type> getParametricTypes() {
        return parametricTypes;
    }

    @Override
    public int hashCode() {
        return (parametricTypes.hashCode() * 137) ^ name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ClassType && name.equals(((ClassType) other).getName()) && parametricTypes.equals(((ClassType) other).parametricTypes);
    }
}
