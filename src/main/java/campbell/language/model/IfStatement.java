package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class IfStatement extends Statement {
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
}
