package campbell.language.types;

public class VoidType extends PrimitiveType {
    @Override
    public String getName() {
        return "void";
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    @Override
    public int hashCode() {
        return "void".hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof VoidType;
    }
}
