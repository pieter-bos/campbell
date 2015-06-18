package campbell.language.types;

public class PointerType {
    private Type referencedType;

    public PointerType(Type referencedType) {
        this.referencedType = referencedType;
    }
}
