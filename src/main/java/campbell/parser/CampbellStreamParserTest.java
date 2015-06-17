package campbell.parser;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class CampbellStreamParserTest {
    @Test
    public void test() throws FileNotFoundException {
        System.out.println(CampbellStreamParser.parse(new FileInputStream("/home/pieter/programming/haskell/campbell/example.ham")));
    }
}