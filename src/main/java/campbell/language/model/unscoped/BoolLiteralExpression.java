package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.BoolType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.ConstExpression;
import campbell.roborovski.model.Program;

/**
 * Bool literal expression represents a boolean expression in Campbell
 */
public class BoolLiteralExpression extends Expression {
    /**
     * Boolean value of the expression
     */
    private boolean value;

    public BoolLiteralExpression(boolean value) {
        this.value = value;
    }

    /**
     * Tries to parse a BoolLiteralExpression from a given context
     * @param ctx
     * @return
     */
    public static BoolLiteralExpression fromContext(CampbellParser.BoolContext ctx) {
        return at(ctx.getStart(), new BoolLiteralExpression(ctx instanceof CampbellParser.TrueContext));
    }

    /**
     * Sets the scope of this boolean expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Makes a string representation of this boolean expression with correct indenting
     * @param indent - indent level of this boolean expression
     * @return string representation of this boolean expression
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + value;
    }

    /**
     * Makes a deep copy of this boolean expression
     * @return deep copy of this boolean expression
     */
    @Override
    public BoolLiteralExpression deepCopy() {
        return new BoolLiteralExpression(value);
    }

    /**
     * Replaces a given type by another given type within this boolean expression
     *
     * Boolean expression contains no types and therefore does nothing
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    /**
     * Returns the type of the expression
     *
     * BoolLiteralExpressions are of type Boolean
     * @return
     */
    @Override
    public Type getType() {
        return new BoolType();
    }

    /**
     * Converts this boolean expression to the IR Roborovski
     *
     * @param program
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new ConstExpression(value ? 1 : 0);
    }

    /**
     * Type checking for boolean expressions
     *
     * Type of a boolean expression is always correct
     */
    @Override
    public void checkType() {
        // nop
    }
}
