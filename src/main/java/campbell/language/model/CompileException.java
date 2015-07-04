package campbell.language.model;

import org.antlr.v4.runtime.Token;

/**
 * CompileException is an exception that can occur while compiling
 */
public class CompileException extends RuntimeException {
    /**
     * Constructor
     * @param location - Node where the error occurs
     * @param message - Message to tell what went wrong
     */
    public CompileException(Node location, String message) {
        this(location.getLine(), location.getCol(), location.getClass().getName(), message);
    }

    /**
     * Constructor
     * @param tok - Token where error occurs
     * @param what - What is being processed
     * @param message - Message to tell what went wrong
     */
    public CompileException(Token tok, String what, String message) {
        this(tok.getLine(), tok.getCharPositionInLine(), what, message);
    }

    /**
     * Constructor
     * @param line - Line where error occurs
     * @param col - Column where error occurs
     * @param what - What is being processed
     * @param message - Message to tell what went wrong
     */
    public CompileException(int line, int col, String what, String message) {
        super(String.format("Compile error while processing a %s at %d:%d:\n%s", what, line, col, message));
    }

}
