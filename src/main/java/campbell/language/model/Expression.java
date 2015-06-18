package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public abstract class Expression extends Statement {
    public static Expression fromContext(CampbellParser.ExprContext expr) {
        return null;
    }
}
