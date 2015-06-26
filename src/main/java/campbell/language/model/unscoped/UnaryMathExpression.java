package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.BinaryExpression;
import campbell.roborovski.model.ConstExpression;
import campbell.roborovski.model.Program;

public class UnaryMathExpression extends Expression {
    private final UnaryMathOp op;
    private final Expression expr;

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        expr.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        String inner = expr.toString(0);

        switch(op) {
            case Negate:
                return indent(indent) + "(-" + inner + ")";
        }

        return null;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new BinaryExpression(new ConstExpression(0), BinaryExpression.BinaryOp.Subtract, expr.toRoborovski(program));
    }

    @Override
    public Expression deepCopy() {
        return new UnaryMathExpression(op, expr.deepCopy());
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        expr.replaceType(replace, replaceWith);
    }

    public enum UnaryMathOp {
        Negate;
    }
    public UnaryMathExpression(UnaryMathOp op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public static Expression fromContext(CampbellParser.NegateContext ctx) {
        return new UnaryMathExpression(UnaryMathOp.Negate, Expression.fromContext(ctx.expr()));
    }
}
