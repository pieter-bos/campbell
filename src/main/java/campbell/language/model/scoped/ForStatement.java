package campbell.language.model.scoped;

import campbell.language.model.unscoped.Expression;
import campbell.language.model.Statement;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ForStatement extends Scope {
    private final Expression var;
    private final Expression iterable;
    private final List<? extends Statement> statements;

    public ForStatement(Expression var, Expression iterable, List<? extends Statement> statements) {
        this.var = var;
        this.iterable = iterable;
        this.statements = statements;
    }

    public static ForStatement fromContext(CampbellParser.ForNodeContext forNodeContext) {
        Expression arg = Expression.fromContext(forNodeContext.expr(0));
        Expression args = Expression.fromContext(forNodeContext.expr(1));
        List<? extends Statement> block = Statement.fromContexts(forNodeContext.block().statement());

        return at(forNodeContext.getStart(), new ForStatement(arg, args, block));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        var.setScope(this);
        iterable.setScope(scope);

        for(Statement stat : statements) {
            stat.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "for " + var.toString(0) + " in " + iterable.toString(0);

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }
}
