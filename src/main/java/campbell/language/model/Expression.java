package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public abstract class Expression extends Statement {
    public static Expression fromContext(CampbellParser.ExprContext expr) {
        if (expr instanceof CampbellParser.LtContext) {

        } else if (expr instanceof CampbellParser.GtContext) {

        } else if (expr instanceof CampbellParser.LteContext) {

        } else if (expr instanceof  CampbellParser.GteContext) {

        } else {

        }
    }
}
