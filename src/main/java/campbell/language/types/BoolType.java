package campbell.language.types;

public class BoolType extends PrimitiveType {
    @Override
    public String toString() {
        return "bool";
    }

    @Override
    public String getName() {
        return "bool";
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    @Override
    public int hashCode() {
        return "bool".hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof BoolType;
    }
}
