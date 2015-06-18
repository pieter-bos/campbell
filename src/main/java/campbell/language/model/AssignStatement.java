package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class AssignStatement extends Statement {
    private final Expression left;
    private final Expression right;

    public AssignStatement(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public static AssignStatement fromContext(CampbellParser.AssignContext assign) {
        return new AssignStatement(Expression.fromContext(assign.expr(0)), Expression.fromContext(assign.expr(1)));
    }
}
