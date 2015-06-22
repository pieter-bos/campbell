package campbell.language.model;

import campbell.parser.gen.CampbellParser;

public class ReturnStatement extends Statement {
    private Expression returnExpression;

    public ReturnStatement(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }

    public static Statement fromContext(CampbellParser.ReturnNodeContext returnNodeContext) {
        return new ReturnStatement(Expression.fromContext(returnNodeContext.expr()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "return " + returnExpression.toString(0);
    }
}
