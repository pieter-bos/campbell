package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.BinaryExpression;
import campbell.roborovski.model.Program;

public class MathExpression extends Expression {
    /**
     * Expression on the left hand side of the math expression
     */
    private final Expression left;
    /**
     * Operand of the math expression
     */
    private final MathOp op;
    /**
     * Expression on the right hand side of the math expression
     */
    private final Expression right;

    /**
     * Returns the type of the math expression
     *
     * Math expressions are of type integer
     * @return
     */
    @Override
    public Type getType() {
        return new IntType();
    }

    /**
     * Converts this math expression to the IR Roborovski
     * @param program
     * @return
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new BinaryExpression(left.toRoborovski(program), op.getRoborovskiOp(), right.toRoborovski(program));
    }

    /**
     * Makes a deep copy of this math expression
     * @return deep copy of math expression
     */
    @Override
    public Expression deepCopy() {
        return new MathExpression(left.deepCopy(), op, right.deepCopy());
    }

    /**
     * Replaces a given type by another given type within this math expression
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        left.replaceType(replace, replaceWith);
        right.replaceType(replace, replaceWith);
    }

    /**
     * Enum representing the possible operators for this expression:
     * Add, Subtract, Multiply, Divide, Modulo,
     * Left shift, Right shift,
     * And, Or and Xor
     */
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

        /**
         * Operator used to express this expression's operator in the IR Roborovski
         */
        private BinaryExpression.BinaryOp roborovskiOp;

        MathOp(BinaryExpression.BinaryOp roborovskiOp) {
            this.roborovskiOp = roborovskiOp;
        }

        /**
         * Returns the Roborovski form of the operator
         * @return
         */
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

    /**
     * Sets the scope of this math expression and its sub-expressions
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        left.setScope(scope);
        right.setScope(scope);
    }

    /**
     * Makes a string representation of this math expression with correct indenting
     * @param indent - indent level of this math expression
     * @return string representation of this math expression
     */
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
