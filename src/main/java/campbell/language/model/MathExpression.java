package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class MathExpression extends Expression {
    private final Expression left;
    private final MathOp op;
    private final Expression right;

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
        return new MathExpression(Expression.fromContext(ctx.expr1()), MathOp.Add, Expression.fromContext(ctx.expr2()));
    }

    public static MathExpression fromContext(CampbellParser.SubtractContext ctx) {
        return new MathExpression(Expression.fromContext(ctx.expr1()), MathOp.Subtract, Expression.fromContext(ctx.expr2()));
    }

    public static MathExpression fromContext(CampbellParser.MultiplyContext ctx) {
        return new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.Multiply, Expression.fromContext(ctx.expr3()));
    }

    public static MathExpression fromContext(CampbellParser.DivideContext ctx) {
        return new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.Divide, Expression.fromContext(ctx.expr3()));
    }

    public static MathExpression fromContext(CampbellParser.ModuloContext ctx) {
        return new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.Modulo, Expression.fromContext(ctx.expr3()));
    }
}
