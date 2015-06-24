package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class ImplStatement extends Scope {
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
            return at(impl.getStart(), new ImplStatement(type, of, statements));
        } else {
            return at(impl.getStart(), new ImplStatement(type, statements));
        }
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "impl " + type.toString();

        if(of != null) {
            result += " of ";

            if(of.size() == 1) {
                result += of.get(0).toString();
            } else {
                result += "(";

                boolean firstType = true;

                for(Type t : of) {
                    if(!firstType) {
                        result += ", ";
                    }

                    firstType = false;

                    result += t.toString();
                }

                result += ")";
            }
        }

        result += " " + getComment();

        for(Statement stat : statements) {
            result += "\n"  + stat.toString(indent + 1);
        }

        return result;
    }

    @Override
    public void findDefinitions() {
        for(Statement stat : statements) {
            if(stat instanceof FunStatement) {
                symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof DeclStatement) {
                symbols.put(((DeclStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof ClassStatement) {
                types.put(((ClassStatement) stat).getType().getName(), ((ClassStatement) stat).getType());
            }

            if(stat instanceof Scope) {
                ((Scope) stat).findDefinitions();
            }
        }
    }

    @Override
    public void findImpls() {
        for(Statement stat : statements) {
            if(stat instanceof Scope) {
                ((Scope) stat).findImpls();
            }

            if(stat instanceof FunStatement) {
                getScope().symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            }
        }
    }
}
