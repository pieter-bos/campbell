package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class ComparisonExpression extends Expression {
    private final Expression left;
    private final ComparisonOp op;
    private final Expression right;

    public enum ComparisonOp {
        LessThan,
        GreaterThan,
        LessThanEquals,
        GreaterThanEquals,
        Equals,
        NotEquals;
    }
    public ComparisonExpression(Expression left, ComparisonOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public static ComparisonExpression fromContext(CampbellParser.LtContext ctx) {
        return new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.LessThan, Expression.fromContext(ctx.expr1(1)));
    }

    public static ComparisonExpression fromContext(CampbellParser.LteContext ctx) {
        return new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.LessThanEquals, Expression.fromContext(ctx.expr1(1)));
    }

    public static ComparisonExpression fromContext(CampbellParser.GtContext ctx) {
        return new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.GreaterThan, Expression.fromContext(ctx.expr1(1)));
    }

    public static ComparisonExpression fromContext(CampbellParser.GteContext ctx) {
        return new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.GreaterThanEquals, Expression.fromContext(ctx.expr1(1)));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        left.setScope(scope);
        right.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        switch(op) {
            case LessThan:
                return indent(indent) + "(" + left.toString(0) + " < " + right.toString(0) + ")";
            case LessThanEquals:
                return indent(indent) + "(" + left.toString(0) + " <= " + right.toString(0) + ")";
            case GreaterThan:
                return indent(indent) + "(" + left.toString(0) + " > " + right.toString(0) + ")";
            case GreaterThanEquals:
                return indent(indent) + "(" + left.toString(0) + " >= " + right.toString(0) + ")";
        }

        return null;
    }
}