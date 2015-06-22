package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ForStatement extends Statement {
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

        return new ForStatement(arg, args, block);
    }
}
