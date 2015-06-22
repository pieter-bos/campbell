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

    }

    public static ComparisonExpression fromContext(CampbellParser.LteContext ctx) {

    }

    public static ComparisonExpression fromContext(CampbellParser.GtContext ctx) {

    }

    public static ComparisonExpression fromContext(CampbellParser.GteContext ctx) {

    }
}
