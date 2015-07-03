package campbell.parser;

import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Test for the lexer
 */
public class CampbellLexerTest {
    private CampbellLexer lexer(String data) {
        return new CampbellLexer(new ByteArrayInputStream(data.getBytes()));
    }

    /**
     * Test whether it will accept all tokens
     * @throws FileNotFoundException
     */
    @Test
    public void testTokens() throws FileNotFoundException {
        CampbellLexer lexer = new CampbellLexer(new FileInputStream("/home/pieter/programming/haskell/campbell/example.ham"));

        Token token;

        while((token = lexer.nextToken()) != null) {
            System.out.println(token);
        }
    }
}