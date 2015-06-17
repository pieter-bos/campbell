package campbell.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by sophie on 6/17/15.
 */
public class CampbellLexer implements TokenSource {

    private final Reader reader;

    public CampbellLexer(InputStream stream) {
        this.reader = new InputStreamReader(stream);
    }

    public Token nextToken() {
        return null;
    }

    public int getLine() {
        return 0;
    }

    public int getCharPositionInLine() {
        return 0;
    }

    public CharStream getInputStream() {
        return null;
    }

    public String getSourceName() {
        return null;
    }

    public void setTokenFactory(TokenFactory<?> tokenFactory) {

    }

    public TokenFactory<?> getTokenFactory() {
        return null;
    }
}
