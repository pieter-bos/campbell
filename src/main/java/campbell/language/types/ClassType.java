package campbell.language.types;

import java.util.List;

public class ClassType extends Type {
    private final String name;
    private final List<Type> parametricTypes;

    public ClassType(String name, List<Type> parametricTypes) {
        this.name = name;
        this.parametricTypes = parametricTypes;
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
}
