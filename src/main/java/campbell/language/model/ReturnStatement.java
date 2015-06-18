package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class ReturnStatement extends Statement {
    private Expression returnExpression;

    public ReturnStatement(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }

    public static Statement fromContext(CampbellParser.ReturnNodeContext returnNodeContext) {
        return null;
    }
}
