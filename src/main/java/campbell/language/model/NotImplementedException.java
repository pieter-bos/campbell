package campbell.language.model;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Thrown when a rule of the Campbell grammar is not implemented in the language model
 */
public class NotImplementedException extends RuntimeException {
    public NotImplementedException(ParserRuleContext context) {
        super("There is no implementation of the rule " + context.getClass());
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
