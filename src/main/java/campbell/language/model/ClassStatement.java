package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ClassStatement extends Statement {
    private ClassType type;
    private final List<Statement> statements;

    public ClassStatement(ClassType type, List<Statement> statements) {
        this.type = type;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.ClassNodeContext classNodeContext) {
        return null;
    }
}
