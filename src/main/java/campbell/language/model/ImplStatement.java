package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ImplStatement extends Statement {
    private final Type type;
    private final List<Type> of;
    private final List<? extends Statement> statements;

    public ImplStatement(Type type, List<? extends Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public ImplStatement(Type type, List<Type> of, List<? extends Statement> statements) {
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
            return new ImplStatement(type, statements);
        }
    }
}
