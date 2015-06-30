package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;

import java.util.List;
import java.util.stream.Collectors;

public class UnsafeStatement extends Scope {
    /**
     * List containing all statements in this unsafe block
     */
    private List<? extends Statement> statements;

    public UnsafeStatement(List<? extends Statement> statements) {
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.UnsafeContext unsafe) {
        return at(unsafe.getStart(), new UnsafeStatement(Statement.fromContexts(unsafe.block().statement())));
    }

    /**
     * Sets the scope of this unsafe block and all its statements
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
     * Makes a string representation of this unsafe block with correct indenting and all its statements
     * @param indent - indent level of this unsafe block
     * @return string representation of this unsafe block
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + "unsafe " + getComment();

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }

    /**
     * Converts this unsafe block to the IR Roborovski
     *
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
     * Makes a deep copy of this unsafe block and its statements
     * @return deep copy of this unsafe block
     */
    @Override
    public UnsafeStatement deepCopy() {
        return new UnsafeStatement(statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
    }

    /**
     * Replaces a given type by another given type within this unsafe block
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        for (Statement s : statements) {
            s.replaceType(replace, replaceWith);
        }
    }

    /**
     * Finds definitions in this unsafe block
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
     */
    @Override
    public void findImpls() {
        for(Statement stat : statements) {
            if(stat instanceof Scope) {
                ((Scope) stat).findImpls();
            }
        }
    }
}
