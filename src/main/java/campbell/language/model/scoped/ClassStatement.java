package campbell.language.model.scoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ClassStatement extends Scope {
    private ClassType type;
    private final List<? extends Statement> statements;

    public ClassStatement(ClassType type, List<? extends Statement> statements) {
        this.type = type;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.ClassNodeContext classNodeContext) {
        Type type = Type.fromContext(classNodeContext.className());

        if(type instanceof ClassType) {
            return at(classNodeContext.getStart(), new ClassStatement((ClassType) type, Statement.fromContexts(classNodeContext.block().statement())));
        } else {
            throw new CompileException(classNodeContext.getStart(), "ClassStatement", "Expected a class type, but got " + type.toString());
        }

    }

    public Type getType() {
        return type;
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
        String result = indent(indent) + "class " + type + " " + getComment();

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }

    @Override
    public void findDefinitions() {
        for(Statement stat : statements) {
            if(stat instanceof DeclStatement) {
                symbols.put(((DeclStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof FunStatement) {
                symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof ClassStatement) {
                classes.put(((ClassStatement) stat).getType().getName(), (ClassStatement) stat);
            }

            if(stat instanceof Scope) {
                ((Scope) stat).findDefinitions();
            }
        }
    }

    public String getName() {
        return type.getName();
    }
}
