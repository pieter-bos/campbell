package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class DotExpression extends Expression {
    private final Expression expr;
    private final String property;

    public DotExpression(Expression expr, String property) {
        this.expr = expr;
        this.property = property;
    }

    public static DotExpression fromContext(CampbellParser.GetContext ctx, Expression expr) {
        return new DotExpression(expr, ctx.IDENTIFIER().getText());
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        expr.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "(" + expr.toString(0) + "." + property + ")";
    }
}
