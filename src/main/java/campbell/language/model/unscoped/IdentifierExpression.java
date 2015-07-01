package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.roborovski.model.FunctionExpression;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.VariableExpression;
import org.antlr.v4.runtime.tree.TerminalNode;

public class IdentifierExpression extends Expression {
    /**
     * Identifier's string representation
     */
    private String id;

    public IdentifierExpression(String id) {
        this.id = id;
    }

    public static IdentifierExpression fromContext(TerminalNode ctx) {
        return at(ctx.getSymbol(), new IdentifierExpression(ctx.getText()));
    }

    /**
     * Makes a string representation of this identifier expression with given indent
     * @param indent
     * @return
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + id;
    }

    /**
     * Sets the scope of this identifier expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Returns the type of this identifier
     *
     * It will try to find a declaration, function or class with the same name.
     * @return
     */
    @Override
    public Type getType() {
        return requireSymbol(id, this).getType();
    }

    /**
     * Converts this identifier expression to the IR Roborovski
     * @param program
     * @return
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        Symbol symbol = requireSymbol(id, this);

        if(symbol instanceof FunStatement) {
            return new FunctionExpression(((FunStatement) symbol).getFunction());
        } else if(symbol instanceof DeclStatement) {
            return new VariableExpression(((DeclStatement) symbol).getVariable());
        }

        throw new CompileException(this, "Internal error: Unknown identifier implementation type " + symbol.getClass());
    }

    /**
     * Makes a deep copy of this identifier expression
     * @return deep copy of identifier expression
     */
    @Override
    public Expression deepCopy() {
        return new IdentifierExpression(id);
    }

    /**
     * Replaces a given type by another given type within this identifier expression
     *
     * An identifier expression contains no types thus nothing is done
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    /**
     * Type checking for identifiers
     *
     * Nothing to be done.
     */
    @Override
    public void checkType() {
        // Nop
    }
}
