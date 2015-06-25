package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

public class MathExpression extends Expression {
    private final Expression left;
    private final MathOp op;
    private final Expression right;

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski() {
        return null;
    }

    @Override
    public Expression deepCopy() {
        return new MathExpression(left.deepCopy(), op, right.deepCopy());
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        left.replaceType(replace, replaceWith);
        right.replaceType(replace, replaceWith);
    }

    public enum MathOp {
        Add,
        Subtract,
        Multiply,
        Divide,
        Modulo;

    }
    public MathExpression(Expression left, MathOp op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    public static MathExpression fromContext(CampbellParser.AddContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr1()), MathOp.Add, Expression.fromContext(ctx.expr2())));
    }

    public static MathExpression fromContext(CampbellParser.SubtractContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr1()), MathOp.Subtract, Expression.fromContext(ctx.expr2())));
    }

    public static MathExpression fromContext(CampbellParser.MultiplyContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.Multiply, Expression.fromContext(ctx.expr3())));
    }

    public static MathExpression fromContext(CampbellParser.DivideContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.Divide, Expression.fromContext(ctx.expr3())));
    }

    public static MathExpression fromContext(CampbellParser.ModuloContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.Modulo, Expression.fromContext(ctx.expr3())));
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
            case Add:
                return indent(indent) + "(" + left.toString(0) + " + " + right.toString(0) + ")";
            case Subtract:
                return indent(indent) + "(" + left.toString(0) + " - " + right.toString(0) + ")";
            case Multiply:
                return indent(indent) + "(" + left.toString(0) + " * " + right.toString(0) + ")";
            case Divide:
                return indent(indent) + "(" + left.toString(0) + " / " + right.toString(0) + ")";
            case Modulo:
                return indent(indent) + "(" + left.toString(0) + " % " + right.toString(0) + ")";
        }

        return null;
    }
}
