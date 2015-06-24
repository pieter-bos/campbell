package campbell.language.model.scoped;

import campbell.language.model.unscoped.DeclStatement;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class FunStatement extends Scope implements Symbol {
    private Type returnType;
    private String name;
    private List<? extends DeclStatement> arguments;
    private List<? extends Statement> statements;

    public FunStatement(Type returnType, String name, List<? extends DeclStatement> arguments) {
        this.returnType = returnType;
        this.name = name;
        this.arguments = arguments;
        this.statements = null;
    }

    public FunStatement(Type returnType, String name, List<? extends DeclStatement> arguments, List<? extends Statement> statements) {
        this.returnType = returnType;
        this.name = name;
        this.arguments = arguments;
        this.statements = statements;
    }

    public static FunStatement fromContext(CampbellParser.FunContext fun) {
        if(fun.block() == null) {
            return at(fun.getStart(), new FunStatement(Type.fromContext(fun.className()), fun.IDENTIFIER().getText(), DeclStatement.fromContexts(fun.decl())));
        } else {
            return at(fun.getStart(), new FunStatement(Type.fromContext(fun.className()), fun.IDENTIFIER().getText(), DeclStatement.fromContexts(fun.decl()),
                    Statement.fromContexts(fun.block().statement())));
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "fun " + returnType.toString() + " " + name + "(";

        boolean firstArgument = true;

        for(DeclStatement decl : arguments) {
            if(!firstArgument) {
                result += ", ";
            }

            firstArgument = false;

            result += decl.toString(0);
        }

        result += ") " + getComment();

        if(statements != null) {
            for(Statement stat : statements) {
                result += "\n" + stat.toString(indent + 1);
            }
        }

        return result;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for(DeclStatement decl : arguments) {
            decl.setScope(this);
        }

        if(statements != null) {
            for(Statement stat : statements) {
                stat.setScope(this);
            }
        }
    }

    @Override
    public void findDefinitions() {
        if(!isAbstract()) {
            for (DeclStatement decl : arguments) {
                symbols.put(decl.getName(), decl);
            }

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
    }

    @Override
    public void findImpls() {
        if(statements != null) {
            for(Statement stat : statements) {
                if(stat instanceof Scope) {
                    ((Scope) stat).findImpls();
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAbstract() {
        return statements == null;
    }
}
