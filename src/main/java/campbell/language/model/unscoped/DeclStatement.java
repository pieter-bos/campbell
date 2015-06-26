package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Variable;

import java.util.LinkedList;
import java.util.List;

public class DeclStatement extends Statement implements Symbol {
    private Type type;
    private final String name;
    private Variable variable = null;

    public DeclStatement(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public static DeclStatement fromContext(CampbellParser.DeclContext decl) {
        return at(decl.getStart(), new DeclStatement(Type.fromContext(decl.className()), decl.IDENTIFIER().getText()));
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

    @Override
    public void toRoborovski(Program program, Block block) {
        variable = new Variable(name);
        block.addVariable(variable);
    }

    @Override
    public DeclStatement deepCopy() {
        return new DeclStatement(type, name);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        if(type.getName().equals(replace.getName())) {
            type = replaceWith;
        } else {
            type.replaceType(replace, replaceWith);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public Variable getVariable() {
        return variable;
    }
}
