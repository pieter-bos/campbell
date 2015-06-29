package campbell.language.model.scoped;

import campbell.language.model.unscoped.DeclStatement;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;
import org.antlr.v4.codegen.model.decl.Decl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FunStatement extends Scope implements Symbol {
    private Type returnType;
    private String name;
    private List<DeclStatement> arguments;
    private List<? extends Statement> statements;
    private Function func;

    public FunStatement(Type returnType, String name, List<? extends DeclStatement> arguments) {
        this.returnType = returnType;
        this.name = name;
        this.arguments = new LinkedList<>();
        this.arguments.addAll(arguments);
        this.statements = null;
    }

    public FunStatement(Type returnType, String name, List<? extends DeclStatement> arguments, List<? extends Statement> statements) {
        this.returnType = returnType;
        this.name = name;
        this.arguments = new LinkedList<>();
        this.arguments.addAll(arguments);
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
    public void toRoborovski(Program program, Block block) {
        func = new Function();
        program.addFunction(func);

        for(DeclStatement decl : arguments) {
            decl.toRoborovski(program, func);
        }

        if(statements != null) {
            for(Statement stat : statements) {
                stat.toRoborovski(program, func.getStatementBlock());
            }
        }
    }

    @Override
    public FunStatement deepCopy() {
        if(statements == null) {
            return new FunStatement(returnType, name, arguments.stream().map(DeclStatement::deepCopy).collect(Collectors.toList()));
        } else {
            return new FunStatement(returnType, name,
                    arguments.stream().map(DeclStatement::deepCopy).collect(Collectors.toList()),
                    statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
        }
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        returnType.replaceType(replace, replaceWith);

        if(returnType.getName().equals(replace.getName())) {
            returnType = replaceWith;
        }

        for(DeclStatement stat : arguments) {
            stat.replaceType(replace, replaceWith);
        }

        if(statements != null) {
            for(Statement stat : statements) {
                stat.replaceType(replace, replaceWith);
            }
        }
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

    public Function getFunction() {
        return func;
    }

    public List<DeclStatement> getArguments() {
        return arguments;
    }

    @Override
    public Type getType() {
        return null;
    }

    public boolean isAbstract() {
        return statements == null;
    }
}
