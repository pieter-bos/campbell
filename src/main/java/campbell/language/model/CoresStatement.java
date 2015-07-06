package campbell.language.model;

import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

/**
 * Specifies the number of cores that Sprockell should use
 */
public class CoresStatement extends Statement {
    /**
     * Number of cores
     */
    private int cores;

    public CoresStatement(int cores) {
        this.cores = cores;
    }

    /**
     * Sets the scope of this statement
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Returns a string representation of this statement
     * @param indent
     * @return
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + "threads " + cores;
    }

    /**
     * Converts this statement to IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        program.setCores(cores);
    }

    /**
     * Makes a deep copy of this statement
     * @return
     */
    @Override
    public Statement deepCopy() {
        return new CoresStatement(cores);
    }

    /**
     * Replaces a given type by another given type within this statement
     *
     * This statement does not contain types so nothing needs to be done
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
     * CoresStatement never returns
     * @return
     */
    @Override
    public boolean returns() {
        return false;
    }

    /**
     * Type checking for this statement
     *
     * Number of concurreny threads must always be >= 1
     */
    @Override
    public void checkType() {
        if(cores < 1) {
            throw new CompileException(this, "The number of concurrent threads must be one or larger.");
        }
    }

    /**
     * Tries to parse a CoresStatement from a given context
     * @param ctx
     * @return
     */
    public static CoresStatement fromContext(CampbellParser.CoresContext ctx) {
        return new CoresStatement(Integer.valueOf(ctx.INT().getText()));
    }
}
