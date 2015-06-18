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

    public static FunStatement fromContext(CampbellParser.FunContext fun) {
        return new FunStatement(Type.fromContext(fun.className()), fun.IDENTIFIER().getText(),DeclStatement.fromContexts(fun.decl()));
    }
}
