package campbell.language.model;

public class ComparisonExpression {
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
}
