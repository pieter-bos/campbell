package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ClassStatement extends Statement {
    private Type type;
    private final List<? extends Statement> statements;

    public ClassStatement(Type type, List<? extends Statement> statements) {
        this.type = type;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.ClassNodeContext classNodeContext) {
        return new ClassStatement(Type.fromContext(classNodeContext.className()), Statement.fromContexts(classNodeContext.block().statement()));
    }
}
