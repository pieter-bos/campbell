package campbell.language.model.unscoped;

import campbell.language.model.Statement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.BoolType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.BinaryExpression;
import campbell.roborovski.model.Program;

public class ComparisonExpression extends Expression {
    private final Expression left;
    private final ComparisonOp op;
    private final Expression right;

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new BinaryExpression(left.toRoborovski(program), op.getRoborovski(), right.toRoborovski(program));
    }

    public enum ComparisonOp {
        LessThan(BinaryExpression.BinaryOp.LessThan),
        GreaterThan(BinaryExpression.BinaryOp.GreaterThan),
        LessThanEquals(BinaryExpression.BinaryOp.LessThanEquals),
        GreaterThanEquals(BinaryExpression.BinaryOp.GreaterThanEquals),
        Equals(BinaryExpression.BinaryOp.Equals),
        NotEquals(BinaryExpression.BinaryOp.NotEquals);

        private final BinaryExpression.BinaryOp roborovski;

        ComparisonOp(BinaryExpression.BinaryOp roborovski) {
            this.roborovski = roborovski;
        }

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
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.LessThan, Expression.fromContext(ctx.expr1(1))));
    }

    public static ComparisonExpression fromContext(CampbellParser.LteContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.LessThanEquals, Expression.fromContext(ctx.expr1(1))));
    }

    public static ComparisonExpression fromContext(CampbellParser.GtContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.GreaterThan, Expression.fromContext(ctx.expr1(1))));
    }

    public static ComparisonExpression fromContext(CampbellParser.GteContext ctx) {
        return at(ctx.getStart(), new ComparisonExpression(Expression.fromContext(ctx.expr1(0)), ComparisonOp.GreaterThanEquals, Expression.fromContext(ctx.expr1(1))));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        left.setScope(scope);
        right.setScope(scope);
    }

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
        }

        return null;
    }

    @Override
    public ComparisonExpression deepCopy() {
        return new ComparisonExpression(left.deepCopy(), op, right.deepCopy());
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        left.replaceType(replace, replaceWith);
        right.replaceType(replace, replaceWith);
    }
}