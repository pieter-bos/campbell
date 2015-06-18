package campbell.language.model;

import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class FunStatement extends Statement {
    private Type returnType;
    private final String name;
    private final List<DeclStatement> arguments;

    public FunStatement(Type returnType, String name, List<DeclStatement> arguments) {
        this.returnType = returnType;
        this.name = name;
        this.arguments = arguments;
    }

    public static Statement fromContext(CampbellParser.FunContext fun) {
        return null;
    }
}
