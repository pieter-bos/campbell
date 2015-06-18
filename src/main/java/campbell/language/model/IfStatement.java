package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class IfStatement extends Statement {
    private final Expression condition;
    private final List<Statement> statements;
    private final List<Statement> elseStatements;

    public IfStatement(Expression condition, List<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
        this.elseStatements = null;
    }

    public IfStatement(Expression condition, List<Statement> statements, List<Statement> elseStatements) {
        this.condition = condition;
        this.statements = statements;
        this.elseStatements = elseStatements;
    }

    public static Statement fromContext(CampbellParser.IfNodeContext ifNodeContext) {
        return null;
    }
}
