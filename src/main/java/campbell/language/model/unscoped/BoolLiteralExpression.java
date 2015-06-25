package campbell.language.model.unscoped;

import campbell.language.model.Statement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.BoolType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.ConstExpression;

public class BoolLiteralExpression extends Expression {
    private boolean value;

    public BoolLiteralExpression(boolean value) {
        this.value = value;
    }

    public static BoolLiteralExpression fromContext(CampbellParser.BoolContext ctx) {
        return at(ctx.getStart(), new BoolLiteralExpression(ctx instanceof CampbellParser.TrueContext));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + value;
    }

    @Override
    public BoolLiteralExpression deepCopy() {
        return new BoolLiteralExpression(value);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski() {
        return new ConstExpression(value ? 1 : 0);
    }
}
