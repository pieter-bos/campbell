package campbell.language.model;

import org.antlr.v4.runtime.Token;

public class CompileException extends RuntimeException {
    public CompileException(Statement location, String message) {
        this(location.getLine(), location.getCol(), location.getClass().getName(), message);
    }

    public CompileException(Token tok, String what, String message) {
        this(tok.getLine(), tok.getCharPositionInLine(), what, message);
    }

    public CompileException(int line, int col, String what, String message) {
        super(String.format("Compile error while processing a %s at %d:%d:\n%s", what, line, col, message);
    }
}
