package campbell.language.types;

public class IntType extends PrimitiveType {
    @Override
    public String toString() {
        return "int";
    }

    @Override
    public String getName() {
        return "int";
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    @Override
    public int hashCode() {
        return "int".hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof IntType;
    }
}
