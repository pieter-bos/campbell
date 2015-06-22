package campbell.language.model;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;

public class IntLiteralExpression extends Expression {
    private BigInteger value;

    public IntLiteralExpression(String value) {
        this.value = new BigInteger(value);
    }

    public static IntLiteralExpression fromContext(TerminalNode ctx) {
        return new IntLiteralExpression(ctx.getText());
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return value.toString();
    }
}
