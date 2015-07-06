package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.Scope;
import campbell.language.types.BoolType;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Variable;

/**
 * Declaration for a shared variable
 */
public class SharedDeclStatement extends Statement implements Symbol {
    /**
     * Type of the variable
     */
    private final Type type;

    /**
     * Name of the variable
     */
    private final String name;

    /**
     * Variable
     */
    private Variable variable;

    public SharedDeclStatement(Type type, String name) {
        this.type = type;
        this.name = name;
        this.variable = new Variable(name);
    }

    /**
     * Sets the scope for this shared declaration
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Returns a string representation of this shared declaration with correct indenting
     * @param indent
     * @return
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + "shared " + type.toString() + " " + name;
    }

    /**
     * Converts this shared declaration to IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        program.addSharedVariable(variable);
    }

    /**
     * Makes a deep copy of this shared declaration
     * @return
     */
    @Override
    public Statement deepCopy() {
        return new SharedDeclStatement(type, name);
    }

    /**
     * Replaces a given type by another given type within this shared declaration statement
     *
     * Shared declaration does not contain types that can be replaced
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // n/a
    }

    /**
     * Method that checks whether this shared declaration returns
     *
     * Shared declarations never return
     * @return
     */
    @Override
    public boolean returns() {
        return false;
    }

    /**
     * Type checking for shared declarations
     *
     * Shared variable declaration must be of primitive type: int, bool
     */
    @Override
    public void checkType() {
        if(!(type instanceof IntType) && !(type instanceof BoolType)) {
            throw new CompileException(this, "A shared variable declaration must always be of a primitive type.");
        }
    }

    /**
     * Tries to parse shared declaration statement from a given context
     * @param ctx
     * @return
     */
    public static SharedDeclStatement fromContext(CampbellParser.SharedDeclContext ctx) {
        return at(ctx.getStart(), new SharedDeclStatement(Type.fromContext(ctx.decl().className()), ctx.decl().IDENTIFIER().getText()));
    }

    /**
     * Returns the name of the shared declared variable
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the shared declared variable
     * @return
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * Returns the variable of the shared declared variable
     * @return
     */
    public Variable getVariable() {
        return variable;
    }
}
