package campbell.language.model.scoped;

import campbell.language.model.NotImplementedException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TraitStatement represents a trait in Campbell
 *
 * This feature could not be fully implemented in the end ;(
 */
public class TraitStatement extends Scope {
    /**
     * Type for which the trait should be implemented
     */
    private final Type type;

    /**
     * Type of arguments for which the trait should be implemented
     */
    private final List<? extends Type> of;

    /**
     * List containing all statements in this trait
     */
    private final List<? extends Statement> statements;

    public TraitStatement(Type type, List<? extends Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public TraitStatement(Type type, List<? extends Type> of, List<? extends Statement> statements) {
        this.type = type;
        this.of = of;
        this.statements = statements;
    }

    /**
     * Tries to parse a TraitStatement from a given context
     * @param trait
     * @return
     */
    public static Statement fromContext(CampbellParser.TraitContext trait) {
        Type type = Type.fromContext(trait.className());
        List<? extends Statement> statements = Statement.fromContexts(trait.block().statement());

        if(trait.classList() != null) {
            List<Type> of = Type.fromContexts(trait.classList().className());
            return at(trait.getStart(), new TraitStatement(type, of, statements));
        } else {
            return at(trait.getStart(), new TraitStatement(type, statements));
        }
    }

    /**
     * Sets the scope of this trait and all its statements
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
     * Makes a string representation of this trait with correct indenting and all its statements
     * @param indent - indent level of this trait
     * @return string representation of this trait
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + "trait " + type.toString();

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
     * Converts this trait to the IR Roborovski
     *
     * Traits are not an element in Roborovski thus nothing is done
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        // nop
    }

    /**
     * Makes a deep copy of this trait and its types and statements
     * @return deep copy of this trait
     */
    @Override
    public TraitStatement deepCopy() {
        if(of == null) {
            return new TraitStatement(type, statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
        } else {
            return new TraitStatement(type, of, statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
        }
    }

    /**
     * Replaces a given type by another given type within this trait
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        type.replaceType(replace, replaceWith);

        if (of != null) {
            for (Type t : of) {
                t.replaceType(replace, replaceWith);
            }
        }

        for (Statement s : statements) {
            s.replaceType(replace, replaceWith);
        }
    }

    /**
     * Method that checks whether this traits returns
     *
     * Traits never return
     * @return
     */
    @Override
    public boolean returns() {
        return false;
    }

    /**
     * Finds definitions in this trait
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
     *
     * Is impossible as traits do not contain implementations
     */
    @Override
    public void findImpls() {
        // Impossible
    }

    /**
     * Type checking for traits
     */
    @Override
    public void checkType() {
        throw new NotImplementedException("Traits could not be fully implemented... ;(");
    }
}
