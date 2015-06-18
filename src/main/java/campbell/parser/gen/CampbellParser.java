// Generated from /home/sophie/Downloads/Campbell/campbell/src/main/java/campbell/parser/Campbell.g4 by ANTLR 4.5
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
		LTE=17, GTE=18, BRACKET_OPEN=19, BRACKET_CLOSE=20, PAREN_OPEN=21, PAREN_CLOSE=22, 
		DOT=23, COMMA=24, PLUS=25, MINUS=26, STAR=27, SLASH=28, PERCENT=29, EQUALS=30, 
		INT=31, IDENTIFIER=32, OPEN_BLOCK=33, CLOSE_BLOCK=34, ERROR=35;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_fun = 2, RULE_unsafe = 3, RULE_whileNode = 4, 
		RULE_ifNode = 5, RULE_impl = 6, RULE_trait = 7, RULE_returnNode = 8, RULE_decl = 9, 
		RULE_assign = 10, RULE_classNode = 11, RULE_forNode = 12, RULE_expr = 13, 
		RULE_expr1 = 14, RULE_expr2 = 15, RULE_expr3 = 16, RULE_expr4 = 17, RULE_block = 18, 
		RULE_className = 19, RULE_classList = 20, RULE_exprAddon = 21, RULE_bool = 22;
	public static final String[] ruleNames = {
		"program", "statement", "fun", "unsafe", "whileNode", "ifNode", "impl", 
		"trait", "returnNode", "decl", "assign", "classNode", "forNode", "expr", 
		"expr1", "expr2", "expr3", "expr4", "block", "className", "classList", 
		"exprAddon", "bool"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLASS", "WHILE", "IMPL", "OF", "TRAIT", "IF", "ELSE", "RETURN", 
		"UNSAFE", "TRUE", "FALSE", "FUN", "FOR", "IN", "BROKET_OPEN", "BROKET_CLOSE", 
		"LTE", "GTE", "BRACKET_OPEN", "BRACKET_CLOSE", "PAREN_OPEN", "PAREN_CLOSE", 
		"DOT", "COMMA", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "EQUALS", 
		"INT", "IDENTIFIER", "OPEN_BLOCK", "CLOSE_BLOCK", "ERROR"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46); 
				statement();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << WHILE) | (1L << IMPL) | (1L << TRAIT) | (1L << IF) | (1L << RETURN) | (1L << UNSAFE) | (1L << TRUE) | (1L << FALSE) | (1L << FUN) | (1L << FOR) | (1L << PAREN_OPEN) | (1L << MINUS) | (1L << INT) | (1L << IDENTIFIER))) != 0) );
			setState(51); 
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

	public static class StatementContext extends ParserRuleContext {
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); 
				fun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54); 
				unsafe();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); 
				whileNode();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56); 
				ifNode();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57); 
				impl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(58); 
				trait();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(59); 
				returnNode();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(60); 
				expr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(61); 
				decl();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(62); 
				assign();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(63); 
				classNode();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(64); 
				forNode();
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
		enterRule(_localctx, 4, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			match(FUN);
			setState(68); 
			className();
			setState(69); 
			match(IDENTIFIER);
			setState(70); 
			match(PAREN_OPEN);
			setState(79);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(71); 
				decl();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(72); 
					match(COMMA);
					setState(73); 
					decl();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(81); 
			match(PAREN_CLOSE);
			setState(83);
			_la = _input.LA(1);
			if (_la==OPEN_BLOCK) {
				{
				setState(82); 
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
		enterRule(_localctx, 6, RULE_unsafe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			match(UNSAFE);
			setState(86); 
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
		enterRule(_localctx, 8, RULE_whileNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			match(WHILE);
			setState(89); 
			expr();
			setState(90); 
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
		enterRule(_localctx, 10, RULE_ifNode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); 
			match(IF);
			setState(93); 
			expr();
			setState(94); 
			block();
			setState(97);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(95); 
				match(ELSE);
				setState(96); 
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
		enterRule(_localctx, 12, RULE_impl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); 
			match(IMPL);
			setState(100); 
			className();
			setState(103);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(101); 
				match(OF);
				setState(102); 
				classList();
				}
			}

			setState(105); 
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
		enterRule(_localctx, 14, RULE_trait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); 
			match(TRAIT);
			setState(108); 
			className();
			setState(111);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(109); 
				match(OF);
				setState(110); 
				classList();
				}
			}

			setState(113); 
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
		enterRule(_localctx, 16, RULE_returnNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); 
			match(RETURN);
			setState(116); 
			expr();
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
		enterRule(_localctx, 18, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			className();
			setState(119); 
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
		enterRule(_localctx, 20, RULE_assign);
		try {
			setState(129);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121); 
				expr();
				setState(122); 
				match(EQUALS);
				setState(123); 
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); 
				decl();
				setState(126); 
				match(EQUALS);
				setState(127); 
				expr();
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
		enterRule(_localctx, 22, RULE_classNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			match(CLASS);
			setState(132); 
			className();
			setState(133); 
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
		enterRule(_localctx, 24, RULE_forNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); 
			match(FOR);
			setState(136); 
			expr();
			setState(137); 
			match(IN);
			setState(138); 
			expr();
			setState(139); 
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
	public static class SimpleExprContext extends ExprContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public SimpleExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSimpleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSimpleExpr(this);
		}
	}
	public static class LtContext extends ExprContext {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public TerminalNode BROKET_OPEN() { return getToken(CampbellParser.BROKET_OPEN, 0); }
		public LtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitLt(this);
		}
	}
	public static class GteContext extends ExprContext {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public TerminalNode GTE() { return getToken(CampbellParser.GTE, 0); }
		public GteContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterGte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitGte(this);
		}
	}
	public static class LteContext extends ExprContext {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public TerminalNode LTE() { return getToken(CampbellParser.LTE, 0); }
		public LteContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterLte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitLte(this);
		}
	}
	public static class GtContext extends ExprContext {
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public TerminalNode BROKET_CLOSE() { return getToken(CampbellParser.BROKET_CLOSE, 0); }
		public GtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterGt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitGt(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new LteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141); 
				expr1(0);
				setState(142); 
				match(LTE);
				setState(143); 
				expr1(0);
				}
				break;
			case 2:
				_localctx = new GteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145); 
				expr1(0);
				setState(146); 
				match(GTE);
				setState(147); 
				expr1(0);
				}
				break;
			case 3:
				_localctx = new LtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149); 
				expr1(0);
				setState(150); 
				match(BROKET_OPEN);
				setState(151); 
				expr1(0);
				}
				break;
			case 4:
				_localctx = new GtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153); 
				expr1(0);
				setState(154); 
				match(BROKET_CLOSE);
				setState(155); 
				expr1(0);
				}
				break;
			case 5:
				_localctx = new SimpleExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(157); 
				expr1(0);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleExpr1Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(161); 
			expr2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AddContext(new Expr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr1);
						setState(163);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(164); 
						match(PLUS);
						setState(165); 
						expr2(0);
						}
						break;
					case 2:
						{
						_localctx = new SubtractContext(new Expr1Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr1);
						setState(166);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(167); 
						match(MINUS);
						setState(168); 
						expr2(0);
						}
						break;
					}
					} 
				}
				setState(173);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SimpleExpr2Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(175); 
			expr3();
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(177);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(178); 
						match(STAR);
						setState(179); 
						expr3();
						}
						break;
					case 2:
						{
						_localctx = new DivideContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(180);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(181); 
						match(SLASH);
						setState(182); 
						expr3();
						}
						break;
					case 3:
						{
						_localctx = new ModuloContext(new Expr2Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(183);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(184); 
						match(PERCENT);
						setState(185); 
						expr3();
						}
						break;
					}
					} 
				}
				setState(190);
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
	public static class SimpleExpr4Context extends Expr3Context {
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public SimpleExpr4Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterSimpleExpr4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitSimpleExpr4(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr3);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191); 
				match(MINUS);
				setState(192); 
				expr();
				}
				break;
			case TRUE:
			case FALSE:
			case PAREN_OPEN:
			case INT:
			case IDENTIFIER:
				_localctx = new SimpleExpr4Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193); 
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
		enterRule(_localctx, 34, RULE_expr4);
		try {
			int _alt;
			setState(226);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196); 
				match(INT);
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(197); 
						exprAddon();
						}
						} 
					}
					setState(202);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203); 
				bool();
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(204); 
						exprAddon();
						}
						} 
					}
					setState(209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				break;
			case IDENTIFIER:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210); 
				match(IDENTIFIER);
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(211); 
						exprAddon();
						}
						} 
					}
					setState(216);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			case PAREN_OPEN:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(217); 
				match(PAREN_OPEN);
				setState(218); 
				expr();
				setState(219); 
				match(PAREN_CLOSE);
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(220); 
						exprAddon();
						}
						} 
					}
					setState(225);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); 
			match(OPEN_BLOCK);
			setState(230); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(229); 
				statement();
				}
				}
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << WHILE) | (1L << IMPL) | (1L << TRAIT) | (1L << IF) | (1L << RETURN) | (1L << UNSAFE) | (1L << TRUE) | (1L << FALSE) | (1L << FUN) | (1L << FOR) | (1L << PAREN_OPEN) | (1L << MINUS) | (1L << INT) | (1L << IDENTIFIER))) != 0) );
			setState(234); 
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
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitClassName(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_className);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); 
			match(IDENTIFIER);
			setState(248);
			_la = _input.LA(1);
			if (_la==BROKET_OPEN) {
				{
				setState(237); 
				match(BROKET_OPEN);
				setState(238); 
				className();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(239); 
					match(COMMA);
					setState(240); 
					className();
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(246); 
				match(BROKET_CLOSE);
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
		enterRule(_localctx, 40, RULE_classList);
		int _la;
		try {
			setState(264);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(250); 
				className();
				}
				break;
			case PAREN_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(251); 
				match(PAREN_OPEN);
				setState(252); 
				className();
				setState(253); 
				match(COMMA);
				setState(254); 
				className();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(255); 
					match(COMMA);
					setState(256); 
					className();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262); 
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

	public static class ExprAddonContext extends ParserRuleContext {
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
		public TerminalNode DOT() { return getToken(CampbellParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CampbellParser.IDENTIFIER, 0); }
		public ExprAddonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAddon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterExprAddon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitExprAddon(this);
		}
	}

	public final ExprAddonContext exprAddon() throws RecognitionException {
		ExprAddonContext _localctx = new ExprAddonContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exprAddon);
		int _la;
		try {
			setState(280);
			switch (_input.LA(1)) {
			case PAREN_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(266); 
				match(PAREN_OPEN);
				setState(275);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << PAREN_OPEN) | (1L << MINUS) | (1L << INT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(267); 
					expr();
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(268); 
						match(COMMA);
						setState(269); 
						expr();
						}
						}
						setState(274);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(277); 
				match(PAREN_CLOSE);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(278); 
				match(DOT);
				setState(279); 
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
		public TerminalNode TRUE() { return getToken(CampbellParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CampbellParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CampbellListener ) ((CampbellListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		case 14: 
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 15: 
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 3);
		case 1: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2: 
			return precpred(_ctx, 4);
		case 3: 
			return precpred(_ctx, 3);
		case 4: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u011f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\6\2\62"+
		"\n\2\r\2\16\2\63\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3D\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\5\4R\n"+
		"\4\3\4\3\4\5\4V\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5"+
		"\7d\n\7\3\b\3\b\3\b\3\b\5\bj\n\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tr\n\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0084"+
		"\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00a1\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00ac\n"+
		"\20\f\20\16\20\u00af\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00bd\n\21\f\21\16\21\u00c0\13\21\3\22\3\22\3\22"+
		"\5\22\u00c5\n\22\3\23\3\23\7\23\u00c9\n\23\f\23\16\23\u00cc\13\23\3\23"+
		"\3\23\7\23\u00d0\n\23\f\23\16\23\u00d3\13\23\3\23\3\23\7\23\u00d7\n\23"+
		"\f\23\16\23\u00da\13\23\3\23\3\23\3\23\3\23\7\23\u00e0\n\23\f\23\16\23"+
		"\u00e3\13\23\5\23\u00e5\n\23\3\24\3\24\6\24\u00e9\n\24\r\24\16\24\u00ea"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\7\25\u00f4\n\25\f\25\16\25\u00f7\13"+
		"\25\3\25\3\25\5\25\u00fb\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26"+
		"\u0104\n\26\f\26\16\26\u0107\13\26\3\26\3\26\5\26\u010b\n\26\3\27\3\27"+
		"\3\27\3\27\7\27\u0111\n\27\f\27\16\27\u0114\13\27\5\27\u0116\n\27\3\27"+
		"\3\27\3\27\5\27\u011b\n\27\3\30\3\30\3\30\2\4\36 \31\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\2\3\3\2\f\r\u0133\2\61\3\2\2\2\4C\3\2\2"+
		"\2\6E\3\2\2\2\bW\3\2\2\2\nZ\3\2\2\2\f^\3\2\2\2\16e\3\2\2\2\20m\3\2\2\2"+
		"\22u\3\2\2\2\24x\3\2\2\2\26\u0083\3\2\2\2\30\u0085\3\2\2\2\32\u0089\3"+
		"\2\2\2\34\u00a0\3\2\2\2\36\u00a2\3\2\2\2 \u00b0\3\2\2\2\"\u00c4\3\2\2"+
		"\2$\u00e4\3\2\2\2&\u00e6\3\2\2\2(\u00ee\3\2\2\2*\u010a\3\2\2\2,\u011a"+
		"\3\2\2\2.\u011c\3\2\2\2\60\62\5\4\3\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61"+
		"\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\2\2\3\66\3\3\2\2\2\67D\5"+
		"\6\4\28D\5\b\5\29D\5\n\6\2:D\5\f\7\2;D\5\16\b\2<D\5\20\t\2=D\5\22\n\2"+
		">D\5\34\17\2?D\5\24\13\2@D\5\26\f\2AD\5\30\r\2BD\5\32\16\2C\67\3\2\2\2"+
		"C8\3\2\2\2C9\3\2\2\2C:\3\2\2\2C;\3\2\2\2C<\3\2\2\2C=\3\2\2\2C>\3\2\2\2"+
		"C?\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EF\7\16\2\2FG\5(\25"+
		"\2GH\7\"\2\2HQ\7\27\2\2IN\5\24\13\2JK\7\32\2\2KM\5\24\13\2LJ\3\2\2\2M"+
		"P\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QI\3\2\2\2QR\3\2\2\2"+
		"RS\3\2\2\2SU\7\30\2\2TV\5&\24\2UT\3\2\2\2UV\3\2\2\2V\7\3\2\2\2WX\7\13"+
		"\2\2XY\5&\24\2Y\t\3\2\2\2Z[\7\4\2\2[\\\5\34\17\2\\]\5&\24\2]\13\3\2\2"+
		"\2^_\7\b\2\2_`\5\34\17\2`c\5&\24\2ab\7\t\2\2bd\5&\24\2ca\3\2\2\2cd\3\2"+
		"\2\2d\r\3\2\2\2ef\7\5\2\2fi\5(\25\2gh\7\6\2\2hj\5*\26\2ig\3\2\2\2ij\3"+
		"\2\2\2jk\3\2\2\2kl\5&\24\2l\17\3\2\2\2mn\7\7\2\2nq\5(\25\2op\7\6\2\2p"+
		"r\5*\26\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\5&\24\2t\21\3\2\2\2uv\7\n\2"+
		"\2vw\5\34\17\2w\23\3\2\2\2xy\5(\25\2yz\7\"\2\2z\25\3\2\2\2{|\5\34\17\2"+
		"|}\7 \2\2}~\5\34\17\2~\u0084\3\2\2\2\177\u0080\5\24\13\2\u0080\u0081\7"+
		" \2\2\u0081\u0082\5\34\17\2\u0082\u0084\3\2\2\2\u0083{\3\2\2\2\u0083\177"+
		"\3\2\2\2\u0084\27\3\2\2\2\u0085\u0086\7\3\2\2\u0086\u0087\5(\25\2\u0087"+
		"\u0088\5&\24\2\u0088\31\3\2\2\2\u0089\u008a\7\17\2\2\u008a\u008b\5\34"+
		"\17\2\u008b\u008c\7\20\2\2\u008c\u008d\5\34\17\2\u008d\u008e\5&\24\2\u008e"+
		"\33\3\2\2\2\u008f\u0090\5\36\20\2\u0090\u0091\7\23\2\2\u0091\u0092\5\36"+
		"\20\2\u0092\u00a1\3\2\2\2\u0093\u0094\5\36\20\2\u0094\u0095\7\24\2\2\u0095"+
		"\u0096\5\36\20\2\u0096\u00a1\3\2\2\2\u0097\u0098\5\36\20\2\u0098\u0099"+
		"\7\21\2\2\u0099\u009a\5\36\20\2\u009a\u00a1\3\2\2\2\u009b\u009c\5\36\20"+
		"\2\u009c\u009d\7\22\2\2\u009d\u009e\5\36\20\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u00a1\5\36\20\2\u00a0\u008f\3\2\2\2\u00a0\u0093\3\2\2\2\u00a0\u0097\3"+
		"\2\2\2\u00a0\u009b\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\35\3\2\2\2\u00a2"+
		"\u00a3\b\20\1\2\u00a3\u00a4\5 \21\2\u00a4\u00ad\3\2\2\2\u00a5\u00a6\f"+
		"\5\2\2\u00a6\u00a7\7\33\2\2\u00a7\u00ac\5 \21\2\u00a8\u00a9\f\4\2\2\u00a9"+
		"\u00aa\7\34\2\2\u00aa\u00ac\5 \21\2\u00ab\u00a5\3\2\2\2\u00ab\u00a8\3"+
		"\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\37\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\b\21\1\2\u00b1\u00b2\5\"\22"+
		"\2\u00b2\u00be\3\2\2\2\u00b3\u00b4\f\6\2\2\u00b4\u00b5\7\35\2\2\u00b5"+
		"\u00bd\5\"\22\2\u00b6\u00b7\f\5\2\2\u00b7\u00b8\7\36\2\2\u00b8\u00bd\5"+
		"\"\22\2\u00b9\u00ba\f\4\2\2\u00ba\u00bb\7\37\2\2\u00bb\u00bd\5\"\22\2"+
		"\u00bc\u00b3\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf!\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c2\7\34\2\2\u00c2\u00c5\5\34\17\2\u00c3\u00c5"+
		"\5$\23\2\u00c4\u00c1\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5#\3\2\2\2\u00c6"+
		"\u00ca\7!\2\2\u00c7\u00c9\5,\27\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00e5\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00d1\5.\30\2\u00ce\u00d0\5,\27\2\u00cf\u00ce\3\2"+
		"\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00e5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d8\7\"\2\2\u00d5\u00d7\5,"+
		"\27\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00e5\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7\27"+
		"\2\2\u00dc\u00dd\5\34\17\2\u00dd\u00e1\7\30\2\2\u00de\u00e0\5,\27\2\u00df"+
		"\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00c6\3\2\2\2\u00e4"+
		"\u00cd\3\2\2\2\u00e4\u00d4\3\2\2\2\u00e4\u00db\3\2\2\2\u00e5%\3\2\2\2"+
		"\u00e6\u00e8\7#\2\2\u00e7\u00e9\5\4\3\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\7$\2\2\u00ed\'\3\2\2\2\u00ee\u00fa\7\"\2\2\u00ef\u00f0\7\21\2\2"+
		"\u00f0\u00f5\5(\25\2\u00f1\u00f2\7\32\2\2\u00f2\u00f4\5(\25\2\u00f3\u00f1"+
		"\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7\22\2\2\u00f9\u00fb\3"+
		"\2\2\2\u00fa\u00ef\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb)\3\2\2\2\u00fc\u010b"+
		"\5(\25\2\u00fd\u00fe\7\27\2\2\u00fe\u00ff\5(\25\2\u00ff\u0100\7\32\2\2"+
		"\u0100\u0105\5(\25\2\u0101\u0102\7\32\2\2\u0102\u0104\5(\25\2\u0103\u0101"+
		"\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\30\2\2\u0109\u010b\3"+
		"\2\2\2\u010a\u00fc\3\2\2\2\u010a\u00fd\3\2\2\2\u010b+\3\2\2\2\u010c\u0115"+
		"\7\27\2\2\u010d\u0112\5\34\17\2\u010e\u010f\7\32\2\2\u010f\u0111\5\34"+
		"\17\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u010d\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011b\7\30\2\2\u0118"+
		"\u0119\7\31\2\2\u0119\u011b\7\"\2\2\u011a\u010c\3\2\2\2\u011a\u0118\3"+
		"\2\2\2\u011b-\3\2\2\2\u011c\u011d\t\2\2\2\u011d/\3\2\2\2\36\63CNQUciq"+
		"\u0083\u00a0\u00ab\u00ad\u00bc\u00be\u00c4\u00ca\u00d1\u00d8\u00e1\u00e4"+
		"\u00ea\u00f5\u00fa\u0105\u010a\u0112\u0115\u011a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}