package campbell.parser;

import campbell.parser.gen.CampbellTokens;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lexer for Campbell
 */
public class CampbellLexer implements TokenSource {
    /**
     * Map containing all keywords of Campbell
     */
    private static final Map<String, Integer> keywords = new HashMap<>();

    /**
     * Adds all keywords to the keywords map
     */
    static {
        keywords.put("class", CampbellTokens.CLASS);
        keywords.put("while", CampbellTokens.WHILE);
        keywords.put("impl", CampbellTokens.IMPL);
        keywords.put("of", CampbellTokens.OF);
        keywords.put("trait", CampbellTokens.TRAIT);
        keywords.put("if", CampbellTokens.IF);
        keywords.put("else", CampbellTokens.ELSE);
        keywords.put("return", CampbellTokens.RETURN);
        keywords.put("unsafe", CampbellTokens.UNSAFE);
        keywords.put("true", CampbellTokens.TRUE);
        keywords.put("false", CampbellTokens.FALSE);
        keywords.put("fun", CampbellTokens.FUN);
        keywords.put("unsafe", CampbellTokens.UNSAFE);
        keywords.put("for", CampbellTokens.FOR);
        keywords.put("in", CampbellTokens.IN);
    }

    /**
     * Reader
     */
    private final Reader reader;

    /**
     * Lookahead used to find tokens
     */
    private String lookAhead = "";

    /**
     * Buffer remembering what has been read so far
     */
    private String buffer = "";

    /**
     * TokenFactory
     */
    private TokenFactory<?> tokenFactory = new CommonTokenFactory();

    /**
     * Indent level, begin with no indent
     */
    private int currentIndent = 0;

    /**
     * Queue remembering tokens found
     */
    private Queue<Token> tokenQueue = new LinkedList<>();

    /**
     * Line number
     */
    private int line = 1;

    /**
     * Column number
     */
    private int column = 0;

    public CampbellLexer(InputStream stream) {
        this.reader = new InputStreamReader(stream);
    }

    /**
     * Finds next token
     * @return found token
     */
    public Token nextToken() {
        if(!tokenQueue.isEmpty()) {
            return tokenQueue.poll();
        }

        try {
            // When the lexer has read everything, close all blocks that are still open
            if(finished()) {
                for(int i = 0; i < currentIndent; i++) {
                    tokenQueue.add(accept(CampbellTokens.CLOSE_BLOCK));
                }

                tokenQueue.add(accept(CampbellTokens.EOF));

                return tokenQueue.poll();
            }

            // Skip spaces and tabs
            while(peekc() == ' ' || peekc() == '\t') {
                readc();
                accept(0);
            }

            // Read comments
            if(peekc() == '#') {
                while(peekc() != '\n' && peekc() != '\r') {
                    readc();
                }

                accept(0);
            }

            if(peekc() == '\n' || peekc() == '\r') {
                // Read any empty lines (and ignore the indent)
                while(!finished() && (peekc() == '\n' || peekc() == '\r')) {
                    readc();
                }

                accept(0);

                int newIndent = 0;

                // Change indent level if tab (or 4 spaces) can be found
                while(!finished() && peekc() == '\t' || peekc() == ' ') {
                    if(peekc() == '\t') {
                        accept(0);
                        newIndent++;
                    } else if(expect("    ")) {
                        accept(0);
                        newIndent++;
                    } else {
                        // TODO figure out what antlr does when it cannot parse a token
                        return tokenFactory.create(new Pair<>(this, null), Token.EPSILON, buffer, 0, 0, 0, line, column);
                    }
                }


                // We emit an OPEN_BLOCK or CLOSE_BLOCK for *changes* in indent level to simulate blocks in the parser grammar.
                if(newIndent > currentIndent) {
                    for(int i = 0; i < (newIndent - currentIndent); i++) {
                        tokenQueue.add(tokenFactory.create(new Pair<>(this, null), CampbellTokens.OPEN_BLOCK, "OPEN_BLOCK", 0, 0, 0, line, 1));
                    }

                    currentIndent = newIndent;

                    return tokenQueue.poll();
                } else if(newIndent < currentIndent) {
                    for(int i = 0; i < (currentIndent - newIndent); i++) {
                        tokenQueue.add(tokenFactory.create(new Pair<>(this, null), CampbellTokens.CLOSE_BLOCK, "CLOSE_BLOCK", 0, 0, 0, line, 1));
                    }

                    currentIndent = newIndent;

                    return tokenQueue.poll();
                }
            }

            // Special characters

            if(expect("\\")) {
                accept(0);

                while(!finished() && peekc() != '\n' && peekc() != '\r') {
                    readc();
                }

                return accept(CampbellTokens.HASKELL);
            }

            if(expect("(")) {
                return accept(CampbellTokens.PAREN_OPEN);
            }

            if(expect(")")) {
                return accept(CampbellTokens.PAREN_CLOSE);
            }

            if(expect("[")) {
                return accept(CampbellTokens.PAREN_OPEN);
            }

            if(expect("]")) {
                return accept(CampbellTokens.PAREN_CLOSE);
            }

            if(expect("<")) {
                if(!finished() && peekc() == '=') {
                    readc();
                    return accept(CampbellTokens.LTE);
                } else if (!finished() && peekc() == '<') {
                    readc();
                    return accept(CampbellTokens.LSH);
                } else {
                    return accept(CampbellTokens.BROKET_OPEN);
                }
            }

            if(expect(">")) {
                if(!finished() && peekc() == '=') {
                    readc();
                    return accept(CampbellTokens.GTE);
                } else if (!finished() && peekc() == '>') {
                    readc();
                    return accept(CampbellTokens.RSH);
                } else {
                    return accept(CampbellTokens.BROKET_CLOSE);
                }
            }

            if(expect(",")) {
                return accept(CampbellTokens.COMMA);
            }

            if(expect(".")) {
                return accept(CampbellTokens.DOT);
            }

            if(expect("+")) {
                return accept(CampbellTokens.PLUS);
            }

            if(expect("-")) {
                if(!finished() && peekc() == '>') {
                    readc();
                    return accept(CampbellTokens.ARROW);
                } else {
                    return accept(CampbellTokens.MINUS);
                }
            }

            if(expect("*")) {
                return accept(CampbellTokens.STAR);
            }

            if(expect("/")) {
                return accept(CampbellTokens.SLASH);
            }

            if(expect("%")) {
                return accept(CampbellTokens.PERCENT);
            }

            if(expect("&")) {
                return accept(CampbellTokens.AND);
            }

            if(expect("|")) {
                return accept(CampbellTokens.OR);
            }

            if(expect("^")) {
                return accept(CampbellTokens.XOR);
            }

            if(expect("!")) {
                if (!finished() && peekc() == '=') {
                    return accept(CampbellTokens.NEQ);
                } else {
                    return accept(CampbellTokens.NOT);
                }
            }

            if(expect("=")) {
                if(!finished() && peekc() == '=') {
                    readc();
                    return accept(CampbellTokens.EQ);
                } else {
                    return accept(CampbellTokens.EQUALS);
                }
            }

            // Integer

            if(Character.isDigit(peekc())) {
                while(!finished() && Character.isDigit(peekc())) {
                    readc();
                }

                if(lookAhead.charAt(0) == '0' && lookAhead.length() != 1) {
                    revert();
                } else {
                    return accept(CampbellTokens.INT);
                }
            }

            // Identifier or keyword

            if("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_$".contains(peek(1))) {
                while(!finished() && "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_$".contains(peek(1))) {
                    readc();
                }

                if(keywords.containsKey(lookAhead)) {
                    return accept(keywords.get(lookAhead));
                } else {
                    return accept(CampbellTokens.IDENTIFIER);
                }
            }

            readc();

            return accept(CampbellTokens.ERROR);
        } catch(IOException e) {
            return accept(CampbellTokens.ERROR);
        }

        // TODO figure out what antlr does when it cannot parse a token
    }

