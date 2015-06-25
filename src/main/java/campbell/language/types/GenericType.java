package campbell.language.types;

public class GenericType extends Type {
    private String name;

    public GenericType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ 0x1a2b3c4d;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof GenericType && name.equals(((GenericType) other).name);
    }
}
