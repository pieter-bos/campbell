package campbell.language.types;

import java.util.List;

public class ClassType extends Type {
    private final String name;
    private final List<Type> parametricTypes;

    public ClassType(String name, List<Type> parametricTypes) {
        this.name = name;
        this.parametricTypes = parametricTypes;
    }
}
