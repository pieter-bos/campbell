package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.ClassStatement;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.FunctionType;
import campbell.language.types.Type;
import campbell.roborovski.model.FunctionExpression;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Variable;
import campbell.roborovski.model.VariableExpression;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Identifier expression represents an identifier in Haskell
 * Identifiers are used as names for variables, functions, classes, traits, etc.
 */
public class IdentifierExpression extends Expression {
    /**
     * Identifier's string representation
     */
    private String id;

    public IdentifierExpression(String id) {
        this.id = id;
    }

    /**
     * Tries to parse an IdentifierExpression from the given context
     * @param ctx
     * @return
     */
    public static IdentifierExpression fromContext(TerminalNode ctx) {
        return at(ctx.getSymbol(), new IdentifierExpression(ctx.getText()));
    }

    /**
     * Makes a string representation of this identifier expression with given indent
     * @param indent
     * @return
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + id;
    }

    /**
     * Sets the scope of this identifier expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Returns the type of this identifier
     *
     * It will try to find a declaration, function or class with the same name.
     * @return
     */
    @Override
    public Type getType() {
        if(findSymbol(id) == null && findType(id) != null) {
            ClassStatement type = (ClassStatement) findType(id).getImplementation();
            List<Type> arguments = ((FunStatement) type.findSymbol("init")).getArguments().stream().map(DeclStatement::getType).collect(Collectors.toList());
            return new FunctionType(type.getType(), arguments.subList(1, arguments.size()));
        }

        return requireSymbol(id, this).getType();
    }

    /**
     * Converts this identifier expression to the IR Roborovski
     * @param program
     * @return
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        if(findSymbol(id) == null && findType(id) != null) {
            ClassStatement type = (ClassStatement) findType(id).getImplementation();
            FunStatement func = ((FunStatement) type.getImplementation(Collections.emptyList(), program).findSymbol("#construct"));
            return new FunctionExpression(func.getFunction());
        }

        Symbol symbol = requireSymbol(id, this);

        if(symbol instanceof FunStatement) {
            return new FunctionExpression(((FunStatement) symbol).getFunction());
        } else if(symbol instanceof DeclStatement) {
            Variable v = ((DeclStatement) symbol).getVariable();
            if (v == null) {
                throw new CompileException(this, "Undeclared variable "+symbol.getName()+" used");
            }
            return new VariableExpression(v);
        }

        throw new CompileException(this, "Internal error: Unknown identifier implementation type " + symbol.getClass());
    }

    /**
     * Makes a deep copy of this identifier expression
     * @return deep copy of identifier expression
     */
    @Override
    public Expression deepCopy() {
        return new IdentifierExpression(id);
    }

    /**
     * Replaces a given type by another given type within this identifier expression
     *
     * An identifier expression contains no types thus nothing is done
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    public String getId() {
        return id;
    }

    /**
     * Type checking for identifiers
     *
     * Nothing to be done.
     */
    @Override
    public void checkType() {
        // Nop
    }
}
