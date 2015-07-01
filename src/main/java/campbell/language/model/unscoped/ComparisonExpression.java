package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.Scope;
import campbell.language.types.BoolType;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.BinaryExpression;
import campbell.roborovski.model.Program;

public class ComparisonExpression extends Expression {
    /**
     * Expression on the left side of the comparison
     */
    private final Expression left;
    /**
     * Comparison operator
     *
     * Can be less than (equals), greater than (equals) and (not) equals
     */
    private final ComparisonOp op;
    /**
     * Expression on the right side of the comparison
     */
    private final Expression right;

    /**
     * Returns the type of this expression which is a boolean
     * @return
     */
    @Override
    public Type getType() {
        return new BoolType();
    }

    /**
     * Converts this comparison expression to the IR Roborovski
     *
     * @param program
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new BinaryExpression(left.toRoborovski(program), op.getRoborovski(), right.toRoborovski(program));
    }

    /**
     * Type checking for comparisons
     *
     * At the moment only integers can be compared
     * Later on may be used for classes implementing Comparable as well
     */
    @Override
    public void checkType() {
        if (left.getType() instanceof IntType && !left.getType().equals(right.getType())) {
            throw new CompileException(this, ""+left.toString()+" does not have the same type as "+right.toString());
        }
    }

    /**
     * Enum representing the possible operators for this expression:
     * Less than, Less than equals, Greater than, Greater than equals,
     * Equals and Not equals
     */
    public enum ComparisonOp {
        LessThan(BinaryExpression.BinaryOp.LessThan),
        GreaterThan(BinaryExpression.BinaryOp.GreaterThan),
        LessThanEquals(BinaryExpression.BinaryOp.LessThanEquals),
        GreaterThanEquals(BinaryExpression.BinaryOp.GreaterThanEquals),
        Equals(BinaryExpression.BinaryOp.Equals),
        NotEquals(BinaryExpression.BinaryOp.NotEquals);

        /**
         * Operator used to express this expression's operator in the IR Roborovski
         */
        private final BinaryExpression.BinaryOp roborovski;

        ComparisonOp(BinaryExpression.BinaryOp roborovski) {
            this.roborovski = roborovski;
        }

        /**
         * Returns the Roborovski form of the operator
         * @return
         */
        public BinaryExpression.BinaryOp getRoborovski() {
            return roborovski;
        }
    }
    public ComparisonExpression(Expression left, ComparisonOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public static ComparisonExpression fromContext(CampbellParser.LtContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr0()), ComparisonOp.LessThan, Expression.fromContext(ctx.expr1())));
    }

    public static ComparisonExpression fromContext(CampbellParser.LteContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr0()), ComparisonOp.LessThanEquals, Expression.fromContext(ctx.expr1())));
    }

    public static ComparisonExpression fromContext(CampbellParser.GtContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr0()), ComparisonOp.GreaterThan, Expression.fromContext(ctx.expr1())));
    }

    public static ComparisonExpression fromContext(CampbellParser.GteContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr0()), ComparisonOp.GreaterThanEquals, Expression.fromContext(ctx.expr1())));
    }

    public static ComparisonExpression fromContext(CampbellParser.EqContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr0()), ComparisonOp.Equals, Expression.fromContext(ctx.expr1())));
    }

    public static ComparisonExpression fromContext(CampbellParser.NeqContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr0()), ComparisonOp.NotEquals, Expression.fromContext(ctx.expr1())));
    }

    /**
     * Sets the scope of this comparison expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        left.setScope(scope);
        right.setScope(scope);
    }

    /**
     * Makes a string representation of this comparison expression with correct indenting
     * @param indent - indent level of this comparison expression
     * @return string representation of this comparison expression
     */
    @Override
    public String toString(int indent) {
        switch(op) {
            case LessThan:
                return indent(indent) + "(" + left.toString(0) + " < " + right.toString(0) + ")";
            case LessThanEquals:
                return indent(indent) + "(" + left.toString(0) + " <= " + right.toString(0) + ")";
            case GreaterThan:
                return indent(indent) + "(" + left.toString(0) + " > " + right.toString(0) + ")";
            case GreaterThanEquals:
                return indent(indent) + "(" + left.toString(0) + " >= " + right.toString(0) + ")";
            case Equals:
                return indent(indent) + "(" + left.toString(0) + " == " + right.toString(0) + ")";
            case NotEquals:
                return indent(indent) + "(" + left.toString(0) + " != " + right.toString(0) + ")";
        }
        return null;
    }

    /**
     * Makes a deep copy of this comparison expression
     * @return deep copy og this comparison expression
     */
    @Override
    public ComparisonExpression deepCopy() {
        return new ComparisonExpression(left.deepCopy(), op, right.deepCopy());
    }

    /**
     * Replaces a given type by another given type within this comparison expression
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        left.replaceType(replace, replaceWith);
        right.replaceType(replace, replaceWith);
    }
}