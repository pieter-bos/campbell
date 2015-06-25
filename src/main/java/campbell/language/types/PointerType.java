package campbell.language.types;

public class PointerType extends Type {
    private Type referencedType;

    public PointerType(Type referencedType) {
        this.referencedType = referencedType;
    }

    @Override
    public String toString() {
        return "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    }

    @Override
    public String getName() {
        return ">>>>>>>>>>>>>" + referencedType.getName();
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }
}
