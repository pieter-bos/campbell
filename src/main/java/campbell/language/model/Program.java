package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class Program {
    private List<Statement> statements;

    public Program(List<Statement> statements) {
        this.statements = statements;
    }

    public static Program fromContext(CampbellParser.ProgramContext context) {
        return new Program(Statement.fromContexts(context.statement()));
    }
}