package campbell.roborovski.model;

public class Assign extends Statement {
    private final Expression left;
    private final Expression right;

    public Assign(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
