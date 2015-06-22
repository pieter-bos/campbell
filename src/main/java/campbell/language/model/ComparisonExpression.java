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
        NotEquals
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
}