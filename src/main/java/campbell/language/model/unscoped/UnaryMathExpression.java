package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.BinaryExpression;
import campbell.roborovski.model.ConstExpression;
import campbell.roborovski.model.Program;

/**
 * Unary math expression represents an expression that is negated in Campbell
 */
public class UnaryMathExpression extends Expression {
    /**
     * Operand of this unary math expression
     * This operand can only be Negate (-)
     */
    private final UnaryMathOp op;
    /**
     * Expression that may be negated
     */
    private final Expression expr;

    /**
     * Sets the scope of this unary math expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        expr.setScope(scope);
    }

    /**
     * Makes a string representation of this unary math expression with correct indenting
     * @param indent - indent level of this unary math expression
     * @return string representation of this unary math expression
     */
    @Override
    public String toString(int indent) {
        String inner = expr.toString(0);

        switch(op) {
            case Negate:
                return indent(indent) + "(-" + inner + ")";
            case Not:
                return indent(indent) + "(!" + inner + ")";
        }

        return null;
    }

    /**
     * Returns the type of this unary math expression
     *
     * Unary math expressions are of type integer
     * @return
     */
    @Override
    public Type getType() {
        return new IntType();
    }

    /**
     * Converts this unary math expression to the IR Roborovski
     * @param program
     * @return
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new BinaryExpression(new ConstExpression(op == UnaryMathOp.Negate ? 0 : 1), BinaryExpression.BinaryOp.Subtract, expr.toRoborovski(program));
    }

    /**
     * Makes a deep copy of this unary math expression
     * @return deep copy of unary math expression
     */
    @Override
    public Expression deepCopy() {
        return new UnaryMathExpression(op, expr.deepCopy());
    }

    /**
     * Replaces a given type by another given type within this unary math expression
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        expr.replaceType(replace, replaceWith);
    }

    /**
     * Type checking for unary math expressions
     */
    @Override
    public void checkType() {
        if (!(expr.getType() instanceof IntType)) {
            throw new CompileException(this, "Cannot negate expression of type "+expr.getType().getName());
        }
    }

    /**
     * Enum representing the possible operators for this expression:
     * Negate
     */
    public enum UnaryMathOp {
        Negate,
        Not;
    }

    public UnaryMathExpression(UnaryMathOp op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    /**
     * Tries to parse a UnaryMathExpression from a given context
     * @param ctx
     * @return
     */
    public static Expression fromContext(CampbellParser.NegateContext ctx) {
        return new UnaryMathExpression(UnaryMathOp.Negate, Expression.fromContext(ctx.expr()));
    }

    public static Expression fromContext(CampbellParser.NotContext ctx) {
        return new UnaryMathExpression(UnaryMathOp.Not, Expression.fromContext(ctx.expr()));
    }
}
