package campbell.language.model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class IdentifierExpression extends Expression {
    private String id;

    public IdentifierExpression(String id) {
        this.id = id;
    }

    public static IdentifierExpression fromContext(TerminalNode ctx) {
        return new IdentifierExpression(ctx.getText());
    }
}
