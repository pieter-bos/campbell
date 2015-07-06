// Generated from /home/pieter/programming/haskell/campbell/src/main/java/campbell/parser/Campbell.g4 by ANTLR 4.5
package campbell.parser.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CampbellLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, WHILE=2, IMPL=3, OF=4, TRAIT=5, IF=6, ELSE=7, RETURN=8, UNSAFE=9, 
		TRUE=10, FALSE=11, FUN=12, FOR=13, IN=14, BROKET_OPEN=15, BROKET_CLOSE=16, 
		LTE=17, GTE=18, EQ=19, BRACKET_OPEN=20, BRACKET_CLOSE=21, PAREN_OPEN=22, 
		PAREN_CLOSE=23, DOT=24, COMMA=25, PLUS=26, MINUS=27, STAR=28, SLASH=29, 
		PERCENT=30, EQUALS=31, INT=32, IDENTIFIER=33, OPEN_BLOCK=34, CLOSE_BLOCK=35, 
		NEQ=36, NOT=37, LSH=38, RSH=39, AND=40, OR=41, XOR=42, ERROR=43, HASKELL=44, 
		ARROW=45, NOP=46, SHARED=47, THREADS=48;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CLASS", "WHILE", "IMPL", "OF", "TRAIT", "IF", "ELSE", "RETURN", "UNSAFE", 
		"TRUE", "FALSE", "FUN", "FOR", "IN", "BROKET_OPEN", "BROKET_CLOSE", "LTE", 
		"GTE", "EQ", "BRACKET_OPEN", "BRACKET_CLOSE", "PAREN_OPEN", "PAREN_CLOSE", 
		"DOT", "COMMA", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "EQUALS", 
		"INT", "IDENTIFIER", "OPEN_BLOCK", "CLOSE_BLOCK", "NEQ", "NOT", "LSH", 
		"RSH", "AND", "OR", "XOR", "ERROR", "HASKELL", "ARROW", "NOP", "SHARED", 
		"THREADS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLASS", "WHILE", "IMPL", "OF", "TRAIT", "IF", "ELSE", "RETURN", 
		"UNSAFE", "TRUE", "FALSE", "FUN", "FOR", "IN", "BROKET_OPEN", "BROKET_CLOSE", 
		"LTE", "GTE", "EQ", "BRACKET_OPEN", "BRACKET_CLOSE", "PAREN_OPEN", "PAREN_CLOSE", 
		"DOT", "COMMA", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "EQUALS", 
		"INT", "IDENTIFIER", "OPEN_BLOCK", "CLOSE_BLOCK", "NEQ", "NOT", "LSH", 
		"RSH", "AND", "OR", "XOR", "ERROR", "HASKELL", "ARROW", "NOP", "SHARED", 
		"THREADS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CampbellLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Campbell.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\62\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\3\3\4\3\5\3\6\3\7"+
		"\3\b\3\t\3\n\3\13\3\f\3\r\3\16\3\17\3\20\3\21\3\22\3\23\3\24\3\25\3\26"+
		"\3\27\3\30\3\31\3\32\3\33\3\34\3\35\3\36\3\37\3 \3!\3\"\3#\3$\3%\3&\3"+
		"\'\3(\3)\3*\3+\3,\3-\3.\3/\3\60\3\61\2\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62\3\2\2b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5d\3\2\2\2\7e\3\2\2\2\tf"+
		"\3\2\2\2\13g\3\2\2\2\rh\3\2\2\2\17i\3\2\2\2\21j\3\2\2\2\23k\3\2\2\2\25"+
		"l\3\2\2\2\27m\3\2\2\2\31n\3\2\2\2\33o\3\2\2\2\35p\3\2\2\2\37q\3\2\2\2"+
		"!r\3\2\2\2#s\3\2\2\2%t\3\2\2\2\'u\3\2\2\2)v\3\2\2\2+w\3\2\2\2-x\3\2\2"+
		"\2/y\3\2\2\2\61z\3\2\2\2\63{\3\2\2\2\65|\3\2\2\2\67}\3\2\2\29~\3\2\2\2"+
		";\177\3\2\2\2=\u0080\3\2\2\2?\u0081\3\2\2\2A\u0082\3\2\2\2C\u0083\3\2"+
		"\2\2E\u0084\3\2\2\2G\u0085\3\2\2\2I\u0086\3\2\2\2K\u0087\3\2\2\2M\u0088"+
		"\3\2\2\2O\u0089\3\2\2\2Q\u008a\3\2\2\2S\u008b\3\2\2\2U\u008c\3\2\2\2W"+
		"\u008d\3\2\2\2Y\u008e\3\2\2\2[\u008f\3\2\2\2]\u0090\3\2\2\2_\u0091\3\2"+
		"\2\2a\u0092\3\2\2\2\3\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}