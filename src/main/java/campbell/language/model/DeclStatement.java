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
        return null;
    }

    public static List<DeclStatement> fromContexts(List<CampbellParser.DeclContext> decl, boolean... javaIsStom) {
        List<DeclStatement> result = new LinkedList<>();
        for (CampbellParser.DeclContext i : decl) {
            result.add(fromContext(i));
        }
        return result;
    }
}
