package campbell.parser;

import campbell.parser.gen.Campbell;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;

public class CampbellLexer implements TokenSource {

    // |   lookAhead   |   buffer   |   reader ....
    // ^ start of next token
    //                 ^ current read position
    //
    // Reverting puts the lookAhead back in the buffer
    // Accepting a token clears the lookAhead and returns the new token

    private final Reader reader;
    private String lookAhead = "";
    private String buffer = "";

    private final CommonTokenFactory tokenFactory = new CommonTokenFactory();

    // We emit an OPEN_BLOCK or CLOSE_BLOCK for *changes* in indent level to simulate blocks in the parser grammar.
    private int currentIndent = 0;
    private Queue<Token> tokenQueue = new LinkedList<>();

    public CampbellLexer(InputStream stream) {
        this.reader = new InputStreamReader(stream);
    }

    public Token nextToken() {
        if(!tokenQueue.isEmpty()) {
            return tokenQueue.poll();
        }

        try {
            if(peekc() == '\n' || peekc() == '\r') {
                // Read any empty lines (and ignore the indent)
                while(peekc() == '\n' || peekc() == '\r') {
                    readc();
                }

                accept();

                int newIndent = 0;

                while(peekc() == '\t' || peekc() == ' ') {
                    if(peekc() == '\t') {
                        accept();
                        newIndent++;
                    } else if(expect("    ")) {
                        accept();
                        newIndent++;
                    } else {
                        // TODO figure out what antlr does when it cannot parse a token
                        return null;
                    }
                }

                if(newIndent > currentIndent) {
                    for(int i = 0; i < (newIndent - currentIndent); i++) {
                        tokenQueue.add(tokenFactory.create(Campbell.OPEN_BLOCK, "OPEN_BLOCK"));
                    }

                    currentIndent = newIndent;

                    return tokenQueue.poll();
                } else if(newIndent < currentIndent) {
                    for(int i = 0; i < (currentIndent - newIndent); i++) {
                        tokenQueue.add(tokenFactory.create(Campbell.CLOSE_BLOCK, "CLOSE_BLOCK"));
                    }

                    currentIndent = newIndent;

                    return tokenQueue.poll();
                }
            }

            while(peekc() == ' ' || peekc() == '\t') {
                readc();
                accept();
            }

            // Keywords

            if(expect("class")) {
                return tokenFactory.create(Campbell.CLASS, accept());
            }

            if(expect("while")) {
                return tokenFactory.create(Campbell.WHILE, accept());
            }

            if(expect("impl")) {
                return tokenFactory.create(Campbell.IMPL, accept());
            }

            if(expect("of")) {
                return tokenFactory.create(Campbell.OF, accept());
            }

            if(expect("trait")) {
                return tokenFactory.create(Campbell.TRAIT, accept());
            }

            if(expect("if")) {
                return tokenFactory.create(Campbell.IF, accept());
            }

            if(expect("else")) {
                return tokenFactory.create(Campbell.ELSE, accept());
            }

            if(expect("return")) {
                return tokenFactory.create(Campbell.RETURN, accept());
            }

            if(expect("unsafe")) {
                return tokenFactory.create(Campbell.UNSAFE, accept());
            }

            if(expect("true")) {
                return tokenFactory.create(Campbell.TRUE, accept());
            }

            if(expect("false")) {
                return tokenFactory.create(Campbell.FALSE, accept());
            }

            if(expect("fun")) {
                return tokenFactory.create(Campbell.FUN, accept());
            }

            if(expect("unsafe")) {
                return tokenFactory.create(Campbell.UNSAFE, accept());
            }

            if(expect("for")) {
                return tokenFactory.create(Campbell.FOR, accept());
            }

            if(expect("in")) {
                return tokenFactory.create(Campbell.IN, accept());
            }



            // Special characters

            if(expect("(")) {
                return tokenFactory.create(Campbell.PAREN_OPEN, accept());
            }

            if(expect(")")) {
                return tokenFactory.create(Campbell.PAREN_CLOSE, accept());
            }

            if(expect("[")) {
                return tokenFactory.create(Campbell.PAREN_OPEN, accept());
            }

            if(expect("]")) {
                return tokenFactory.create(Campbell.PAREN_CLOSE, accept());
            }

            if(expect("<")) {
                return tokenFactory.create(Campbell.BROKET_OPEN, accept());
            }

            if(expect(">")) {
                return tokenFactory.create(Campbell.BROKET_CLOSE, accept());
            }

            if(expect(",")) {
                return tokenFactory.create(Campbell.COMMA, accept());
            }

            if(expect(".")) {
                return tokenFactory.create(Campbell.DOT, accept());
            }

            if(expect("+")) {
                return tokenFactory.create(Campbell.PLUS, accept());
            }

            if(expect("-")) {
                return tokenFactory.create(Campbell.MINUS, accept());
            }

            if(expect("*")) {
                return tokenFactory.create(Campbell.STAR, accept());
            }

            if(expect("/")) {
                return tokenFactory.create(Campbell.SLASH, accept());
            }

            if(expect("%")) {
                return tokenFactory.create(Campbell.PERCENT, accept());
            }

            if(expect("=")) {
                return tokenFactory.create(Campbell.EQUALS, accept());
            }

            // Integer

            if(Character.isDigit(peekc())) {
                while(Character.isDigit(peekc())) {
                    readc();
                }

                if(lookAhead.charAt(0) == '0' && lookAhead.length() != 1) {
                    revert();
                } else {
                    return tokenFactory.create(Campbell.INT, accept());
                }
            }

            // Identifier

            if("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_$".contains(peek(1))) {
                while("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_$".contains(peek(1))) {
                    readc();
                }

                return tokenFactory.create(Campbell.IDENTIFIER, accept());
            }
        } catch(IOException e) {
            return tokenFactory.create(Token.EOF, "");
        }

        // TODO figure out what antlr does when it cannot parse a token

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

    private String readFromStream(int length) throws IOException {
        char[] data = new char[length];
        reader.read(data);
        return new String(data);
    }

    private String peek(int length) throws IOException {
        if(length > buffer.length()) {
            int toRead = length - buffer.length();
            buffer += readFromStream(toRead);
        }

        return buffer.substring(0, length);
    }

    private char peekc() throws IOException {
        return peek(1).charAt(0);
    }

    private String read(int length) throws IOException {
        if(length > buffer.length()) {
            int toRead = length - buffer.length();
            buffer += readFromStream(toRead);
        }

        String result = buffer.substring(0, length);
        buffer = buffer.substring(length);
        lookAhead += result;
        return result;
    }

    private char readc() throws IOException {
        return read(1).charAt(0);
    }

    private void revert() {
        buffer = lookAhead + buffer;
        lookAhead = "";
    }

    private String accept() {
        String result = lookAhead;
        lookAhead = "";
        return result;
    }

    private boolean expect(String s) throws IOException {
        if(read(s.length()).equals(s)) {
            return true;
        } else {
            revert();
            return false;
        }
    }

    public void setTokenFactory(TokenFactory<?> tokenFactory) {

    }

    public TokenFactory<?> getTokenFactory() {
        return null;
    }
}
