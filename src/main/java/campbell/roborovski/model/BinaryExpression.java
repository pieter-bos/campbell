package campbell.roborovski.model;

public class BinaryExpression extends Expression {
    public enum BinaryOp {
        LessThan,
        GreaterThan,
        LessThanEquals,
        GreaterThanEquals,
        Equals,
        NotEquals
    }

    private final Expression left;
    private final BinaryOp op;
    private final Expression right;

    public BinaryExpression(Expression left, BinaryOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
