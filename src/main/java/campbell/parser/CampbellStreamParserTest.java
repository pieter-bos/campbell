package campbell.parser;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Test for the parser
 */
public class CampbellStreamParserTest {

    /**
     * Tests parsing of example file
     * @throws FileNotFoundException
     */
    @Test
    public void test() throws FileNotFoundException {
        System.out.println(CampbellStreamParser.parse(new FileInputStream("/home/pieter/programming/haskell/campbell/example.ham")));
    }
}