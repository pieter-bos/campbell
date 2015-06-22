package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class TraitStatement extends Statement {
    private final Type type;
    private final List<? extends Type> of;
    private final List<? extends Statement> statements;

    public TraitStatement(Type type, List<? extends Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public TraitStatement(Type type, List<? extends Type> of, List<? extends Statement> statements) {
        this.type = type;
        this.of = of;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.TraitContext trait) {
        Type type = Type.fromContext(trait.className());
        List<? extends Statement> statements = Statement.fromContexts(trait.block().statement());

        if(trait.classList() != null) {
            List<Type> of = Type.fromContexts(trait.classList().className());
            return new TraitStatement(type, of, statements);
        } else {
            return new TraitStatement(type, statements);
        }
    }
}
