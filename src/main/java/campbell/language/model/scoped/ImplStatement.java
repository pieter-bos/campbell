package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.FunctionType;
import campbell.language.types.GenericType;
import campbell.language.types.PrimitiveType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

import java.util.List;
import java.util.stream.Collectors;

public class ImplStatement extends Scope {
    /**
     * Type of this implementation
     */
    private final Type type;
    private final List<Type> of;
    /**
     * List containing all statements in this scope
     */
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

    /**
     * Sets the scope of this implementation and all its statements
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    /**
     * Makes a string representation of this implementation with correct indenting and all its statements
     * @param indent - indent level of this implementation
     * @return string representation of this implementation
     */
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

    /**
     * Converts this implementation to the IR Roborovski
     *
     * Implementations are not an element in Roborovski thus nothing is done
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        // nop
    }

    /**
     * Makes a deep copy of this implementation and its types and statements
     * @return deep copy of this implementation
     */
    @Override
    public ImplStatement deepCopy() {
        if(of == null) {
            return new ImplStatement(type, statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
        } else {
            return new ImplStatement(type, of, statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
        }
    }

    /**
     * Replaces a given type by another given type within this implementation
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        type.replaceType(replace, replaceWith);

        if (of != null){
            for (Type t : of) {
                t.replaceType(replace, replaceWith);
            }
        }

        for (Statement s : statements) {
            s.replaceType(replace, replaceWith);
        }

    }

    /**
     * Finds definitions in this implementation
     * Definition can be a function, declaration or a class.
     */
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

    /**
     * Finds implementations in this scope
     */
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

    /**
     * Type checking for implementations
     */
    @Override
    public void checkType() {
        if (type instanceof PrimitiveType || (type instanceof GenericType && type.getImplementation()!= null) || type instanceof FunctionType) {
            if (of != null) {
                // Types may be of BoolLiteral, IntLiteral, Functions, Generics
                // Geen Traits, Classes
                //TODO::::: Implementation and trait type checking
            }
        }
    }
}
