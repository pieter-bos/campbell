package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.roborovski.model.ConstExpression;
import campbell.roborovski.model.Program;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;

public class IntLiteralExpression extends Expression {
    /**
     * Value of the expression
     */
    private BigInteger value;

    public IntLiteralExpression(String value) {
        this.value = new BigInteger(value);
    }

    public static IntLiteralExpression fromContext(TerminalNode ctx) {
        return at(ctx.getSymbol(), new IntLiteralExpression(ctx.getText()));
    }

    /**
     * Sets the scope of this int literal expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Makes a string representation of this int literal expression with given indent
     * @param indent
     * @return
     */
    @Override
    public String toString(int indent) {
        return value.toString();
    }

    /**
     * Returns the type of this int literal expression.
     *
     * Int literal expression are of integers
     * @return
     */
    @Override
    public Type getType() {
        return new IntType();
    }

    /**
     * Converts this int literal expression to the IR Roborovski
     * @param program
     * @return
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new ConstExpression(value.intValue());
    }

    /**
     * Makes a deep copy of this int literal expression
     * @return deep copy of int literal expression
     */
    @Override
    public IntLiteralExpression deepCopy() {
        return new IntLiteralExpression(value.toString());
    }

    /**
     * Replaces a given type by another given type within this int literal expression
     *
     * An int literal expression contains no types thus nothing is done
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    /**
     * Type checking for int literal expressions
     *
     * Nothing to be done, type is always correct.
     */
    @Override
    public void checkType() {
        // Nop
    }
}
