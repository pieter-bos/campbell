package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class TraitStatement extends Statement {
    private final ClassType type;
    private final List<ClassType> of;
    private final List<Statement> statements;

    public TraitStatement(ClassType type, List<Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public TraitStatement(ClassType type, List<ClassType> of, List<Statement> statements) {
        this.type = type;
        this.of = of;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.TraitContext trait) {
        return null;
    }
}
