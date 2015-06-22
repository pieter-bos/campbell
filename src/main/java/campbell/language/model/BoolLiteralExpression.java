package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class BoolLiteralExpression extends Expression {
    private boolean value;

    public BoolLiteralExpression(boolean value) {
        this.value = value;
    }

    public static BoolLiteralExpression fromContext(CampbellParser.BoolContext ctx) {
        return new BoolLiteralExpression(ctx instanceof CampbellParser.TrueContext);
    }
}
