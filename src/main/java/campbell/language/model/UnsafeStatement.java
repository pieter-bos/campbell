package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class UnsafeStatement extends Statement {
    private List<Statement> statements;

    public UnsafeStatement(List<Statement> statements) {
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.UnsafeContext unsafe) {
        return null;
    }
}
