package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.*;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Function;
import campbell.roborovski.model.Program;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FunStatement extends Scope implements Symbol {
    /**
     * Return type of the function
     */
    private Type returnType;
    /**
     * Name of the function
     */
    private String name;
    /**
     * List of the arguments of the function
     */
    private List<DeclStatement> arguments;
    /**
     * List containing all statements in this function
     */
    private List<? extends Statement> statements;
    private Function func = new Function();

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

    /**
     * Makes a string representation of this function with correct indenting and all its statements
     * @param indent - indent level of this function
     * @return string representation of this function
     */
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

    /**
     * Converts this function to the IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        program.addFunction(func);
        func.setBlock(block);

        for(DeclStatement decl : arguments) {
            decl.toRoborovski(program, func);
        }

        if(statements != null) {
            for(Statement stat : statements) {
                stat.toRoborovski(program, func.getStatementBlock());
            }
        }
    }

    /**
     * Makes a deep copy of this function
     * @return deep copy of this function
     */
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

    /**
     * Replaces a given type by another given type within this function
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
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

    /**
     * Sets the scope for this function, its arguments and statements
     * @param scope - Scope of this function
     */
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

    /**
     * Finds definitions in this function.
     * Definition can be a function, declaration or a class.
     */
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

    /**
     * Finds implementations in this scope
     */
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

    /**
     * Returns the name of this function
     * @return name of this function
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Function of this function
     * @return Function of this function
     */
    public Function getFunction() {
        return func;
    }

    /**
     * Returns list of all arguments of this function
     * @return list of arguments of this function
     */
    public List<DeclStatement> getArguments() {
        return arguments;
    }

    /**
     * Returns the type of this function (which is always null at the moment)
     */
    @Override
    public Type getType() {
         return new FunctionType(returnType, arguments.get(0).getType());
    }

    /**
     * Checks whether this function is abstract
     * A function is abstract if it has no statements
     * @return whether a function is abstract
     */
    public boolean isAbstract() {
        return statements == null;
    }

    /**
     * Type checking for functions
     */
    @Override
    public void checkType() {
        if (returnType instanceof PrimitiveType || returnType instanceof ClassType ||
                returnType instanceof FunctionType || returnType instanceof GenericType) {
            for (DeclStatement decl : arguments) {
                if (!(decl.getType() instanceof GenericType)) {
                    decl.checkType();
                }
            }
            for (Statement stat : statements) {
                stat.checkType();
            }
        }
    }
}
