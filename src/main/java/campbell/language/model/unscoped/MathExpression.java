package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.BinaryExpression;
import campbell.roborovski.model.Program;

public class MathExpression extends Expression {
    private final Expression left;
    private final MathOp op;
    private final Expression right;

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new BinaryExpression(left.toRoborovski(program), op.getRoborovskiOp(), right.toRoborovski(program));
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
        Add(BinaryExpression.BinaryOp.Add),
        Subtract(BinaryExpression.BinaryOp.Subtract),
        Multiply(BinaryExpression.BinaryOp.Multiply),
        Divide(BinaryExpression.BinaryOp.Divide),
        Modulo(BinaryExpression.BinaryOp.Modulo),
        LSH(BinaryExpression.BinaryOp.LSH),
        RSH(BinaryExpression.BinaryOp.RSH),
        And(BinaryExpression.BinaryOp.And),
        Or(BinaryExpression.BinaryOp.Or),
        Xor(BinaryExpression.BinaryOp.Xor)
        ;

        private BinaryExpression.BinaryOp roborovskiOp;

        MathOp(BinaryExpression.BinaryOp roborovskiOp) {
            this.roborovskiOp = roborovskiOp;
        }

        public BinaryExpression.BinaryOp getRoborovskiOp() {
            return roborovskiOp;
        }
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

    public static MathExpression fromContext(CampbellParser.LshContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.LSH, Expression.fromContext(ctx.expr3())));
    }

    public static MathExpression fromContext(CampbellParser.RshContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr2()), MathOp.RSH, Expression.fromContext(ctx.expr3())));
    }
    public static MathExpression fromContext(CampbellParser.AndContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr()), MathOp.And, Expression.fromContext(ctx.expr0())));
    }

    public static MathExpression fromContext(CampbellParser.OrContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr()), MathOp.Or, Expression.fromContext(ctx.expr0())));
    }

    public static MathExpression fromContext(CampbellParser.XorContext ctx) {
        return at(ctx.getStart(), new MathExpression(Expression.fromContext(ctx.expr()), MathOp.Xor, Expression.fromContext(ctx.expr0())));
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
            case LSH:
                return indent(indent) + "(" + left.toString(0) + " << " + right.toString(0) + ")";
            case RSH:
                return indent(indent) + "(" + left.toString(0) + " >> " + right.toString(0) + ")";
            case And:
                return indent(indent) + "(" + left.toString(0) + " & " + right.toString(0) + ")";
            case Or:
                return indent(indent) + "(" + left.toString(0) + " | " + right.toString(0) + ")";
            case Xor:
                return indent(indent) + "(" + left.toString(0) + " ^ " + right.toString(0) + ")";
        }

        return null;
    }
}
