package campbell.language.types;

public class FunctionType {
    private final Type returnType;
    private final Type argument;

    public FunctionType(Type returnType, Type argument) {
        this.returnType = returnType;
        this.argument = argument;
    }
}