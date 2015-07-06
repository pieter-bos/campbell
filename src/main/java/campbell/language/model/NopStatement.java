package campbell.language.model;

import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

/**
 * No-operation statement
 */
public class NopStatement extends Statement {
    /**
     * Sets the scope of this statement
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Returns a string representation of this statement with correct indenting
     * @param indent
     * @return
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + "nop";
    }

    /**
     * Converts this statement to the IR Roborovski
     *
     * This is a nop so nothing needs to be done
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        // nop!
    }

    /**
     * Makes a deep copy of this statement
     * @return
     */
    @Override
    public Statement deepCopy() {
        return new NopStatement();
    }

    /**
     * Replaces a given type by another given type within this statement
     *
     * This statement contains no types so nothing needs to be done
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    /**
     * Checks whether this statement returns
     *
     * Nop statements never return
     * @return
     */
    @Override
    public boolean returns() {
        return false;
    }

    /**
     * Type checking for this statement
     *
     * Nothing needs to be checked
     */
    @Override
    public void checkType() {
        // nop
    }

    /**
     * Tries to parse a NopStatement from a given context
     * @param nop
     * @return
     */
    public static Statement fromContext(CampbellParser.NopContext nop) {
        return new NopStatement();
    }
}
