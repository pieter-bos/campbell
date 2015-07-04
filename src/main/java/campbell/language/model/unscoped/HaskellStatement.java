package campbell.language.model.unscoped;

import campbell.language.model.Statement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Haskell;
import campbell.roborovski.model.Program;

/**
 * Haskell statement represents in-line haskell in Campbell
 *
 * This can make it easier to, for example, write output to the screen
 */
public class HaskellStatement extends Statement {
    /**
     * Statement in Haskell
     */
    private String haskell;

    public HaskellStatement(String haskell) {
        this.haskell = haskell;
    }

    /**
     * Sets the scope of this haskell expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Makes a string representation of this haskell statement with correct indenting
     * @param indent - indent level of this haskell statement
     * @return string representation of this haskell statement
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + "\\" + haskell;
    }

    /**
     * Converts this Haskell statement to the IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        block.addStatement(new Haskell(haskell));
    }

    /**
     * Makes a deep copy of this Haskell statement
     * @return deep copy of Haskell statement
     */
    @Override
    public Statement deepCopy() {
        return new HaskellStatement(haskell);
    }

    /**
     * Replaces a given type by another given type within this Haskell statement
     *
     * Haskell statement contains no types and therefore does nothing
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    /**
     * Method that checks whether this expression returns
     *
     * Expressions never return
     * @return
     */
    @Override
    public boolean returns() {
        return true;
    }

    /**
     * Tries to parse a HaskellStatement from a given context
     * @param ctx
     * @return
     */
    public static HaskellStatement fromContext(CampbellParser.HaskellContext ctx) {
        return new HaskellStatement(ctx.HASKELL().getText());
    }

    /**
     * Type checking for Haskell statement
     *
     * Haskell statements cannot be type checked
     * Haskell statements should only be used in unsafe blocks
     */
    @Override
    public void checkType() {
        // Nop
    }
}
