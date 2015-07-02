package campbell.parser;

import campbell.parser.gen.CampbellParser;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;

public class CampbellStreamParser {
    public static CampbellParser.ProgramContext parse(InputStream input) {
        CampbellParser parser = new CampbellParser(new CommonTokenStream(new CampbellLexer(input)));
        return parser.program();
    }
}
