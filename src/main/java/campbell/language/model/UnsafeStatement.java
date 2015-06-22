package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class UnsafeStatement extends Statement {
    private List<? extends Statement> statements;

    public UnsafeStatement(List<? extends Statement> statements) {
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.UnsafeContext unsafe) {
        return new UnsafeStatement(Statement.fromContexts(unsafe.block().statement()));
    }
}
