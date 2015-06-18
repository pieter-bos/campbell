package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import javax.swing.plaf.nimbus.State;
import java.util.List;

public class ForStatement extends Statement {
    private final Expression var;
    private final Expression iterable;
    private final List<Statement> statements;

    public ForStatement(Expression var, Expression iterable, List<Statement> statements) {
        this.var = var;
        this.iterable = iterable;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.ForNodeContext forNodeContext) {
        return null;
    }
}
