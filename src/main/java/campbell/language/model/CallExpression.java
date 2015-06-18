package campbell.language.model;

import java.util.List;

public class CallExpression {
    private final Expression callee;
    private final List<Expression> arguments;

    public CallExpression(Expression callee, List<Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }
}
