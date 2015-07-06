// Generated from /home/pieter/programming/haskell/campbell/src/main/java/campbell/parser/Campbell.g4 by ANTLR 4.5
package campbell.parser.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CampbellParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_topLevelStatement = 1, RULE_statement = 2, RULE_haskell = 3, 
		RULE_nop = 4, RULE_fun = 5, RULE_unsafe = 6, RULE_whileNode = 7, RULE_ifNode = 8, 
		RULE_impl = 9, RULE_trait = 10, RULE_returnNode = 11, RULE_decl = 12, 
		RULE_assign = 13, RULE_classNode = 14, RULE_forNode = 15, RULE_expr = 16, 
		RULE_expr0 = 17, RULE_expr1 = 18, RULE_expr2 = 19, RULE_expr3 = 20, RULE_expr4 = 21, 
		RULE_block = 22, RULE_className = 23, RULE_classList = 24, RULE_exprAddon = 25, 
		RULE_bool = 26;
	public static final String[] ruleNames = {
		"program", "topLevelStatement", "statement", "haskell", "nop", "fun", 
		"unsafe", "whileNode", "ifNode", "impl", "trait", "returnNode", "decl", 
		"assign", "classNode", "forNode", "expr", "expr0", "expr1", "expr2", "expr3", 
		"expr4", "block", "className", "classList", "exprAddon", "bool"
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

	@Override
	public String getGrammarFileName() { return "Campbell.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CampbellParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CampbellParser.EOF, 0); }
		public List<TopLevelStatementContext> topLevelStatement() {
			return getRuleContexts(TopLevelStatementContext.class);
		}
		public TopLevelStatementContext topLevelStatement(int i) {
			return getRuleContext(TopLevelStatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54); 
				topLevelStatement();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << WHILE) | (1L << IMPL) | (1L << TRAIT) | (1L << IF) | (1L << RETURN) | (1L << UNSAFE) | (1L << TRUE) | (1L << FALSE) | (1L << FUN) | (1L << FOR) | (1L << PAREN_OPEN) | (1L << MINUS) | (1L << INT) | (1L << IDENTIFIER) | (1L << NOT) | (1L << HASKELL) | (1L << NOP) | (1L << SHARED) | (1L << THREADS))) != 0) );
			setState(59); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelStatementContext extends ParserRuleContext {
		public TopLevelStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelStatement; }
	 
		public TopLevelStatementContext() { }
		public void copyFrom(TopLevelStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SharedDeclContext extends TopLevelStatementContext {
		public TerminalNode SHARED() { return getToken(CampbellParser.SHARED, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public SharedDeclContext(TopLevelStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSharedDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSharedDecl(this);
		}
	}
	public static class NormalStatementContext extends TopLevelStatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public NormalStatementContext(TopLevelStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterNormalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitNormalStatement(this);
		}
	}
	public static class CoresContext extends TopLevelStatementContext {
		public TerminalNode THREADS() { return getToken(CampbellParser.THREADS, 0); }
		public TerminalNode INT() { return getToken(CampbellParser.INT, 0); }
		public CoresContext(TopLevelStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterCores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitCores(this);
		}
	}

	public final TopLevelStatementContext topLevelStatement() throws RecognitionException {
		TopLevelStatementContext _localctx = new TopLevelStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelStatement);
		try {
			setState(66);
			switch (_input.LA(1)) {
			case CLASS:
			case WHILE:
			case IMPL:
			case TRAIT:
			case IF:
			case RETURN:
			case UNSAFE:
			case TRUE:
			case FALSE:
			case FUN:
			case FOR:
			case PAREN_OPEN:
			case MINUS:
			case INT:
			case IDENTIFIER:
			case NOT:
			case HASKELL:
			case NOP:
				_localctx = new NormalStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61); 
				statement();
				}
				break;
			case SHARED:
				_localctx = new SharedDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62); 
				match(SHARED);
				setState(63); 
				decl();
				}
				break;
			case THREADS:
				_localctx = new CoresContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(64); 
				match(THREADS);
				setState(65); 
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public HaskellContext haskell() {
			return getRuleContext(HaskellContext.class,0);
		}
		public NopContext nop() {
			return getRuleContext(NopContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public UnsafeContext unsafe() {
			return getRuleContext(UnsafeContext.class,0);
		}
		public WhileNodeContext whileNode() {
			return getRuleContext(WhileNodeContext.class,0);
		}
		public IfNodeContext ifNode() {
			return getRuleContext(IfNodeContext.class,0);
		}
		public ImplContext impl() {
			return getRuleContext(ImplContext.class,0);
		}
		public TraitContext trait() {
			return getRuleContext(TraitContext.class,0);
		}
		public ReturnNodeContext returnNode() {
			return getRuleContext(ReturnNodeContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ClassNodeContext classNode() {
			return getRuleContext(ClassNodeContext.class,0);
		}
		public ForNodeContext forNode() {
			return getRuleContext(ForNodeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); 
				haskell();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69); 
				nop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70); 
				fun();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71); 
				unsafe();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72); 
				whileNode();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(73); 
				ifNode();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(74); 
				impl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(75); 
				trait();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(76); 
				returnNode();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(77); 
				decl();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(78); 
				assign();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(79); 
				classNode();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(80); 
				forNode();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(81); 
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HaskellContext extends ParserRuleContext {
		public TerminalNode HASKELL() { return getToken(CampbellParser.HASKELL, 0); }
		public HaskellContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_haskell; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterHaskell(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitHaskell(this);
		}
	}

	public final HaskellContext haskell() throws RecognitionException {
		HaskellContext _localctx = new HaskellContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_haskell);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); 
			match(HASKELL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NopContext extends ParserRuleContext {
		public TerminalNode NOP() { return getToken(CampbellParser.NOP, 0); }
		public NopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterNop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitNop(this);
		}
	}

	public final NopContext nop() throws RecognitionException {
		NopContext _localctx = new NopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); 
			match(NOP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(CampbellParser.FUN, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CampbellParser.IDENTIFIER, 0); }
		public TerminalNode PAREN_OPEN() { return getToken(CampbellParser.PAREN_OPEN, 0); }
		public TerminalNode PAREN_CLOSE() { return getToken(CampbellParser.PAREN_CLOSE, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CampbellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CampbellParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitFun(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			match(FUN);
			setState(89); 
			className();
			setState(90); 
			match(IDENTIFIER);
			setState(91); 
			match(PAREN_OPEN);
			setState(100);
			_la = _input.LA(1);
			if (_la==PAREN_OPEN || _la==IDENTIFIER) {
				{
				setState(92); 
				decl();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(93); 
					match(COMMA);
					setState(94); 
					decl();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(102); 
			match(PAREN_CLOSE);
			setState(104);
			_la = _input.LA(1);
			if (_la==OPEN_BLOCK) {
				{
				setState(103); 
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsafeContext extends ParserRuleContext {
		public TerminalNode UNSAFE() { return getToken(CampbellParser.UNSAFE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public UnsafeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsafe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterUnsafe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitUnsafe(this);
		}
	}

	public final UnsafeContext unsafe() throws RecognitionException {
		UnsafeContext _localctx = new UnsafeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unsafe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); 
			match(UNSAFE);
			setState(107); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileNodeContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CampbellParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterWhileNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitWhileNode(this);
		}
	}

	public final WhileNodeContext whileNode() throws RecognitionException {
		WhileNodeContext _localctx = new WhileNodeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); 
			match(WHILE);
			setState(110); 
			expr(0);
			setState(111); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfNodeContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CampbellParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CampbellParser.ELSE, 0); }
		public IfNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterIfNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitIfNode(this);
		}
	}

	public final IfNodeContext ifNode() throws RecognitionException {
		IfNodeContext _localctx = new IfNodeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifNode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			match(IF);
			setState(114); 
			expr(0);
			setState(115); 
			block();
			setState(118);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(116); 
				match(ELSE);
				setState(117); 
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImplContext extends ParserRuleContext {
		public TerminalNode IMPL() { return getToken(CampbellParser.IMPL, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode OF() { return getToken(CampbellParser.OF, 0); }
		public ClassListContext classList() {
			return getRuleContext(ClassListContext.class,0);
		}
		public ImplContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterImpl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitImpl(this);
		}
	}

	public final ImplContext impl() throws RecognitionException {
		ImplContext _localctx = new ImplContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_impl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); 
			match(IMPL);
			setState(121); 
			className();
			setState(124);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(122); 
				match(OF);
				setState(123); 
				classList();
				}
			}

			setState(126); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TraitContext extends ParserRuleContext {
		public TerminalNode TRAIT() { return getToken(CampbellParser.TRAIT, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode OF() { return getToken(CampbellParser.OF, 0); }
		public ClassListContext classList() {
			return getRuleContext(ClassListContext.class,0);
		}
		public TraitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterTrait(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitTrait(this);
		}
	}

	public final TraitContext trait() throws RecognitionException {
		TraitContext _localctx = new TraitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_trait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); 
			match(TRAIT);
			setState(129); 
			className();
			setState(132);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(130); 
				match(OF);
				setState(131); 
				classList();
				}
			}

			setState(134); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnNodeContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CampbellParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterReturnNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitReturnNode(this);
		}
	}

	public final ReturnNodeContext returnNode() throws RecognitionException {
		ReturnNodeContext _localctx = new ReturnNodeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			match(RETURN);
			setState(137); 
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CampbellParser.IDENTIFIER, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); 
			className();
			setState(140); 
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(CampbellParser.EQUALS, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assign);
		try {
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142); 
				expr(0);
				setState(143); 
				match(EQUALS);
				setState(144); 
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146); 
				decl();
				setState(147); 
				match(EQUALS);
				setState(148); 
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassNodeContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CampbellParser.CLASS, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ClassNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterClassNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitClassNode(this);
		}
	}

	public final ClassNodeContext classNode() throws RecognitionException {
		ClassNodeContext _localctx = new ClassNodeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); 
			match(CLASS);
			setState(153); 
			className();
			setState(154); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForNodeContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(CampbellParser.FOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(CampbellParser.IN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterForNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitForNode(this);
		}
	}

	public final ForNodeContext forNode() throws RecognitionException {
		ForNodeContext _localctx = new ForNodeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			match(FOR);
			setState(157); 
			expr(0);
			setState(158); 
			match(IN);
			setState(159); 
			expr(0);
			setState(160); 
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SuperExprContext extends ExprContext {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public SuperExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSuperExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSuperExpr(this);
		}
	}
	public static class OrContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OR() { return getToken(CampbellParser.OR, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitOr(this);
		}
	}
	public static class AndContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AND() { return getToken(CampbellParser.AND, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitAnd(this);
		}
	}
	public static class XorContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode XOR() { return getToken(CampbellParser.XOR, 0); }
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public XorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitXor(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SuperExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(163); 
			expr0(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166); 
						match(AND);
						setState(167); 
						expr0(0);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(169); 
						match(OR);
						setState(170); 
						expr0(0);
						}
						break;
					case 3:
						{
						_localctx = new XorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(172); 
						match(XOR);
						setState(173); 
						expr0(0);
						}
						break;
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr0Context extends ParserRuleContext {
		public Expr0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr0; }
	 
		public Expr0Context() { }
		public void copyFrom(Expr0Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleExprContext extends Expr0Context {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public SimpleExprContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSimpleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSimpleExpr(this);
		}
	}
	public static class LtContext extends Expr0Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode BROKET_OPEN() { return getToken(CampbellParser.BROKET_OPEN, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public LtContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitLt(this);
		}
	}
	public static class GteContext extends Expr0Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode GTE() { return getToken(CampbellParser.GTE, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public GteContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitGte(this);
		}
	}
	public static class NeqContext extends Expr0Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode NEQ() { return getToken(CampbellParser.NEQ, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public NeqContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitNeq(this);
		}
	}
	public static class LteContext extends Expr0Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode LTE() { return getToken(CampbellParser.LTE, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public LteContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitLte(this);
		}
	}
	public static class EqContext extends Expr0Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode EQ() { return getToken(CampbellParser.EQ, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public EqContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitEq(this);
		}
	}
	public static class GtContext extends Expr0Context {
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public TerminalNode BROKET_CLOSE() { return getToken(CampbellParser.BROKET_CLOSE, 0); }
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public GtContext(Expr0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitGt(this);
		}
	}

	public final Expr0Context expr0() throws RecognitionException {
		return expr0(0);
	}

	private Expr0Context expr0(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr0Context _localctx = new Expr0Context(_ctx, _parentState);
		Expr0Context _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr0, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(180); 
			expr1(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(200);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new LteContext(new Expr0Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr0);
						setState(182);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(183); 
						match(LTE);
						setState(184); 
						expr1(0);
						}
						break;
					case 2:
						{
						_localctx = new GteContext(new Expr0Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr0);
						setState(185);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(186); 
						match(GTE);
						setState(187); 
						expr1(0);
						}
						break;
					case 3:
						{
						_localctx = new EqContext(new Expr0Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr0);
						setState(188);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(189); 
						match(EQ);
						setState(190); 
						expr1(0);
						}
						break;
					case 4:
						{
						_localctx = new NeqContext(new Expr0Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr0);
						setState(191);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(192); 
						match(NEQ);
						setState(193); 
						expr1(0);
						}
						break;
					case 5:
						{
						_localctx = new LtContext(new Expr0Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr0);
						setState(194);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(195); 
						match(BROKET_OPEN);
						setState(196); 
						expr1(0);
						}
						break;
					case 6:
						{
						_localctx = new GtContext(new Expr0Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr0);
						setState(197);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(198); 
						match(BROKET_CLOSE);
						setState(199); 
						expr1(0);
						}
						break;
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr1Context extends ParserRuleContext {
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
	 
		public Expr1Context() { }
		public void copyFrom(Expr1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends Expr1Context {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public TerminalNode PLUS() { return getToken(CampbellParser.PLUS, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public AddContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitAdd(this);
		}
	}
	public static class SubtractContext extends Expr1Context {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public TerminalNode MINUS() { return getToken(CampbellParser.MINUS, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public SubtractContext(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSubtract(this);
		}
	}
	public static class SimpleExpr1Context extends Expr1Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public SimpleExpr1Context(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSimpleExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSimpleExpr1(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		return expr1(0);
	}

	private Expr1Context expr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr1Context _localctx = new Expr1Context(_ctx, _parentState);
		Expr1Context _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleExpr1Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(206); 
			expr2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AddContext(new Expr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr1);
						setState(208);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(209); 
						match(PLUS);
						setState(210); 
						expr2(0);
						}
						break;
					case 2:
						{
						_localctx = new SubtractContext(new Expr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr1);
						setState(211);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(212); 
						match(MINUS);
						setState(213); 
						expr2(0);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr2Context extends ParserRuleContext {
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
	 
		public Expr2Context() { }
		public void copyFrom(Expr2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LshContext extends Expr2Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode LSH() { return getToken(CampbellParser.LSH, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public LshContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterLsh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitLsh(this);
		}
	}
	public static class RshContext extends Expr2Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode RSH() { return getToken(CampbellParser.RSH, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public RshContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterRsh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitRsh(this);
		}
	}
	public static class SimpleExpr2Context extends Expr2Context {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public SimpleExpr2Context(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSimpleExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSimpleExpr2(this);
		}
	}
	public static class DivideContext extends Expr2Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode SLASH() { return getToken(CampbellParser.SLASH, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public DivideContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitDivide(this);
		}
	}
	public static class MultiplyContext extends Expr2Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode STAR() { return getToken(CampbellParser.STAR, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public MultiplyContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitMultiply(this);
		}
	}
	public static class ModuloContext extends Expr2Context {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public TerminalNode PERCENT() { return getToken(CampbellParser.PERCENT, 0); }
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public ModuloContext(Expr2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitModulo(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		return expr2(0);
	}

	private Expr2Context expr2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr2Context _localctx = new Expr2Context(_ctx, _parentState);
		Expr2Context _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleExpr2Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(220); 
			expr3();
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(222);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(223); 
						match(STAR);
						setState(224); 
						expr3();
						}
						break;
					case 2:
						{
						_localctx = new DivideContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(225);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(226); 
						match(SLASH);
						setState(227); 
						expr3();
						}
						break;
					case 3:
						{
						_localctx = new ModuloContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(228);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(229); 
						match(PERCENT);
						setState(230); 
						expr3();
						}
						break;
					case 4:
						{
						_localctx = new LshContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232); 
						match(LSH);
						setState(233); 
						expr3();
						}
						break;
					case 5:
						{
						_localctx = new RshContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235); 
						match(RSH);
						setState(236); 
						expr3();
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr3Context extends ParserRuleContext {
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
	 
		public Expr3Context() { }
		public void copyFrom(Expr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends Expr3Context {
		public TerminalNode NOT() { return getToken(CampbellParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitNot(this);
		}
	}
	public static class NegateContext extends Expr3Context {
		public TerminalNode MINUS() { return getToken(CampbellParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitNegate(this);
		}
	}
	public static class SimpleExpr3Context extends Expr3Context {
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public SimpleExpr3Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSimpleExpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSimpleExpr3(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr3);
		try {
			setState(247);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(242); 
				match(MINUS);
				setState(243); 
				expr(0);
				}
				break;
			case NOT:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244); 
				match(NOT);
				setState(245); 
				expr(0);
				}
				break;
			case TRUE:
			case FALSE:
			case PAREN_OPEN:
			case INT:
			case IDENTIFIER:
				_localctx = new SimpleExpr3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246); 
				expr4();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr4Context extends ParserRuleContext {
		public Expr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr4; }
	 
		public Expr4Context() { }
		public void copyFrom(Expr4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenContext extends Expr4Context {
		public TerminalNode PAREN_OPEN() { return getToken(CampbellParser.PAREN_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(CampbellParser.PAREN_CLOSE, 0); }
		public List<ExprAddonContext> exprAddon() {
			return getRuleContexts(ExprAddonContext.class);
		}
		public ExprAddonContext exprAddon(int i) {
			return getRuleContext(ExprAddonContext.class,i);
		}
		public ParenContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitParen(this);
		}
	}
	public static class IdContext extends Expr4Context {
		public TerminalNode IDENTIFIER() { return getToken(CampbellParser.IDENTIFIER, 0); }
		public List<ExprAddonContext> exprAddon() {
			return getRuleContexts(ExprAddonContext.class);
		}
		public ExprAddonContext exprAddon(int i) {
			return getRuleContext(ExprAddonContext.class,i);
		}
		public IdContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitId(this);
		}
	}
	public static class BoolExprContext extends Expr4Context {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public List<ExprAddonContext> exprAddon() {
			return getRuleContexts(ExprAddonContext.class);
		}
		public ExprAddonContext exprAddon(int i) {
			return getRuleContext(ExprAddonContext.class,i);
		}
		public BoolExprContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitBoolExpr(this);
		}
	}
	public static class IntContext extends Expr4Context {
		public TerminalNode INT() { return getToken(CampbellParser.INT, 0); }
		public List<ExprAddonContext> exprAddon() {
			return getRuleContexts(ExprAddonContext.class);
		}
		public ExprAddonContext exprAddon(int i) {
			return getRuleContext(ExprAddonContext.class,i);
		}
		public IntContext(Expr4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitInt(this);
		}
	}

	public final Expr4Context expr4() throws RecognitionException {
		Expr4Context _localctx = new Expr4Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr4);
		try {
			int _alt;
			setState(279);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249); 
				match(INT);
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(250); 
						exprAddon();
						}
						} 
					}
					setState(255);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256); 
				bool();
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(257); 
						exprAddon();
						}
						} 
					}
					setState(262);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;
			case IDENTIFIER:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(263); 
				match(IDENTIFIER);
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(264); 
						exprAddon();
						}
						} 
					}
					setState(269);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			case PAREN_OPEN:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(270); 
				match(PAREN_OPEN);
				setState(271); 
				expr(0);
				setState(272); 
				match(PAREN_CLOSE);
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(273); 
						exprAddon();
						}
						} 
					}
					setState(278);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OPEN_BLOCK() { return getToken(CampbellParser.OPEN_BLOCK, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(CampbellParser.CLOSE_BLOCK, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); 
			match(OPEN_BLOCK);
			setState(283); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(282); 
				statement();
				}
				}
				setState(285); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << WHILE) | (1L << IMPL) | (1L << TRAIT) | (1L << IF) | (1L << RETURN) | (1L << UNSAFE) | (1L << TRUE) | (1L << FALSE) | (1L << FUN) | (1L << FOR) | (1L << PAREN_OPEN) | (1L << MINUS) | (1L << INT) | (1L << IDENTIFIER) | (1L << NOT) | (1L << HASKELL) | (1L << NOP))) != 0) );
			setState(287); 
			match(CLOSE_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassNameContext extends ParserRuleContext {
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
	 
		public ClassNameContext() { }
		public void copyFrom(ClassNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassNameClassContext extends ClassNameContext {
		public TerminalNode IDENTIFIER() { return getToken(CampbellParser.IDENTIFIER, 0); }
		public TerminalNode BROKET_OPEN() { return getToken(CampbellParser.BROKET_OPEN, 0); }
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public TerminalNode BROKET_CLOSE() { return getToken(CampbellParser.BROKET_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CampbellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CampbellParser.COMMA, i);
		}
		public ClassNameClassContext(ClassNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterClassNameClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitClassNameClass(this);
		}
	}
	public static class ClassNameFuncContext extends ClassNameContext {
		public TerminalNode PAREN_OPEN() { return getToken(CampbellParser.PAREN_OPEN, 0); }
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(CampbellParser.PAREN_CLOSE, 0); }
		public List<TerminalNode> ARROW() { return getTokens(CampbellParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(CampbellParser.ARROW, i);
		}
		public ClassNameFuncContext(ClassNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterClassNameFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitClassNameFunc(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_className);
		int _la;
		try {
			setState(314);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new ClassNameClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(289); 
				match(IDENTIFIER);
				setState(301);
				_la = _input.LA(1);
				if (_la==BROKET_OPEN) {
					{
					setState(290); 
					match(BROKET_OPEN);
					setState(291); 
					className();
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(292); 
						match(COMMA);
						setState(293); 
						className();
						}
						}
						setState(298);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(299); 
					match(BROKET_CLOSE);
					}
				}

				}
				break;
			case PAREN_OPEN:
				_localctx = new ClassNameFuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303); 
				match(PAREN_OPEN);
				setState(304); 
				className();
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ARROW) {
					{
					{
					setState(305); 
					match(ARROW);
					setState(306); 
					className();
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(312); 
				match(PAREN_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassListContext extends ParserRuleContext {
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public TerminalNode PAREN_OPEN() { return getToken(CampbellParser.PAREN_OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CampbellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CampbellParser.COMMA, i);
		}
		public TerminalNode PAREN_CLOSE() { return getToken(CampbellParser.PAREN_CLOSE, 0); }
		public ClassListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterClassList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitClassList(this);
		}
	}

	public final ClassListContext classList() throws RecognitionException {
		ClassListContext _localctx = new ClassListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_classList);
		int _la;
		try {
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(316); 
				className();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317); 
				match(PAREN_OPEN);
				setState(318); 
				className();
				setState(319); 
				match(COMMA);
				setState(320); 
				className();
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(321); 
					match(COMMA);
					setState(322); 
					className();
					}
					}
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(328); 
				match(PAREN_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprAddonContext extends ParserRuleContext {
		public ExprAddonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAddon; }
	 
		public ExprAddonContext() { }
		public void copyFrom(ExprAddonContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallContext extends ExprAddonContext {
		public TerminalNode PAREN_OPEN() { return getToken(CampbellParser.PAREN_OPEN, 0); }
		public TerminalNode PAREN_CLOSE() { return getToken(CampbellParser.PAREN_CLOSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CampbellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CampbellParser.COMMA, i);
		}
		public CallContext(ExprAddonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitCall(this);
		}
	}
	public static class GetContext extends ExprAddonContext {
		public TerminalNode DOT() { return getToken(CampbellParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CampbellParser.IDENTIFIER, 0); }
		public GetContext(ExprAddonContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitGet(this);
		}
	}

	public final ExprAddonContext exprAddon() throws RecognitionException {
		ExprAddonContext _localctx = new ExprAddonContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_exprAddon);
		int _la;
		try {
			setState(346);
			switch (_input.LA(1)) {
			case PAREN_OPEN:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(332); 
				match(PAREN_OPEN);
				setState(341);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << PAREN_OPEN) | (1L << MINUS) | (1L << INT) | (1L << IDENTIFIER) | (1L << NOT))) != 0)) {
					{
					setState(333); 
					expr(0);
					setState(338);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(334); 
						match(COMMA);
						setState(335); 
						expr(0);
						}
						}
						setState(340);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(343); 
				match(PAREN_CLOSE);
				}
				break;
			case DOT:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(344); 
				match(DOT);
				setState(345); 
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TrueContext extends BoolContext {
		public TerminalNode TRUE() { return getToken(CampbellParser.TRUE, 0); }
		public TrueContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitTrue(this);
		}
	}
	public static class FalseContext extends BoolContext {
		public TerminalNode FALSE() { return getToken(CampbellParser.FALSE, 0); }
		public FalseContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitFalse(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_bool);
		try {
			setState(350);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(348); 
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349); 
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: 
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 17: 
			return expr0_sempred((Expr0Context)_localctx, predIndex);
		case 18: 
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 19: 
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 4);
		case 1: 
			return precpred(_ctx, 3);
		case 2: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr0_sempred(Expr0Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3: 
			return precpred(_ctx, 7);
		case 4: 
			return precpred(_ctx, 6);
		case 5: 
			return precpred(_ctx, 5);
		case 6: 
			return precpred(_ctx, 4);
		case 7: 
			return precpred(_ctx, 3);
		case 8: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 9: 
			return precpred(_ctx, 3);
		case 10: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 11: 
			return precpred(_ctx, 6);
		case 12: 
			return precpred(_ctx, 5);
		case 13: 
			return precpred(_ctx, 4);
		case 14: 
			return precpred(_ctx, 3);
		case 15: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0163\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\6\2:\n\2\r\2\16\2;\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\5\3E\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4U\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7b\n\7"+
		"\f\7\16\7e\13\7\5\7g\n\7\3\7\3\7\5\7k\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\5\ny\n\n\3\13\3\13\3\13\3\13\5\13\177\n\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\5\f\u0087\n\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0099\n\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00b1\n\22\f\22\16\22\u00b4\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00cb\n\23\f\23\16\23\u00ce\13\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d9\n\24\f\24\16"+
		"\24\u00dc\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00f0\n\25\f\25\16\25\u00f3\13"+
		"\25\3\26\3\26\3\26\3\26\3\26\5\26\u00fa\n\26\3\27\3\27\7\27\u00fe\n\27"+
		"\f\27\16\27\u0101\13\27\3\27\3\27\7\27\u0105\n\27\f\27\16\27\u0108\13"+
		"\27\3\27\3\27\7\27\u010c\n\27\f\27\16\27\u010f\13\27\3\27\3\27\3\27\3"+
		"\27\7\27\u0115\n\27\f\27\16\27\u0118\13\27\5\27\u011a\n\27\3\30\3\30\6"+
		"\30\u011e\n\30\r\30\16\30\u011f\3\30\3\30\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0129\n\31\f\31\16\31\u012c\13\31\3\31\3\31\5\31\u0130\n\31\3\31\3\31"+
		"\3\31\3\31\7\31\u0136\n\31\f\31\16\31\u0139\13\31\3\31\3\31\5\31\u013d"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0146\n\32\f\32\16\32\u0149"+
		"\13\32\3\32\3\32\5\32\u014d\n\32\3\33\3\33\3\33\3\33\7\33\u0153\n\33\f"+
		"\33\16\33\u0156\13\33\5\33\u0158\n\33\3\33\3\33\3\33\5\33\u015d\n\33\3"+
		"\34\3\34\5\34\u0161\n\34\3\34\2\6\"$&(\35\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\66\2\2\u0182\29\3\2\2\2\4D\3\2\2\2\6T\3\2"+
		"\2\2\bV\3\2\2\2\nX\3\2\2\2\fZ\3\2\2\2\16l\3\2\2\2\20o\3\2\2\2\22s\3\2"+
		"\2\2\24z\3\2\2\2\26\u0082\3\2\2\2\30\u008a\3\2\2\2\32\u008d\3\2\2\2\34"+
		"\u0098\3\2\2\2\36\u009a\3\2\2\2 \u009e\3\2\2\2\"\u00a4\3\2\2\2$\u00b5"+
		"\3\2\2\2&\u00cf\3\2\2\2(\u00dd\3\2\2\2*\u00f9\3\2\2\2,\u0119\3\2\2\2."+
		"\u011b\3\2\2\2\60\u013c\3\2\2\2\62\u014c\3\2\2\2\64\u015c\3\2\2\2\66\u0160"+
		"\3\2\2\28:\5\4\3\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2="+
		">\7\2\2\3>\3\3\2\2\2?E\5\6\4\2@A\7\61\2\2AE\5\32\16\2BC\7\62\2\2CE\7\""+
		"\2\2D?\3\2\2\2D@\3\2\2\2DB\3\2\2\2E\5\3\2\2\2FU\5\b\5\2GU\5\n\6\2HU\5"+
		"\f\7\2IU\5\16\b\2JU\5\20\t\2KU\5\22\n\2LU\5\24\13\2MU\5\26\f\2NU\5\30"+
		"\r\2OU\5\32\16\2PU\5\34\17\2QU\5\36\20\2RU\5 \21\2SU\5\"\22\2TF\3\2\2"+
		"\2TG\3\2\2\2TH\3\2\2\2TI\3\2\2\2TJ\3\2\2\2TK\3\2\2\2TL\3\2\2\2TM\3\2\2"+
		"\2TN\3\2\2\2TO\3\2\2\2TP\3\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\7\3\2"+
		"\2\2VW\7.\2\2W\t\3\2\2\2XY\7\60\2\2Y\13\3\2\2\2Z[\7\16\2\2[\\\5\60\31"+
		"\2\\]\7#\2\2]f\7\30\2\2^c\5\32\16\2_`\7\33\2\2`b\5\32\16\2a_\3\2\2\2b"+
		"e\3\2\2\2ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2\2\2fg\3\2\2\2"+
		"gh\3\2\2\2hj\7\31\2\2ik\5.\30\2ji\3\2\2\2jk\3\2\2\2k\r\3\2\2\2lm\7\13"+
		"\2\2mn\5.\30\2n\17\3\2\2\2op\7\4\2\2pq\5\"\22\2qr\5.\30\2r\21\3\2\2\2"+
		"st\7\b\2\2tu\5\"\22\2ux\5.\30\2vw\7\t\2\2wy\5.\30\2xv\3\2\2\2xy\3\2\2"+
		"\2y\23\3\2\2\2z{\7\5\2\2{~\5\60\31\2|}\7\6\2\2}\177\5\62\32\2~|\3\2\2"+
		"\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\5.\30\2\u0081\25\3\2\2\2"+
		"\u0082\u0083\7\7\2\2\u0083\u0086\5\60\31\2\u0084\u0085\7\6\2\2\u0085\u0087"+
		"\5\62\32\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2"+
		"\u0088\u0089\5.\30\2\u0089\27\3\2\2\2\u008a\u008b\7\n\2\2\u008b\u008c"+
		"\5\"\22\2\u008c\31\3\2\2\2\u008d\u008e\5\60\31\2\u008e\u008f\7#\2\2\u008f"+
		"\33\3\2\2\2\u0090\u0091\5\"\22\2\u0091\u0092\7!\2\2\u0092\u0093\5\"\22"+
		"\2\u0093\u0099\3\2\2\2\u0094\u0095\5\32\16\2\u0095\u0096\7!\2\2\u0096"+
		"\u0097\5\"\22\2\u0097\u0099\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0094\3"+
		"\2\2\2\u0099\35\3\2\2\2\u009a\u009b\7\3\2\2\u009b\u009c\5\60\31\2\u009c"+
		"\u009d\5.\30\2\u009d\37\3\2\2\2\u009e\u009f\7\17\2\2\u009f\u00a0\5\"\22"+
		"\2\u00a0\u00a1\7\20\2\2\u00a1\u00a2\5\"\22\2\u00a2\u00a3\5.\30\2\u00a3"+
		"!\3\2\2\2\u00a4\u00a5\b\22\1\2\u00a5\u00a6\5$\23\2\u00a6\u00b2\3\2\2\2"+
		"\u00a7\u00a8\f\6\2\2\u00a8\u00a9\7*\2\2\u00a9\u00b1\5$\23\2\u00aa\u00ab"+
		"\f\5\2\2\u00ab\u00ac\7+\2\2\u00ac\u00b1\5$\23\2\u00ad\u00ae\f\4\2\2\u00ae"+
		"\u00af\7,\2\2\u00af\u00b1\5$\23\2\u00b0\u00a7\3\2\2\2\u00b0\u00aa\3\2"+
		"\2\2\u00b0\u00ad\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3#\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\b\23\1\2"+
		"\u00b6\u00b7\5&\24\2\u00b7\u00cc\3\2\2\2\u00b8\u00b9\f\t\2\2\u00b9\u00ba"+
		"\7\23\2\2\u00ba\u00cb\5&\24\2\u00bb\u00bc\f\b\2\2\u00bc\u00bd\7\24\2\2"+
		"\u00bd\u00cb\5&\24\2\u00be\u00bf\f\7\2\2\u00bf\u00c0\7\25\2\2\u00c0\u00cb"+
		"\5&\24\2\u00c1\u00c2\f\6\2\2\u00c2\u00c3\7&\2\2\u00c3\u00cb\5&\24\2\u00c4"+
		"\u00c5\f\5\2\2\u00c5\u00c6\7\21\2\2\u00c6\u00cb\5&\24\2\u00c7\u00c8\f"+
		"\4\2\2\u00c8\u00c9\7\22\2\2\u00c9\u00cb\5&\24\2\u00ca\u00b8\3\2\2\2\u00ca"+
		"\u00bb\3\2\2\2\u00ca\u00be\3\2\2\2\u00ca\u00c1\3\2\2\2\u00ca\u00c4\3\2"+
		"\2\2\u00ca\u00c7\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd%\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\b\24\1\2"+
		"\u00d0\u00d1\5(\25\2\u00d1\u00da\3\2\2\2\u00d2\u00d3\f\5\2\2\u00d3\u00d4"+
		"\7\34\2\2\u00d4\u00d9\5(\25\2\u00d5\u00d6\f\4\2\2\u00d6\u00d7\7\35\2\2"+
		"\u00d7\u00d9\5(\25\2\u00d8\u00d2\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d9\u00dc"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\'\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00de\b\25\1\2\u00de\u00df\5*\26\2\u00df\u00f1\3"+
		"\2\2\2\u00e0\u00e1\f\b\2\2\u00e1\u00e2\7\36\2\2\u00e2\u00f0\5*\26\2\u00e3"+
		"\u00e4\f\7\2\2\u00e4\u00e5\7\37\2\2\u00e5\u00f0\5*\26\2\u00e6\u00e7\f"+
		"\6\2\2\u00e7\u00e8\7 \2\2\u00e8\u00f0\5*\26\2\u00e9\u00ea\f\5\2\2\u00ea"+
		"\u00eb\7(\2\2\u00eb\u00f0\5*\26\2\u00ec\u00ed\f\4\2\2\u00ed\u00ee\7)\2"+
		"\2\u00ee\u00f0\5*\26\2\u00ef\u00e0\3\2\2\2\u00ef\u00e3\3\2\2\2\u00ef\u00e6"+
		"\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2)\3\2\2\2\u00f3\u00f1\3\2\2\2"+
		"\u00f4\u00f5\7\35\2\2\u00f5\u00fa\5\"\22\2\u00f6\u00f7\7\'\2\2\u00f7\u00fa"+
		"\5\"\22\2\u00f8\u00fa\5,\27\2\u00f9\u00f4\3\2\2\2\u00f9\u00f6\3\2\2\2"+
		"\u00f9\u00f8\3\2\2\2\u00fa+\3\2\2\2\u00fb\u00ff\7\"\2\2\u00fc\u00fe\5"+
		"\64\33\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u011a\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0106\5\66"+
		"\34\2\u0103\u0105\5\64\33\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u011a\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0109\u010d\7#\2\2\u010a\u010c\5\64\33\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u011a\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7\30\2\2\u0111\u0112\5\"\22\2\u0112"+
		"\u0116\7\31\2\2\u0113\u0115\5\64\33\2\u0114\u0113\3\2\2\2\u0115\u0118"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0119\u00fb\3\2\2\2\u0119\u0102\3\2\2\2\u0119\u0109\3\2"+
		"\2\2\u0119\u0110\3\2\2\2\u011a-\3\2\2\2\u011b\u011d\7$\2\2\u011c\u011e"+
		"\5\6\4\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7%\2\2\u0122/\3\2\2\2\u0123"+
		"\u012f\7#\2\2\u0124\u0125\7\21\2\2\u0125\u012a\5\60\31\2\u0126\u0127\7"+
		"\33\2\2\u0127\u0129\5\60\31\2\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2"+
		"\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012d\u012e\7\22\2\2\u012e\u0130\3\2\2\2\u012f\u0124\3\2\2\2"+
		"\u012f\u0130\3\2\2\2\u0130\u013d\3\2\2\2\u0131\u0132\7\30\2\2\u0132\u0137"+
		"\5\60\31\2\u0133\u0134\7/\2\2\u0134\u0136\5\60\31\2\u0135\u0133\3\2\2"+
		"\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7\31\2\2\u013b\u013d\3\2\2\2"+
		"\u013c\u0123\3\2\2\2\u013c\u0131\3\2\2\2\u013d\61\3\2\2\2\u013e\u014d"+
		"\5\60\31\2\u013f\u0140\7\30\2\2\u0140\u0141\5\60\31\2\u0141\u0142\7\33"+
		"\2\2\u0142\u0147\5\60\31\2\u0143\u0144\7\33\2\2\u0144\u0146\5\60\31\2"+
		"\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\7\31\2\2"+
		"\u014b\u014d\3\2\2\2\u014c\u013e\3\2\2\2\u014c\u013f\3\2\2\2\u014d\63"+
		"\3\2\2\2\u014e\u0157\7\30\2\2\u014f\u0154\5\"\22\2\u0150\u0151\7\33\2"+
		"\2\u0151\u0153\5\"\22\2\u0152\u0150\3\2\2\2\u0153\u0156\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0157\u014f\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015d\7\31\2\2\u015a\u015b\7\32\2\2\u015b\u015d\7#\2\2\u015c\u014e\3"+
		"\2\2\2\u015c\u015a\3\2\2\2\u015d\65\3\2\2\2\u015e\u0161\7\f\2\2\u015f"+
		"\u0161\7\r\2\2\u0160\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161\67\3\2\2"+
		"\2%;DTcfjx~\u0086\u0098\u00b0\u00b2\u00ca\u00cc\u00d8\u00da\u00ef\u00f1"+
		"\u00f9\u00ff\u0106\u010d\u0116\u0119\u011f\u012a\u012f\u0137\u013c\u0147"+
		"\u014c\u0154\u0157\u015c\u0160";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}