package campbell.language.model;

public class UnaryMathExpression {
    private final UnaryMathOp op;
    private final Expression expr;

    public enum UnaryMathOp {
        Negate
    }

    public UnaryMathExpression(UnaryMathOp op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }
}
