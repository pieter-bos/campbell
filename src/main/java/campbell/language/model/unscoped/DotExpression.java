package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.scoped.ClassStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

public class DotExpression extends Expression {
    private final Expression expr;
    private final String property;

    public DotExpression(Expression expr, String property) {
        this.expr = expr;
        this.property = property;
    }

    public static DotExpression fromContext(CampbellParser.GetContext ctx, Expression expr) {
        return at(ctx.getStart(), new DotExpression(expr, ctx.IDENTIFIER().getText()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        expr.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "(" + expr.toString(0) + "." + property + ")";
    }

    @Override
    public DotExpression deepCopy() {
        return new DotExpression(expr.deepCopy(), property);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        expr.replaceType(replace, replaceWith);
    }

    @Override
    public Type getType() {
        if(expr.getType() instanceof ClassType) {
            return ((ClassStatement) expr.getType().getImplementation()).findSymbol(property).getType();
        } else {
            throw new CompileException(this, "Cannot get a property of type " + expr.getType());
        }
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski() {
        return null;
    }
}
