package campbell.language.model;

public class MathExpression extends Expression {
    private final Expression left;
    private final MathOp op;
    private final Expression right;

    public enum MathOp {
        Add,
        Subtract,
        Multiply,
        Divide,
        Modulo
    }

    public MathExpression(Expression left, MathOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
