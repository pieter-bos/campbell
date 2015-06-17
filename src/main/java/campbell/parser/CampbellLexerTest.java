package campbell.parser;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class CampbellLexerTest {
    private CampbellLexer lexer(String data) {
        return new CampbellLexer(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    public void testTokens() throws FileNotFoundException {
        CampbellLexer lexer = new CampbellLexer(new FileInputStream("/home/pieter/programming/haskell/campbell/example.ham"));

        Token token;

        while((token = lexer.nextToken()) != null) {
            System.out.println(token);
        }
    }
}