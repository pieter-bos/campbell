package campbell.language.model;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Exception thrown when a rule of the Campbell grammar is not implemented in the language model
 */
public class NotImplementedException extends RuntimeException {
    /**
     * Constructor
     * @param context - Context where error occurs
     */
    public NotImplementedException(ParserRuleContext context) {
        super("There is no implementation of the rule " + context.getClass());
    }

    /**
     * Constructor
     * @param message - Message to tell what went wrong
     */
    public NotImplementedException(String message) {
        super(message);
    }
}
