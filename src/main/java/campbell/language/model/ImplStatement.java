package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ImplStatement extends Statement {
    private final ClassType type;
    private final List<Type> of;
    private final List<? extends Statement> statements;

    public ImplStatement(ClassType type, List<Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public ImplStatement(ClassType type, List<Type> of, List<Statement> statements) {
        this.type = type;
        this.of = of;
        this.statements = statements;
    }

    public static ImplStatement fromContext(CampbellParser.ImplContext impl) {
        Type type = Type.fromContext(impl.className());
        List<? extends Statement> statements = Statement.fromContexts(impl.block().statement());

        if(impl.classList() != null) {
            List<Type> of = Type.fromContexts(impl.classList().className());
            return new ImplStatement(type, of, statements);
        } else {

        }
    }
}
