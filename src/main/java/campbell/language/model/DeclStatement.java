package campbell.language.model;

import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

public class DeclStatement extends Statement {
    private final Type type;
    private final String name;

    public DeclStatement(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public static Statement fromContext(CampbellParser.DeclContext decl) {
        return null;
    }
}
