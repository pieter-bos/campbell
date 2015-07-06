package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.Scope;
import campbell.language.types.PrimitiveType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Variable;

public class SharedDeclStatement extends Statement implements Symbol {
    private final Type type;
    private final String name;
    private Variable variable;

    public SharedDeclStatement(Type type, String name) {
        this.type = type;
        this.name = name;
        this.variable = new Variable(name);
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "shared " + type.toString() + " " + name;
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        program.addSharedVariable(variable);
    }

    @Override
    public Statement deepCopy() {
        return new SharedDeclStatement(type, name);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // n/a
    }

    @Override
    public boolean returns() {
        return false;
    }

    @Override
    public void checkType() {
        if(!(type instanceof PrimitiveType)) {
            throw new CompileException(this, "A shared variable declaration must always be of a primitive type.");
        }
    }

    public static SharedDeclStatement fromContext(CampbellParser.SharedDeclContext ctx) {
        return at(ctx.getStart(), new SharedDeclStatement(Type.fromContext(ctx.decl().className()), ctx.decl().IDENTIFIER().getText()));
    }

    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public Variable getVariable() {
        return variable;
    }
}
