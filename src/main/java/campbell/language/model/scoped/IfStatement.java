package campbell.language.model.scoped;

import campbell.language.model.unscoped.Expression;
import campbell.language.model.Statement;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class IfStatement extends Scope {
    private final Expression condition;
    private final BlockStatement statements;
    private final BlockStatement elseStatements;

    public IfStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = new BlockStatement(statements);
        this.elseStatements = null;
    }

    public IfStatement(Expression condition, List<? extends Statement> statements, List<? extends Statement> elseStatements) {
        this.condition = condition;
        this.statements = new BlockStatement(statements);
        this.elseStatements = new BlockStatement(elseStatements);
    }

    public static IfStatement fromContext(CampbellParser.IfNodeContext ifNodeContext) {
        Expression condition = Expression.fromContext(ifNodeContext.expr());
        List<? extends Statement> block1 = fromContexts(ifNodeContext.block(0).statement());

        if (ifNodeContext.block().size() != 1) {
            return new IfStatement(condition, block1, fromContexts(ifNodeContext.block(1).statement()));
        } else {
            return new IfStatement(condition, block1);
        }
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        this.condition.setScope(scope);

        statements.setScope(scope);

        if (elseStatements != null) {
            elseStatements.setScope(scope);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "if " + condition.toString(0) + "\n";

        result += statements.toString(indent + 1);

        if(elseStatements != null) {
            result += "\n" + indent(indent) + "else" + "\n";
            result += elseStatements.toString(indent + 1);
        }

        return result;
    }

    @Override
    public void findDefinitions() {
        statements.findDefinitions();

        if(elseStatements != null) {
            elseStatements.findDefinitions();
        }
    }
}
