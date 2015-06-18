package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ImplStatement extends Statement {
    private final ClassType type;
    private final List<ClassType> of;
    private final List<Statement> statements;

    public ImplStatement(ClassType type, List<Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public ImplStatement(ClassType type, List<ClassType> of, List<Statement> statements) {
        this.type = type;
        this.of = of;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.ImplContext impl) {
        return null;
    }
}