    /**
     * Checks whether the lexer has processed everything
     * @return true/false
     * @throws IOException
     */
    private boolean finished() throws IOException {
        return buffer.length() == 0 && !reader.ready();
    }

    /**
     * Returns the line number
     * @return
     */
    public int getLine() {
        return line;
    }

    /**
     * Returns the character position in a line (column number)
     * @return
     */
    public int getCharPositionInLine() {
        return column;
    }

    /**
     * Unused method
     * Needed to be implemented because this is a TokenSource
     * @return
     */
    public CharStream getInputStream() {
        return null;
    }

    /**
     * Unused method
     * Needed to be implemented because this is a TokenSource
     * @return
     */
    public String getSourceName() {
        return null;
    }

    /**
     * Read data with given length from stream
     * @param length - how much data should be read
     * @return data
     * @throws IOException
     */
    private String readFromStream(int length) throws IOException {
        char[] data = new char[length];

        if(reader.read(data) != length) {
            throw new IOException("Could not read data from the stream fast enough");
        }

        return new String(data);
    }

    /**
     * Looks ahead for a specified length
     * @param length - how much to look ahead
     * @return data of specified length
     * @throws IOException
     */
    private String peek(int length) throws IOException {
        if(length > buffer.length()) {
            int toRead = length - buffer.length();
            buffer += readFromStream(toRead);
        }

        return buffer.substring(0, length);
    }

    /**
     * Look ahead of 1
     * @return character
     * @throws IOException
     */
    private char peekc() throws IOException {
        return peek(1).charAt(0);
    }

    /**
     * Read characters of a specified length
     * @param length - number of characters to be read
     * @return String of specified length
     * @throws IOException
     */
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

    /**
     * Read a character
     * @return character
     * @throws IOException
     */
    private char readc() throws IOException {
        return read(1).charAt(0);
    }

    /**
     * Revert lookahead
     *
     * Used if some token that is expected cannot be found,
     * It will then go and try and find another token
     */
    private void revert() {
        buffer = lookAhead + buffer;
        lookAhead = "";
    }

    /**
     * Accepts the current Token string
     * @param type
     * @return Token
     */
    private Token accept(int type) {
        String result = lookAhead;
        int resultLine = line;
        int resultColumn = column;

        lookAhead = "";

        Matcher matcher = Pattern.compile("\r?\n").matcher(result);

        int count = 0;
        int end = -1;

        while(matcher.find()) {
            count++;
            end = matcher.end();
        }

        if(count > 0) {
            line += count;
            column = result.length() - end;
        } else {
            column += result.length();
        }

        return tokenFactory.create(new Pair<>(this, null), type, result, 0, 0, 0, resultLine, resultColumn);
    }

    /**
     * Returns whether the expected string can be read
     * @param s - expected string
     * @return true/false
     * @throws IOException
     */
    private boolean expect(String s) throws IOException {
        if(read(s.length()).equals(s)) {
            return true;
        } else {
            revert();
            return false;
        }
    }

    /**
     * Sets tokenfactory
     * @param tokenFactory
     */
    public void setTokenFactory(TokenFactory<?> tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    /**
     * Returns tokenfactory
     * @return
     */
    public TokenFactory<?> getTokenFactory() {
        return tokenFactory;
    }
}
