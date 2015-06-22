package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ClassStatement extends Scope {
    private Type type;
    private final List<? extends Statement> statements;

    public ClassStatement(Type type, List<? extends Statement> statements) {
        this.type = type;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.ClassNodeContext classNodeContext) {
        return new ClassStatement(Type.fromContext(classNodeContext.className()), Statement.fromContexts(classNodeContext.block().statement()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for(Statement stat : statements) {
            stat.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "class " + type;

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }
}
