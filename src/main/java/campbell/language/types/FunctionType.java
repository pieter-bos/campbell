package campbell.language.types;

public class FunctionType extends Type {
    private Type returnType;
    private Type argument;

    public FunctionType(Type returnType, Type argument) {
        this.returnType = returnType;
        this.argument = argument;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        if(returnType.getName().equals(replace.getName())) {
            returnType = replaceWith;
        } else {
            returnType.replaceType(replace, replaceWith);
        }

        if(argument.getName().equals(replace.getName())) {
            argument = replaceWith;
        } else {
            returnType.replaceType(replace, replaceWith);
        }
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public int hashCode() {
        return (returnType.hashCode() * 139) ^ argument.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof FunctionType && returnType.equals(((FunctionType) other).returnType) && argument.equals(((FunctionType) other).argument);
    }
}