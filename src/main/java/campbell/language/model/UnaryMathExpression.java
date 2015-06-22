package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class UnaryMathExpression extends Expression {
    private final UnaryMathOp op;
    private final Expression expr;

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        expr.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        String inner = expr.toString(0);

        switch(op) {
            case Negate:
                return indent(indent) + "(-" + inner + ")";
        }

        return null;
    }

    public enum UnaryMathOp {
        Negate;
    }
    public UnaryMathExpression(UnaryMathOp op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public static Expression fromContext(CampbellParser.NegateContext ctx) {
        return new UnaryMathExpression(UnaryMathOp.Negate, Expression.fromContext(ctx.expr()));
    }
}
