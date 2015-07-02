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
    private String id;

    public IdentifierExpression(String id) {
        this.id = id;
    }

    public static IdentifierExpression fromContext(TerminalNode ctx) {
        return at(ctx.getSymbol(), new IdentifierExpression(ctx.getText()));
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + id;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Type getType() {
        return requireSymbol(id, this).getType();
    }

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

    @Override
    public Expression deepCopy() {
        return new IdentifierExpression(id);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    public String getId() {
        return id;
    }
}
