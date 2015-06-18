package campbell.language.model;

public class DotExpression {
    private final Expression expr;
    private final String property;

    public DotExpression(Expression expr, String property) {
        this.expr = expr;
        this.property = property;
    }
}
