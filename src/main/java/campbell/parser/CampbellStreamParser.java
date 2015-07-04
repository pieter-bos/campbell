package campbell.parser;

import campbell.parser.gen.CampbellParser;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;

/**
 * Parser, uses the ANTLR generated parser and own lexer
 */
public class CampbellStreamParser {

    /**
     * Parses a given input and adds errorlistener to catch syntax errors
     * @param input
     * @return
     */
    public static CampbellParser.ProgramContext parse(InputStream input) {
        CampbellParser parser = new CampbellParser(new CommonTokenStream(new CampbellLexer(input)));
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        return parser.program();
    }
}
