package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
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
        return findSymbol(id).getType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski() {
        return null;
    }

    @Override
    public Expression deepCopy() {
        return new IdentifierExpression(id);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }
}
