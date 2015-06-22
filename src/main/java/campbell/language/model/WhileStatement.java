package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class WhileStatement extends Scope {
    private final Expression condition;
    private final List<? extends Statement> statements;

    public WhileStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.WhileNodeContext whileNodeContext) {
        return new WhileStatement(Expression.fromContext(whileNodeContext.expr()), Statement.fromContexts(whileNodeContext.block().statement()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        this.condition.setScope(scope);

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "while " + condition.toString(0);

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }
}
