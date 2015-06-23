package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.parser.gen.CampbellParser;

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
}
