package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class IfStatement extends Scope {
    private final Expression condition;
    private final List<? extends Statement> statements;
    private final List<? extends Statement> elseStatements;

    public IfStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = statements;
        this.elseStatements = null;
    }

    public IfStatement(Expression condition, List<? extends Statement> statements, List<? extends Statement> elseStatements) {
        this.condition = condition;
        this.statements = statements;
        this.elseStatements = elseStatements;
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
        for (Statement s : statements) {
            s.setScope(this);
        }

        if (elseStatements != null) {
            for (Statement st : elseStatements) {
                st.setScope(this);
            }
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "if " + condition.toString(0);

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        if(elseStatements != null) {
            result += "\n" + indent(indent) + "else";

            for(Statement stat : elseStatements) {
                result += "\n" + stat.toString(indent + 1);
            }
        }

        return result;
    }
}
