package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.Type;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Campbell Block represents a list of statements
 */
public class BlockStatement extends Scope implements Iterable<Statement> {
    /**
     * List containing all statements in this block
     */
    private List<? extends Statement> statements;

    /**
     * Constructor of a BlockStatement
     * @param statements - list of all statements that appear in the block
     */
    public BlockStatement(List<? extends Statement> statements) {
        this.statements = statements;
    }

    /**
     * Finds definitions in this block.
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
        }
    }

    /**
     * Sets the scope of this block and all its statements
     * @param scope - Scope of this block
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for(Statement stat : statements) {
            stat.setScope(this);
        }
    }

    /**
     * Makes a string representation of this block with correct indenting and all its statements
     * @param indent - indent level of this block
     * @return string representation of this block
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + getComment();

        for(Statement stat : statements) {
            result += "\n";
            result += stat.toString(indent);
        }

        return result;
    }

    /**
     * Converts this block to the IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        Block innerBlock = new Block();

        block.addStatement(innerBlock);

        for(Statement stat : statements) {
            stat.toRoborovski(program, innerBlock);
        }
    }

    /**
     * Makes a deep copy of this block
     * @return deep copy of this block
     */
    @Override
    public BlockStatement deepCopy() {
        return new BlockStatement(statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
    }

    /**
     * Replaces a given type by another given type within this block
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        for(Statement stat : statements) {
            stat.replaceType(replace, replaceWith);
        }
    }

    /**
     * Make an iterator that iterates over the statements of this block
     * @return iterator over statements of block
     */
    @Override
    public Iterator<Statement> iterator() {
        return statements.stream().map(s -> ((Statement) s)).iterator();
    }

    /**
     * Type checking function for block statements
     * It checks the type of each individual statement
     */
    @Override
    public void checkType() {
        if (statements != null) {
            for (Statement stat : statements) {
                stat.checkType();
            }
        }
    }
}
