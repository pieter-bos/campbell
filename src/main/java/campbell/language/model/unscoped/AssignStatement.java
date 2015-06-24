package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.model.Statement;
import campbell.parser.gen.CampbellParser;

public class AssignStatement extends Statement {
    private final Expression left;
    private final Expression right;

    public AssignStatement(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public static AssignStatement fromContext(CampbellParser.AssignContext assign) {
        // TODO decl
        return at(assign.getStart(), new AssignStatement(Expression.fromContext(assign.expr(0)), Expression.fromContext(assign.expr(1))));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        left.setScope(scope);
        right.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        return left.toString(indent) + " = " + right.toString(0);
    }
}