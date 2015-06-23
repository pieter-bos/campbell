package campbell.language.types;

public class FunctionType extends Type {
    private final Type returnType;
    private final Type argument;

    public FunctionType(Type returnType, Type argument) {
        this.returnType = returnType;
        this.argument = argument;
    }

    @Override
    public String getName() {
        return null;
    }
}