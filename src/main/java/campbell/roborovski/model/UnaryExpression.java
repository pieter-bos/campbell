package campbell.roborovski.model;

public class UnaryExpression {
    public enum UnaryOp {

    }

    private final UnaryOp op;
    private final Expression arg;

    public UnaryExpression(UnaryOp op, Expression arg) {
        this.op = op;
        this.arg = arg;
    }
}
