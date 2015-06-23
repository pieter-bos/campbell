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
}
