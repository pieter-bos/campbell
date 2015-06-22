package campbell.language.model;

import campbell.parser.gen.CampbellParser;

import java.util.List;

public class CallExpression extends Expression {
    private final Expression callee;
    private final List<? extends Expression> arguments;

    public CallExpression(Expression callee, List<? extends Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }

    public static CallExpression fromContext(CampbellParser.CallContext call, Expression callee) {
        return new CallExpression(callee, Expression.fromContexts(call.expr()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        callee.setScope(scope);

        for(Expression expr : arguments) {
            expr.setScope(scope);
        }
    }

    @Override
    public String toString(int indent) {
        String result = callee.toString(indent) + "(";
        boolean firstArgument = true;

        for(Expression arg : arguments) {
            if(!firstArgument) {
                result += ", ";
            }

            firstArgument = false;

            result += arg.toString(0);
        }

        result += ")";

        return result;
    }
}
