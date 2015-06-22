package campbell.language.model;

import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.LinkedList;
import java.util.List;

public class DeclStatement extends Statement {
    private final Type type;
    private final String name;

    public DeclStatement(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public static DeclStatement fromContext(CampbellParser.DeclContext decl) {
        return new DeclStatement(Type.fromContext(decl.className()), decl.IDENTIFIER().getText());
    }

    public static List<DeclStatement> fromContexts(List<CampbellParser.DeclContext> decl, boolean... javaIsStom) {
        List<DeclStatement> result = new LinkedList<>();
        for (CampbellParser.DeclContext i : decl) {
            result.add(fromContext(i));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static List<? extends DeclStatement> fromContexts(List untypedStatements) {
        List<CampbellParser.DeclContext> statements = (List<CampbellParser.DeclContext>) untypedStatements;
        LinkedList<DeclStatement> result = new LinkedList<>();

        for(CampbellParser.DeclContext ctx : statements) {
            result.add(fromContext(ctx));
        }

        return result;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + type.toString() + " " + name;
    }
}
