package campbell.language.types;

/**
 * Type for pointers
 *
 * TODO: Unused at the moment?
 */
public class PointerType extends Type {
    /**
     * Type that is referenced to by the pointer
     */
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
