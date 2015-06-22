package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class CallExpression extends Expression {
    private final Expression callee;
    private final List<Expression> arguments;

    public CallExpression(Expression callee, List<Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }

    public static CallExpression fromContext(CampbellParser.CallContext call, Expression callee) {
        return new CallExpression(callee, Expression.fromContexts(call.expr()));
    }
}
