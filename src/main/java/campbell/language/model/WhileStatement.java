package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class WhileStatement extends Statement {
    private final Expression condition;
    private final List<? extends Statement> statements;

    public WhileStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.WhileNodeContext whileNodeContext) {
        return new WhileStatement(Expression.fromContext(whileNodeContext.expr()), Statement.fromContexts(whileNodeContext.block().statement()));
    }
}
