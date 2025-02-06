package org.leetvision.parser.antlr.go;

// Generated from ../src/main/java/org/leetvision/parser/go/GoParser.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GoParser extends GoParserBase {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BREAK=1, DEFAULT=2, FUNC=3, INTERFACE=4, SELECT=5, CASE=6, DEFER=7, GO=8, 
		MAP=9, STRUCT=10, CHAN=11, ELSE=12, GOTO=13, PACKAGE=14, SWITCH=15, CONST=16, 
		FALLTHROUGH=17, IF=18, RANGE=19, TYPE=20, CONTINUE=21, FOR=22, IMPORT=23, 
		RETURN=24, VAR=25, NIL_LIT=26, IDENTIFIER=27, L_PAREN=28, R_PAREN=29, 
		L_CURLY=30, R_CURLY=31, L_BRACKET=32, R_BRACKET=33, ASSIGN=34, COMMA=35, 
		SEMI=36, COLON=37, DOT=38, PLUS_PLUS=39, MINUS_MINUS=40, DECLARE_ASSIGN=41, 
		ELLIPSIS=42, LOGICAL_OR=43, LOGICAL_AND=44, EQUALS=45, NOT_EQUALS=46, 
		LESS=47, LESS_OR_EQUALS=48, GREATER=49, GREATER_OR_EQUALS=50, OR=51, DIV=52, 
		MOD=53, LSHIFT=54, RSHIFT=55, BIT_CLEAR=56, UNDERLYING=57, EXCLAMATION=58, 
		PLUS=59, MINUS=60, CARET=61, STAR=62, AMPERSAND=63, RECEIVE=64, DECIMAL_LIT=65, 
		BINARY_LIT=66, OCTAL_LIT=67, HEX_LIT=68, FLOAT_LIT=69, DECIMAL_FLOAT_LIT=70, 
		HEX_FLOAT_LIT=71, IMAGINARY_LIT=72, RUNE_LIT=73, BYTE_VALUE=74, OCTAL_BYTE_VALUE=75, 
		HEX_BYTE_VALUE=76, LITTLE_U_VALUE=77, BIG_U_VALUE=78, RAW_STRING_LIT=79, 
		INTERPRETED_STRING_LIT=80, WS=81, COMMENT=82, TERMINATOR=83, LINE_COMMENT=84, 
		WS_NLSEMI=85, COMMENT_NLSEMI=86, LINE_COMMENT_NLSEMI=87, EOS=88, OTHER=89;
	public static final int
		RULE_sourceFile = 0, RULE_packageClause = 1, RULE_importDecl = 2, RULE_importSpec = 3, 
		RULE_importPath = 4, RULE_declaration = 5, RULE_constDecl = 6, RULE_constSpec = 7, 
		RULE_identifierList = 8, RULE_expressionList = 9, RULE_typeDecl = 10, 
		RULE_typeSpec = 11, RULE_aliasDecl = 12, RULE_typeDef = 13, RULE_typeParameters = 14, 
		RULE_typeParameterDecl = 15, RULE_typeElement = 16, RULE_typeTerm = 17, 
		RULE_functionDecl = 18, RULE_methodDecl = 19, RULE_receiver = 20, RULE_varDecl = 21, 
		RULE_varSpec = 22, RULE_block = 23, RULE_statementList = 24, RULE_statement = 25, 
		RULE_simpleStmt = 26, RULE_expressionStmt = 27, RULE_sendStmt = 28, RULE_incDecStmt = 29, 
		RULE_assignment = 30, RULE_assign_op = 31, RULE_shortVarDecl = 32, RULE_labeledStmt = 33, 
		RULE_returnStmt = 34, RULE_breakStmt = 35, RULE_continueStmt = 36, RULE_gotoStmt = 37, 
		RULE_fallthroughStmt = 38, RULE_deferStmt = 39, RULE_ifStmt = 40, RULE_switchStmt = 41, 
		RULE_exprSwitchStmt = 42, RULE_exprCaseClause = 43, RULE_exprSwitchCase = 44, 
		RULE_typeSwitchStmt = 45, RULE_typeSwitchGuard = 46, RULE_typeCaseClause = 47, 
		RULE_typeSwitchCase = 48, RULE_typeList = 49, RULE_selectStmt = 50, RULE_commClause = 51, 
		RULE_commCase = 52, RULE_recvStmt = 53, RULE_forStmt = 54, RULE_forClause = 55, 
		RULE_rangeClause = 56, RULE_goStmt = 57, RULE_type_ = 58, RULE_typeArgs = 59, 
		RULE_typeName = 60, RULE_typeLit = 61, RULE_arrayType = 62, RULE_arrayLength = 63, 
		RULE_elementType = 64, RULE_pointerType = 65, RULE_interfaceType = 66, 
		RULE_sliceType = 67, RULE_mapType = 68, RULE_channelType = 69, RULE_methodSpec = 70, 
		RULE_functionType = 71, RULE_signature = 72, RULE_result = 73, RULE_parameters = 74, 
		RULE_parameterDecl = 75, RULE_expression = 76, RULE_primaryExpr = 77, 
		RULE_conversion = 78, RULE_operand = 79, RULE_literal = 80, RULE_basicLit = 81, 
		RULE_integer = 82, RULE_operandName = 83, RULE_qualifiedIdent = 84, RULE_compositeLit = 85, 
		RULE_literalType = 86, RULE_literalValue = 87, RULE_elementList = 88, 
		RULE_keyedElement = 89, RULE_key = 90, RULE_element = 91, RULE_structType = 92, 
		RULE_fieldDecl = 93, RULE_string_ = 94, RULE_embeddedField = 95, RULE_functionLit = 96, 
		RULE_index = 97, RULE_slice_ = 98, RULE_typeAssertion = 99, RULE_arguments = 100, 
		RULE_methodExpr = 101, RULE_eos = 102;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceFile", "packageClause", "importDecl", "importSpec", "importPath", 
			"declaration", "constDecl", "constSpec", "identifierList", "expressionList", 
			"typeDecl", "typeSpec", "aliasDecl", "typeDef", "typeParameters", "typeParameterDecl", 
			"typeElement", "typeTerm", "functionDecl", "methodDecl", "receiver", 
			"varDecl", "varSpec", "block", "statementList", "statement", "simpleStmt", 
			"expressionStmt", "sendStmt", "incDecStmt", "assignment", "assign_op", 
			"shortVarDecl", "labeledStmt", "returnStmt", "breakStmt", "continueStmt", 
			"gotoStmt", "fallthroughStmt", "deferStmt", "ifStmt", "switchStmt", "exprSwitchStmt", 
			"exprCaseClause", "exprSwitchCase", "typeSwitchStmt", "typeSwitchGuard", 
			"typeCaseClause", "typeSwitchCase", "typeList", "selectStmt", "commClause", 
			"commCase", "recvStmt", "forStmt", "forClause", "rangeClause", "goStmt", 
			"type_", "typeArgs", "typeName", "typeLit", "arrayType", "arrayLength", 
			"elementType", "pointerType", "interfaceType", "sliceType", "mapType", 
			"channelType", "methodSpec", "functionType", "signature", "result", "parameters", 
			"parameterDecl", "expression", "primaryExpr", "conversion", "operand", 
			"literal", "basicLit", "integer", "operandName", "qualifiedIdent", "compositeLit", 
			"literalType", "literalValue", "elementList", "keyedElement", "key", 
			"element", "structType", "fieldDecl", "string_", "embeddedField", "functionLit", 
			"index", "slice_", "typeAssertion", "arguments", "methodExpr", "eos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'default'", "'func'", "'interface'", "'select'", "'case'", 
			"'defer'", "'go'", "'map'", "'struct'", "'chan'", "'else'", "'goto'", 
			"'package'", "'switch'", "'const'", "'fallthrough'", "'if'", "'range'", 
			"'type'", "'continue'", "'for'", "'import'", "'return'", "'var'", "'nil'", 
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'='", "','", "';'", 
			"':'", "'.'", "'++'", "'--'", "':='", "'...'", "'||'", "'&&'", "'=='", 
			"'!='", "'<'", "'<='", "'>'", "'>='", "'|'", "'/'", "'%'", "'<<'", "'>>'", 
			"'&^'", "'~'", "'!'", "'+'", "'-'", "'^'", "'*'", "'&'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BREAK", "DEFAULT", "FUNC", "INTERFACE", "SELECT", "CASE", "DEFER", 
			"GO", "MAP", "STRUCT", "CHAN", "ELSE", "GOTO", "PACKAGE", "SWITCH", "CONST", 
			"FALLTHROUGH", "IF", "RANGE", "TYPE", "CONTINUE", "FOR", "IMPORT", "RETURN", 
			"VAR", "NIL_LIT", "IDENTIFIER", "L_PAREN", "R_PAREN", "L_CURLY", "R_CURLY", 
			"L_BRACKET", "R_BRACKET", "ASSIGN", "COMMA", "SEMI", "COLON", "DOT", 
			"PLUS_PLUS", "MINUS_MINUS", "DECLARE_ASSIGN", "ELLIPSIS", "LOGICAL_OR", 
			"LOGICAL_AND", "EQUALS", "NOT_EQUALS", "LESS", "LESS_OR_EQUALS", "GREATER", 
			"GREATER_OR_EQUALS", "OR", "DIV", "MOD", "LSHIFT", "RSHIFT", "BIT_CLEAR", 
			"UNDERLYING", "EXCLAMATION", "PLUS", "MINUS", "CARET", "STAR", "AMPERSAND", 
			"RECEIVE", "DECIMAL_LIT", "BINARY_LIT", "OCTAL_LIT", "HEX_LIT", "FLOAT_LIT", 
			"DECIMAL_FLOAT_LIT", "HEX_FLOAT_LIT", "IMAGINARY_LIT", "RUNE_LIT", "BYTE_VALUE", 
			"OCTAL_BYTE_VALUE", "HEX_BYTE_VALUE", "LITTLE_U_VALUE", "BIG_U_VALUE", 
			"RAW_STRING_LIT", "INTERPRETED_STRING_LIT", "WS", "COMMENT", "TERMINATOR", 
			"LINE_COMMENT", "WS_NLSEMI", "COMMENT_NLSEMI", "LINE_COMMENT_NLSEMI", 
			"EOS", "OTHER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GoParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GoParser.EOF, 0); }
		public PackageClauseContext packageClause() {
			return getRuleContext(PackageClauseContext.class,0);
		}
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public SourceFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSourceFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSourceFile(this);
		}
	}

	public final SourceFileContext sourceFile() throws RecognitionException {
		SourceFileContext _localctx = new SourceFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(206);
				packageClause();
				setState(207);
				eos();
				}
			}

			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(211);
				importDecl();
				setState(212);
				eos();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34668552L) != 0)) {
				{
				{
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(219);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(220);
					methodDecl();
					}
					break;
				case 3:
					{
					setState(221);
					declaration();
					}
					break;
				}
				setState(224);
				eos();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageClauseContext extends ParserRuleContext {
		public Token packageName;
		public TerminalNode PACKAGE() { return getToken(GoParser.PACKAGE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public PackageClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterPackageClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitPackageClause(this);
		}
	}

	public final PackageClauseContext packageClause() throws RecognitionException {
		PackageClauseContext _localctx = new PackageClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(PACKAGE);
			setState(234);
			((PackageClauseContext)_localctx).packageName = match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(GoParser.IMPORT, 0); }
		public List<ImportSpecContext> importSpec() {
			return getRuleContexts(ImportSpecContext.class);
		}
		public ImportSpecContext importSpec(int i) {
			return getRuleContext(ImportSpecContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitImportDecl(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(IMPORT);
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case DOT:
			case RAW_STRING_LIT:
			case INTERPRETED_STRING_LIT:
				{
				setState(237);
				importSpec();
				}
				break;
			case L_PAREN:
				{
				setState(238);
				match(L_PAREN);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 13510798882113537L) != 0)) {
					{
					{
					setState(239);
					importSpec();
					setState(240);
					eos();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSpecContext extends ParserRuleContext {
		public Token alias;
		public ImportPathContext importPath() {
			return getRuleContext(ImportPathContext.class,0);
		}
		public TerminalNode DOT() { return getToken(GoParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public ImportSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterImportSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitImportSpec(this);
		}
	}

	public final ImportSpecContext importSpec() throws RecognitionException {
		ImportSpecContext _localctx = new ImportSpecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==DOT) {
				{
				setState(250);
				((ImportSpecContext)_localctx).alias = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==DOT) ) {
					((ImportSpecContext)_localctx).alias = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(253);
			importPath();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportPathContext extends ParserRuleContext {
		public String_Context string_() {
			return getRuleContext(String_Context.class,0);
		}
		public ImportPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterImportPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitImportPath(this);
		}
	}

	public final ImportPathContext importPath() throws RecognitionException {
		ImportPathContext _localctx = new ImportPathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			string_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				constDecl();
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				typeDecl();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				varDecl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GoParser.CONST, 0); }
		public List<ConstSpecContext> constSpec() {
			return getRuleContexts(ConstSpecContext.class);
		}
		public ConstSpecContext constSpec(int i) {
			return getRuleContext(ConstSpecContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitConstDecl(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(CONST);
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(263);
				constSpec();
				}
				break;
			case L_PAREN:
				{
				setState(264);
				match(L_PAREN);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(265);
					constSpec();
					setState(266);
					eos();
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(273);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstSpecContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GoParser.ASSIGN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public ConstSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterConstSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitConstSpec(this);
		}
	}

	public final ConstSpecContext constSpec() throws RecognitionException {
		ConstSpecContext _localctx = new ConstSpecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			identifierList();
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 2882303762104320451L) != 0)) {
					{
					setState(277);
					type_();
					}
				}

				setState(280);
				match(ASSIGN);
				setState(281);
				expressionList();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GoParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GoParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(IDENTIFIER);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(285);
					match(COMMA);
					setState(286);
					match(IDENTIFIER);
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			expression(0);
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(293);
					match(COMMA);
					setState(294);
					expression(0);
					}
					} 
				}
				setState(299);
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
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(GoParser.TYPE, 0); }
		public List<TypeSpecContext> typeSpec() {
			return getRuleContexts(TypeSpecContext.class);
		}
		public TypeSpecContext typeSpec(int i) {
			return getRuleContext(TypeSpecContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(TYPE);
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(301);
				typeSpec();
				}
				break;
			case L_PAREN:
				{
				setState(302);
				match(L_PAREN);
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(303);
					typeSpec();
					setState(304);
					eos();
					}
					}
					setState(310);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(311);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecContext extends ParserRuleContext {
		public AliasDeclContext aliasDecl() {
			return getRuleContext(AliasDeclContext.class,0);
		}
		public TypeDefContext typeDef() {
			return getRuleContext(TypeDefContext.class,0);
		}
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeSpec(this);
		}
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeSpec);
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				aliasDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				typeDef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AliasDeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(GoParser.ASSIGN, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public AliasDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterAliasDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitAliasDecl(this);
		}
	}

	public final AliasDeclContext aliasDecl() throws RecognitionException {
		AliasDeclContext _localctx = new AliasDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aliasDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(IDENTIFIER);
			setState(319);
			match(ASSIGN);
			setState(320);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDefContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeDef(this);
		}
	}

	public final TypeDefContext typeDef() throws RecognitionException {
		TypeDefContext _localctx = new TypeDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(IDENTIFIER);
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(323);
				typeParameters();
				}
				break;
			}
			setState(326);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public List<TypeParameterDeclContext> typeParameterDecl() {
			return getRuleContexts(TypeParameterDeclContext.class);
		}
		public TypeParameterDeclContext typeParameterDecl(int i) {
			return getRuleContext(TypeParameterDeclContext.class,i);
		}
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(L_BRACKET);
			setState(329);
			typeParameterDecl();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(330);
				match(COMMA);
				setState(331);
				typeParameterDecl();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(337);
			match(R_BRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterDeclContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TypeElementContext typeElement() {
			return getRuleContext(TypeElementContext.class,0);
		}
		public TypeParameterDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeParameterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeParameterDecl(this);
		}
	}

	public final TypeParameterDeclContext typeParameterDecl() throws RecognitionException {
		TypeParameterDeclContext _localctx = new TypeParameterDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeParameterDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			identifierList();
			setState(340);
			typeElement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeElementContext extends ParserRuleContext {
		public List<TypeTermContext> typeTerm() {
			return getRuleContexts(TypeTermContext.class);
		}
		public TypeTermContext typeTerm(int i) {
			return getRuleContext(TypeTermContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(GoParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(GoParser.OR, i);
		}
		public TypeElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeElement(this);
		}
	}

	public final TypeElementContext typeElement() throws RecognitionException {
		TypeElementContext _localctx = new TypeElementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeElement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			typeTerm();
			setState(347);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(343);
					match(OR);
					setState(344);
					typeTerm();
					}
					} 
				}
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeTermContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode UNDERLYING() { return getToken(GoParser.UNDERLYING, 0); }
		public TypeTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeTerm(this);
		}
	}

	public final TypeTermContext typeTerm() throws RecognitionException {
		TypeTermContext _localctx = new TypeTermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDERLYING) {
				{
				setState(350);
				match(UNDERLYING);
				}
			}

			setState(353);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(GoParser.FUNC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(FUNC);
			setState(356);
			match(IDENTIFIER);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_BRACKET) {
				{
				setState(357);
				typeParameters();
				}
			}

			setState(360);
			signature();
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(361);
				block();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(GoParser.FUNC, 0); }
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitMethodDecl(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(FUNC);
			setState(365);
			receiver();
			setState(366);
			match(IDENTIFIER);
			setState(367);
			signature();
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(368);
				block();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverContext extends ParserRuleContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitReceiver(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_receiver);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			parameters();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(GoParser.VAR, 0); }
		public List<VarSpecContext> varSpec() {
			return getRuleContexts(VarSpecContext.class);
		}
		public VarSpecContext varSpec(int i) {
			return getRuleContext(VarSpecContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(VAR);
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(374);
				varSpec();
				}
				break;
			case L_PAREN:
				{
				setState(375);
				match(L_PAREN);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIER) {
					{
					{
					setState(376);
					varSpec();
					setState(377);
					eos();
					}
					}
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(384);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarSpecContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GoParser.ASSIGN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public VarSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterVarSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitVarSpec(this);
		}
	}

	public final VarSpecContext varSpec() throws RecognitionException {
		VarSpecContext _localctx = new VarSpecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_varSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			identifierList();
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
			case INTERFACE:
			case MAP:
			case STRUCT:
			case CHAN:
			case IDENTIFIER:
			case L_PAREN:
			case L_BRACKET:
			case STAR:
			case RECEIVE:
				{
				setState(388);
				type_();
				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(389);
					match(ASSIGN);
					setState(390);
					expressionList();
					}
					break;
				}
				}
				break;
			case ASSIGN:
				{
				setState(393);
				match(ASSIGN);
				setState(394);
				expressionList();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(L_CURLY);
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(398);
				statementList();
				}
				break;
			}
			setState(401);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(GoParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(GoParser.SEMI, i);
		}
		public List<TerminalNode> EOS() { return getTokens(GoParser.EOS); }
		public TerminalNode EOS(int i) {
			return getToken(GoParser.EOS, i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitStatementList(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_statementList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(415); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(410);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(404);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SEMI) {
							{
							setState(403);
							match(SEMI);
							}
						}

						}
						break;
					case 2:
						{
						setState(407);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==EOS) {
							{
							setState(406);
							match(EOS);
							}
						}

						}
						break;
					case 3:
						{
						setState(409);
						if (!(this.closingBracket())) throw new FailedPredicateException(this, "this.closingBracket()");
						}
						break;
					}
					setState(412);
					statement();
					setState(413);
					eos();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(417); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public LabeledStmtContext labeledStmt() {
			return getRuleContext(LabeledStmtContext.class,0);
		}
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public GoStmtContext goStmt() {
			return getRuleContext(GoStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public GotoStmtContext gotoStmt() {
			return getRuleContext(GotoStmtContext.class,0);
		}
		public FallthroughStmtContext fallthroughStmt() {
			return getRuleContext(FallthroughStmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public SwitchStmtContext switchStmt() {
			return getRuleContext(SwitchStmtContext.class,0);
		}
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public DeferStmtContext deferStmt() {
			return getRuleContext(DeferStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_statement);
		try {
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				labeledStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(421);
				simpleStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				goStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(423);
				returnStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(424);
				breakStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(425);
				continueStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(426);
				gotoStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(427);
				fallthroughStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(428);
				block();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(429);
				ifStmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(430);
				switchStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(431);
				selectStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(432);
				forStmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(433);
				deferStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStmtContext extends ParserRuleContext {
		public SendStmtContext sendStmt() {
			return getRuleContext(SendStmtContext.class,0);
		}
		public IncDecStmtContext incDecStmt() {
			return getRuleContext(IncDecStmtContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionStmtContext expressionStmt() {
			return getRuleContext(ExpressionStmtContext.class,0);
		}
		public ShortVarDeclContext shortVarDecl() {
			return getRuleContext(ShortVarDeclContext.class,0);
		}
		public SimpleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSimpleStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSimpleStmt(this);
		}
	}

	public final SimpleStmtContext simpleStmt() throws RecognitionException {
		SimpleStmtContext _localctx = new SimpleStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_simpleStmt);
		try {
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				sendStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				incDecStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(438);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(439);
				expressionStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(440);
				shortVarDecl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitExpressionStmt(this);
		}
	}

	public final ExpressionStmtContext expressionStmt() throws RecognitionException {
		ExpressionStmtContext _localctx = new ExpressionStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SendStmtContext extends ParserRuleContext {
		public ExpressionContext channel;
		public TerminalNode RECEIVE() { return getToken(GoParser.RECEIVE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SendStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sendStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSendStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSendStmt(this);
		}
	}

	public final SendStmtContext sendStmt() throws RecognitionException {
		SendStmtContext _localctx = new SendStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sendStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			((SendStmtContext)_localctx).channel = expression(0);
			setState(446);
			match(RECEIVE);
			setState(447);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncDecStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS_PLUS() { return getToken(GoParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_MINUS() { return getToken(GoParser.MINUS_MINUS, 0); }
		public IncDecStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDecStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterIncDecStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitIncDecStmt(this);
		}
	}

	public final IncDecStmtContext incDecStmt() throws RecognitionException {
		IncDecStmtContext _localctx = new IncDecStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_incDecStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			expression(0);
			setState(450);
			_la = _input.LA(1);
			if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			expressionList();
			setState(453);
			assign_op();
			setState(454);
			expressionList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(GoParser.ASSIGN, 0); }
		public TerminalNode PLUS() { return getToken(GoParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GoParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(GoParser.OR, 0); }
		public TerminalNode CARET() { return getToken(GoParser.CARET, 0); }
		public TerminalNode STAR() { return getToken(GoParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(GoParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GoParser.MOD, 0); }
		public TerminalNode LSHIFT() { return getToken(GoParser.LSHIFT, 0); }
		public TerminalNode RSHIFT() { return getToken(GoParser.RSHIFT, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoParser.AMPERSAND, 0); }
		public TerminalNode BIT_CLEAR() { return getToken(GoParser.BIT_CLEAR, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitAssign_op(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -434597364041252864L) != 0)) {
				{
				setState(456);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -434597364041252864L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(459);
			match(ASSIGN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ShortVarDeclContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode DECLARE_ASSIGN() { return getToken(GoParser.DECLARE_ASSIGN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ShortVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterShortVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitShortVarDecl(this);
		}
	}

	public final ShortVarDeclContext shortVarDecl() throws RecognitionException {
		ShortVarDeclContext _localctx = new ShortVarDeclContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_shortVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			identifierList();
			setState(462);
			match(DECLARE_ASSIGN);
			setState(463);
			expressionList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabeledStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(GoParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterLabeledStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitLabeledStmt(this);
		}
	}

	public final LabeledStmtContext labeledStmt() throws RecognitionException {
		LabeledStmtContext _localctx = new LabeledStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_labeledStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(IDENTIFIER);
			setState(466);
			match(COLON);
			setState(468);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(467);
				statement();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(GoParser.RETURN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			match(RETURN);
			setState(472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(471);
				expressionList();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(GoParser.BREAK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitBreakStmt(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(BREAK);
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(475);
				match(IDENTIFIER);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(GoParser.CONTINUE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitContinueStmt(this);
		}
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(CONTINUE);
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(479);
				match(IDENTIFIER);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class GotoStmtContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(GoParser.GOTO, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public GotoStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterGotoStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitGotoStmt(this);
		}
	}

	public final GotoStmtContext gotoStmt() throws RecognitionException {
		GotoStmtContext _localctx = new GotoStmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_gotoStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(GOTO);
			setState(483);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FallthroughStmtContext extends ParserRuleContext {
		public TerminalNode FALLTHROUGH() { return getToken(GoParser.FALLTHROUGH, 0); }
		public FallthroughStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fallthroughStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterFallthroughStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitFallthroughStmt(this);
		}
	}

	public final FallthroughStmtContext fallthroughStmt() throws RecognitionException {
		FallthroughStmtContext _localctx = new FallthroughStmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_fallthroughStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(FALLTHROUGH);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeferStmtContext extends ParserRuleContext {
		public TerminalNode DEFER() { return getToken(GoParser.DEFER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeferStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deferStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterDeferStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitDeferStmt(this);
		}
	}

	public final DeferStmtContext deferStmt() throws RecognitionException {
		DeferStmtContext _localctx = new DeferStmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_deferStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(DEFER);
			setState(488);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GoParser.IF, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(GoParser.ELSE, 0); }
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(IF);
			setState(499);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(491);
				expression(0);
				}
				break;
			case 2:
				{
				setState(492);
				eos();
				setState(493);
				expression(0);
				}
				break;
			case 3:
				{
				setState(495);
				simpleStmt();
				setState(496);
				eos();
				setState(497);
				expression(0);
				}
				break;
			}
			setState(501);
			block();
			setState(507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(502);
				match(ELSE);
				setState(505);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
					{
					setState(503);
					ifStmt();
					}
					break;
				case L_CURLY:
					{
					setState(504);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends ParserRuleContext {
		public ExprSwitchStmtContext exprSwitchStmt() {
			return getRuleContext(ExprSwitchStmtContext.class,0);
		}
		public TypeSwitchStmtContext typeSwitchStmt() {
			return getRuleContext(TypeSwitchStmtContext.class,0);
		}
		public SwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSwitchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSwitchStmt(this);
		}
	}

	public final SwitchStmtContext switchStmt() throws RecognitionException {
		SwitchStmtContext _localctx = new SwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_switchStmt);
		try {
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				exprSwitchStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				typeSwitchStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprSwitchStmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(GoParser.SWITCH, 0); }
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public List<ExprCaseClauseContext> exprCaseClause() {
			return getRuleContexts(ExprCaseClauseContext.class);
		}
		public ExprCaseClauseContext exprCaseClause(int i) {
			return getRuleContext(ExprCaseClauseContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public ExprSwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSwitchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterExprSwitchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitExprSwitchStmt(this);
		}
	}

	public final ExprSwitchStmtContext exprSwitchStmt() throws RecognitionException {
		ExprSwitchStmtContext _localctx = new ExprSwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_exprSwitchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(SWITCH);
			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(514);
					expression(0);
					}
				}

				}
				break;
			case 2:
				{
				setState(518);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(517);
					simpleStmt();
					}
					break;
				}
				setState(520);
				eos();
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(521);
					expression(0);
					}
				}

				}
				break;
			}
			setState(526);
			match(L_CURLY);
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT || _la==CASE) {
				{
				{
				setState(527);
				exprCaseClause();
				}
				}
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(533);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprCaseClauseContext extends ParserRuleContext {
		public ExprSwitchCaseContext exprSwitchCase() {
			return getRuleContext(ExprSwitchCaseContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GoParser.COLON, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ExprCaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprCaseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterExprCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitExprCaseClause(this);
		}
	}

	public final ExprCaseClauseContext exprCaseClause() throws RecognitionException {
		ExprCaseClauseContext _localctx = new ExprCaseClauseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_exprCaseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			exprSwitchCase();
			setState(536);
			match(COLON);
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(537);
				statementList();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprSwitchCaseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(GoParser.CASE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(GoParser.DEFAULT, 0); }
		public ExprSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterExprSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitExprSwitchCase(this);
		}
	}

	public final ExprSwitchCaseContext exprSwitchCase() throws RecognitionException {
		ExprSwitchCaseContext _localctx = new ExprSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_exprSwitchCase);
		try {
			setState(543);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(CASE);
				setState(541);
				expressionList();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(542);
				match(DEFAULT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSwitchStmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(GoParser.SWITCH, 0); }
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public TypeSwitchGuardContext typeSwitchGuard() {
			return getRuleContext(TypeSwitchGuardContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public List<TypeCaseClauseContext> typeCaseClause() {
			return getRuleContexts(TypeCaseClauseContext.class);
		}
		public TypeCaseClauseContext typeCaseClause(int i) {
			return getRuleContext(TypeCaseClauseContext.class,i);
		}
		public TypeSwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSwitchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeSwitchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeSwitchStmt(this);
		}
	}

	public final TypeSwitchStmtContext typeSwitchStmt() throws RecognitionException {
		TypeSwitchStmtContext _localctx = new TypeSwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_typeSwitchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			match(SWITCH);
			setState(554);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(546);
				typeSwitchGuard();
				}
				break;
			case 2:
				{
				setState(547);
				eos();
				setState(548);
				typeSwitchGuard();
				}
				break;
			case 3:
				{
				setState(550);
				simpleStmt();
				setState(551);
				eos();
				setState(552);
				typeSwitchGuard();
				}
				break;
			}
			setState(556);
			match(L_CURLY);
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT || _la==CASE) {
				{
				{
				setState(557);
				typeCaseClause();
				}
				}
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(563);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSwitchGuardContext extends ParserRuleContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(GoParser.DOT, 0); }
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode TYPE() { return getToken(GoParser.TYPE, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public TerminalNode DECLARE_ASSIGN() { return getToken(GoParser.DECLARE_ASSIGN, 0); }
		public TypeSwitchGuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSwitchGuard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeSwitchGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeSwitchGuard(this);
		}
	}

	public final TypeSwitchGuardContext typeSwitchGuard() throws RecognitionException {
		TypeSwitchGuardContext _localctx = new TypeSwitchGuardContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_typeSwitchGuard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(565);
				match(IDENTIFIER);
				setState(566);
				match(DECLARE_ASSIGN);
				}
				break;
			}
			setState(569);
			primaryExpr(0);
			setState(570);
			match(DOT);
			setState(571);
			match(L_PAREN);
			setState(572);
			match(TYPE);
			setState(573);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeCaseClauseContext extends ParserRuleContext {
		public TypeSwitchCaseContext typeSwitchCase() {
			return getRuleContext(TypeSwitchCaseContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GoParser.COLON, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TypeCaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCaseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeCaseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeCaseClause(this);
		}
	}

	public final TypeCaseClauseContext typeCaseClause() throws RecognitionException {
		TypeCaseClauseContext _localctx = new TypeCaseClauseContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_typeCaseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			typeSwitchCase();
			setState(576);
			match(COLON);
			setState(578);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(577);
				statementList();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSwitchCaseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(GoParser.CASE, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(GoParser.DEFAULT, 0); }
		public TypeSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeSwitchCase(this);
		}
	}

	public final TypeSwitchCaseContext typeSwitchCase() throws RecognitionException {
		TypeSwitchCaseContext _localctx = new TypeSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_typeSwitchCase);
		try {
			setState(583);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(580);
				match(CASE);
				setState(581);
				typeList();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
				match(DEFAULT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends ParserRuleContext {
		public List<Type_Context> type_() {
			return getRuleContexts(Type_Context.class);
		}
		public Type_Context type_(int i) {
			return getRuleContext(Type_Context.class,i);
		}
		public List<TerminalNode> NIL_LIT() { return getTokens(GoParser.NIL_LIT); }
		public TerminalNode NIL_LIT(int i) {
			return getToken(GoParser.NIL_LIT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_typeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
			case INTERFACE:
			case MAP:
			case STRUCT:
			case CHAN:
			case IDENTIFIER:
			case L_PAREN:
			case L_BRACKET:
			case STAR:
			case RECEIVE:
				{
				setState(585);
				type_();
				}
				break;
			case NIL_LIT:
				{
				setState(586);
				match(NIL_LIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(596);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(589);
					match(COMMA);
					setState(592);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FUNC:
					case INTERFACE:
					case MAP:
					case STRUCT:
					case CHAN:
					case IDENTIFIER:
					case L_PAREN:
					case L_BRACKET:
					case STAR:
					case RECEIVE:
						{
						setState(590);
						type_();
						}
						break;
					case NIL_LIT:
						{
						setState(591);
						match(NIL_LIT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(598);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStmtContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(GoParser.SELECT, 0); }
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public List<CommClauseContext> commClause() {
			return getRuleContexts(CommClauseContext.class);
		}
		public CommClauseContext commClause(int i) {
			return getRuleContext(CommClauseContext.class,i);
		}
		public SelectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSelectStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSelectStmt(this);
		}
	}

	public final SelectStmtContext selectStmt() throws RecognitionException {
		SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_selectStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(SELECT);
			setState(600);
			match(L_CURLY);
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFAULT || _la==CASE) {
				{
				{
				setState(601);
				commClause();
				}
				}
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(607);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CommClauseContext extends ParserRuleContext {
		public CommCaseContext commCase() {
			return getRuleContext(CommCaseContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GoParser.COLON, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public CommClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterCommClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitCommClause(this);
		}
	}

	public final CommClauseContext commClause() throws RecognitionException {
		CommClauseContext _localctx = new CommClauseContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_commClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			commCase();
			setState(610);
			match(COLON);
			setState(612);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(611);
				statementList();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class CommCaseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(GoParser.CASE, 0); }
		public SendStmtContext sendStmt() {
			return getRuleContext(SendStmtContext.class,0);
		}
		public RecvStmtContext recvStmt() {
			return getRuleContext(RecvStmtContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(GoParser.DEFAULT, 0); }
		public CommCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterCommCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitCommCase(this);
		}
	}

	public final CommCaseContext commCase() throws RecognitionException {
		CommCaseContext _localctx = new CommCaseContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_commCase);
		try {
			setState(620);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(614);
				match(CASE);
				setState(617);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(615);
					sendStmt();
					}
					break;
				case 2:
					{
					setState(616);
					recvStmt();
					}
					break;
				}
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(619);
				match(DEFAULT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecvStmtContext extends ParserRuleContext {
		public ExpressionContext recvExpr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GoParser.ASSIGN, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode DECLARE_ASSIGN() { return getToken(GoParser.DECLARE_ASSIGN, 0); }
		public RecvStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recvStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterRecvStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitRecvStmt(this);
		}
	}

	public final RecvStmtContext recvStmt() throws RecognitionException {
		RecvStmtContext _localctx = new RecvStmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_recvStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(622);
				expressionList();
				setState(623);
				match(ASSIGN);
				}
				break;
			case 2:
				{
				setState(625);
				identifierList();
				setState(626);
				match(DECLARE_ASSIGN);
				}
				break;
			}
			setState(630);
			((RecvStmtContext)_localctx).recvExpr = expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(GoParser.FOR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RangeClauseContext rangeClause() {
			return getRuleContext(RangeClauseContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitForStmt(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(FOR);
			setState(640);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(634);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(633);
					expression(0);
					}
				}

				}
				break;
			case 2:
				{
				setState(636);
				forClause();
				}
				break;
			case 3:
				{
				setState(638);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386454504L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(637);
					rangeClause();
					}
				}

				}
				break;
			}
			setState(642);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForClauseContext extends ParserRuleContext {
		public SimpleStmtContext initStmt;
		public SimpleStmtContext postStmt;
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<SimpleStmtContext> simpleStmt() {
			return getRuleContexts(SimpleStmtContext.class);
		}
		public SimpleStmtContext simpleStmt(int i) {
			return getRuleContext(SimpleStmtContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitForClause(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(644);
				((ForClauseContext)_localctx).initStmt = simpleStmt();
				}
				break;
			}
			setState(647);
			eos();
			setState(649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(648);
				expression(0);
				}
				break;
			}
			setState(651);
			eos();
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
				{
				setState(652);
				((ForClauseContext)_localctx).postStmt = simpleStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RangeClauseContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(GoParser.RANGE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GoParser.ASSIGN, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode DECLARE_ASSIGN() { return getToken(GoParser.DECLARE_ASSIGN, 0); }
		public RangeClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterRangeClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitRangeClause(this);
		}
	}

	public final RangeClauseContext rangeClause() throws RecognitionException {
		RangeClauseContext _localctx = new RangeClauseContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_rangeClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(655);
				expressionList();
				setState(656);
				match(ASSIGN);
				}
				break;
			case 2:
				{
				setState(658);
				identifierList();
				setState(659);
				match(DECLARE_ASSIGN);
				}
				break;
			}
			setState(663);
			match(RANGE);
			setState(664);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GoStmtContext extends ParserRuleContext {
		public TerminalNode GO() { return getToken(GoParser.GO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GoStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterGoStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitGoStmt(this);
		}
	}

	public final GoStmtContext goStmt() throws RecognitionException {
		GoStmtContext _localctx = new GoStmtContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_goStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(GO);
			setState(667);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Type_Context extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public TypeLitContext typeLit() {
			return getRuleContext(TypeLitContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterType_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitType_(this);
		}
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 116, RULE_type_);
		try {
			setState(678);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				typeName();
				setState(671);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(670);
					typeArgs();
					}
					break;
				}
				}
				break;
			case FUNC:
			case INTERFACE:
			case MAP:
			case STRUCT:
			case CHAN:
			case L_BRACKET:
			case STAR:
			case RECEIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				typeLit();
				}
				break;
			case L_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(674);
				match(L_PAREN);
				setState(675);
				type_();
				setState(676);
				match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgsContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public TerminalNode COMMA() { return getToken(GoParser.COMMA, 0); }
		public TypeArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeArgs(this);
		}
	}

	public final TypeArgsContext typeArgs() throws RecognitionException {
		TypeArgsContext _localctx = new TypeArgsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_typeArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(L_BRACKET);
			setState(681);
			typeList();
			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(682);
				match(COMMA);
				}
			}

			setState(685);
			match(R_BRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public QualifiedIdentContext qualifiedIdent() {
			return getRuleContext(QualifiedIdentContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_typeName);
		try {
			setState(689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				qualifiedIdent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(688);
				match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeLitContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public PointerTypeContext pointerType() {
			return getRuleContext(PointerTypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public InterfaceTypeContext interfaceType() {
			return getRuleContext(InterfaceTypeContext.class,0);
		}
		public SliceTypeContext sliceType() {
			return getRuleContext(SliceTypeContext.class,0);
		}
		public MapTypeContext mapType() {
			return getRuleContext(MapTypeContext.class,0);
		}
		public ChannelTypeContext channelType() {
			return getRuleContext(ChannelTypeContext.class,0);
		}
		public TypeLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeLit(this);
		}
	}

	public final TypeLitContext typeLit() throws RecognitionException {
		TypeLitContext _localctx = new TypeLitContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_typeLit);
		try {
			setState(699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(691);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(692);
				structType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(693);
				pointerType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(694);
				functionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(695);
				interfaceType();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(696);
				sliceType();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(697);
				mapType();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(698);
				channelType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public ArrayLengthContext arrayLength() {
			return getRuleContext(ArrayLengthContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public ElementTypeContext elementType() {
			return getRuleContext(ElementTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitArrayType(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			match(L_BRACKET);
			setState(702);
			arrayLength();
			setState(703);
			match(R_BRACKET);
			setState(704);
			elementType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLengthContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterArrayLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitArrayLength(this);
		}
	}

	public final ArrayLengthContext arrayLength() throws RecognitionException {
		ArrayLengthContext _localctx = new ArrayLengthContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_arrayLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementTypeContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public ElementTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterElementType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitElementType(this);
		}
	}

	public final ElementTypeContext elementType() throws RecognitionException {
		ElementTypeContext _localctx = new ElementTypeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_elementType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PointerTypeContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(GoParser.STAR, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public PointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterPointerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitPointerType(this);
		}
	}

	public final PointerTypeContext pointerType() throws RecognitionException {
		PointerTypeContext _localctx = new PointerTypeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_pointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(STAR);
			setState(711);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceTypeContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(GoParser.INTERFACE, 0); }
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public List<MethodSpecContext> methodSpec() {
			return getRuleContexts(MethodSpecContext.class);
		}
		public MethodSpecContext methodSpec(int i) {
			return getRuleContext(MethodSpecContext.class,i);
		}
		public List<TypeElementContext> typeElement() {
			return getRuleContexts(TypeElementContext.class);
		}
		public TypeElementContext typeElement(int i) {
			return getRuleContext(TypeElementContext.class,i);
		}
		public InterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitInterfaceType(this);
		}
	}

	public final InterfaceTypeContext interfaceType() throws RecognitionException {
		InterfaceTypeContext _localctx = new InterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_interfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			match(INTERFACE);
			setState(714);
			match(L_CURLY);
			setState(723);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 2900318160613802435L) != 0)) {
				{
				{
				setState(717);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(715);
					methodSpec();
					}
					break;
				case 2:
					{
					setState(716);
					typeElement();
					}
					break;
				}
				setState(719);
				eos();
				}
				}
				setState(725);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(726);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SliceTypeContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public ElementTypeContext elementType() {
			return getRuleContext(ElementTypeContext.class,0);
		}
		public SliceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSliceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSliceType(this);
		}
	}

	public final SliceTypeContext sliceType() throws RecognitionException {
		SliceTypeContext _localctx = new SliceTypeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_sliceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			match(L_BRACKET);
			setState(729);
			match(R_BRACKET);
			setState(730);
			elementType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MapTypeContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(GoParser.MAP, 0); }
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public ElementTypeContext elementType() {
			return getRuleContext(ElementTypeContext.class,0);
		}
		public MapTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterMapType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitMapType(this);
		}
	}

	public final MapTypeContext mapType() throws RecognitionException {
		MapTypeContext _localctx = new MapTypeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_mapType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(MAP);
			setState(733);
			match(L_BRACKET);
			setState(734);
			type_();
			setState(735);
			match(R_BRACKET);
			setState(736);
			elementType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ChannelTypeContext extends ParserRuleContext {
		public ElementTypeContext elementType() {
			return getRuleContext(ElementTypeContext.class,0);
		}
		public TerminalNode CHAN() { return getToken(GoParser.CHAN, 0); }
		public TerminalNode RECEIVE() { return getToken(GoParser.RECEIVE, 0); }
		public ChannelTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterChannelType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitChannelType(this);
		}
	}

	public final ChannelTypeContext channelType() throws RecognitionException {
		ChannelTypeContext _localctx = new ChannelTypeContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_channelType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(738);
				match(CHAN);
				}
				break;
			case 2:
				{
				setState(739);
				match(CHAN);
				setState(740);
				match(RECEIVE);
				}
				break;
			case 3:
				{
				setState(741);
				match(RECEIVE);
				setState(742);
				match(CHAN);
				}
				break;
			}
			setState(745);
			elementType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodSpecContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MethodSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterMethodSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitMethodSpec(this);
		}
	}

	public final MethodSpecContext methodSpec() throws RecognitionException {
		MethodSpecContext _localctx = new MethodSpecContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_methodSpec);
		try {
			setState(753);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(747);
				match(IDENTIFIER);
				setState(748);
				parameters();
				setState(749);
				result();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(751);
				match(IDENTIFIER);
				setState(752);
				parameters();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(GoParser.FUNC, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitFunctionType(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_functionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			match(FUNC);
			setState(756);
			signature();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SignatureContext extends ParserRuleContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSignature(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			parameters();
			setState(760);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(759);
				result();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResultContext extends ParserRuleContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_result);
		try {
			setState(764);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(762);
				parameters();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(763);
				type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public List<ParameterDeclContext> parameterDecl() {
			return getRuleContexts(ParameterDeclContext.class);
		}
		public ParameterDeclContext parameterDecl(int i) {
			return getRuleContext(ParameterDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_parameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			match(L_PAREN);
			setState(778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 2882304311860134339L) != 0)) {
				{
				setState(767);
				parameterDecl();
				setState(772);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(768);
						match(COMMA);
						setState(769);
						parameterDecl();
						}
						} 
					}
					setState(774);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				}
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(775);
					match(COMMA);
					}
				}

				}
			}

			setState(780);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(GoParser.ELLIPSIS, 0); }
		public ParameterDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterParameterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitParameterDecl(this);
		}
	}

	public final ParameterDeclContext parameterDecl() throws RecognitionException {
		ParameterDeclContext _localctx = new ParameterDeclContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_parameterDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				{
				setState(782);
				identifierList();
				}
				break;
			}
			setState(786);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELLIPSIS) {
				{
				setState(785);
				match(ELLIPSIS);
				}
			}

			setState(788);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Token unary_op;
		public Token mul_op;
		public Token add_op;
		public Token rel_op;
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(GoParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GoParser.MINUS, 0); }
		public TerminalNode EXCLAMATION() { return getToken(GoParser.EXCLAMATION, 0); }
		public TerminalNode CARET() { return getToken(GoParser.CARET, 0); }
		public TerminalNode STAR() { return getToken(GoParser.STAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoParser.AMPERSAND, 0); }
		public TerminalNode RECEIVE() { return getToken(GoParser.RECEIVE, 0); }
		public TerminalNode DIV() { return getToken(GoParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GoParser.MOD, 0); }
		public TerminalNode LSHIFT() { return getToken(GoParser.LSHIFT, 0); }
		public TerminalNode RSHIFT() { return getToken(GoParser.RSHIFT, 0); }
		public TerminalNode BIT_CLEAR() { return getToken(GoParser.BIT_CLEAR, 0); }
		public TerminalNode OR() { return getToken(GoParser.OR, 0); }
		public TerminalNode EQUALS() { return getToken(GoParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(GoParser.NOT_EQUALS, 0); }
		public TerminalNode LESS() { return getToken(GoParser.LESS, 0); }
		public TerminalNode LESS_OR_EQUALS() { return getToken(GoParser.LESS_OR_EQUALS, 0); }
		public TerminalNode GREATER() { return getToken(GoParser.GREATER, 0); }
		public TerminalNode GREATER_OR_EQUALS() { return getToken(GoParser.GREATER_OR_EQUALS, 0); }
		public TerminalNode LOGICAL_AND() { return getToken(GoParser.LOGICAL_AND, 0); }
		public TerminalNode LOGICAL_OR() { return getToken(GoParser.LOGICAL_OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 152;
		enterRecursionRule(_localctx, 152, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(791);
				primaryExpr(0);
				}
				break;
			case 2:
				{
				setState(792);
				((ExpressionContext)_localctx).unary_op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & 127L) != 0)) ) {
					((ExpressionContext)_localctx).unary_op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(793);
				expression(6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(813);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(811);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(796);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(797);
						((ExpressionContext)_localctx).mul_op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -4472074429978902528L) != 0)) ) {
							((ExpressionContext)_localctx).mul_op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(798);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(799);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(800);
						((ExpressionContext)_localctx).add_op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4037477065937649664L) != 0)) ) {
							((ExpressionContext)_localctx).add_op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(801);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(802);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(803);
						((ExpressionContext)_localctx).rel_op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2216615441596416L) != 0)) ) {
							((ExpressionContext)_localctx).rel_op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(804);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(805);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(806);
						match(LOGICAL_AND);
						setState(807);
						expression(3);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(808);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(809);
						match(LOGICAL_OR);
						setState(810);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(815);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ConversionContext conversion() {
			return getRuleContext(ConversionContext.class,0);
		}
		public MethodExprContext methodExpr() {
			return getRuleContext(MethodExprContext.class,0);
		}
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(GoParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public Slice_Context slice_() {
			return getRuleContext(Slice_Context.class,0);
		}
		public TypeAssertionContext typeAssertion() {
			return getRuleContext(TypeAssertionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitPrimaryExpr(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		return primaryExpr(0);
	}

	private PrimaryExprContext primaryExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, _parentState);
		PrimaryExprContext _prevctx = _localctx;
		int _startState = 154;
		enterRecursionRule(_localctx, 154, RULE_primaryExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				{
				setState(817);
				operand();
				}
				break;
			case 2:
				{
				setState(818);
				conversion();
				}
				break;
			case 3:
				{
				setState(819);
				methodExpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(833);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimaryExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_primaryExpr);
					setState(822);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(829);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
					case 1:
						{
						setState(823);
						match(DOT);
						setState(824);
						match(IDENTIFIER);
						}
						break;
					case 2:
						{
						setState(825);
						index();
						}
						break;
					case 3:
						{
						setState(826);
						slice_();
						}
						break;
					case 4:
						{
						setState(827);
						typeAssertion();
						}
						break;
					case 5:
						{
						setState(828);
						arguments();
						}
						break;
					}
					}
					} 
				}
				setState(835);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConversionContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(GoParser.COMMA, 0); }
		public ConversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitConversion(this);
		}
	}

	public final ConversionContext conversion() throws RecognitionException {
		ConversionContext _localctx = new ConversionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_conversion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			type_();
			setState(837);
			match(L_PAREN);
			setState(838);
			expression(0);
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(839);
				match(COMMA);
				}
			}

			setState(842);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperandContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandNameContext operandName() {
			return getRuleContext(OperandNameContext.class,0);
		}
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_operand);
		try {
			setState(853);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(844);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(845);
				operandName();
				setState(847);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(846);
					typeArgs();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(849);
				match(L_PAREN);
				setState(850);
				expression(0);
				setState(851);
				match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public BasicLitContext basicLit() {
			return getRuleContext(BasicLitContext.class,0);
		}
		public CompositeLitContext compositeLit() {
			return getRuleContext(CompositeLitContext.class,0);
		}
		public FunctionLitContext functionLit() {
			return getRuleContext(FunctionLitContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_literal);
		try {
			setState(858);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NIL_LIT:
			case DECIMAL_LIT:
			case BINARY_LIT:
			case OCTAL_LIT:
			case HEX_LIT:
			case FLOAT_LIT:
			case IMAGINARY_LIT:
			case RUNE_LIT:
			case RAW_STRING_LIT:
			case INTERPRETED_STRING_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(855);
				basicLit();
				}
				break;
			case MAP:
			case STRUCT:
			case IDENTIFIER:
			case L_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(856);
				compositeLit();
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(857);
				functionLit();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BasicLitContext extends ParserRuleContext {
		public TerminalNode NIL_LIT() { return getToken(GoParser.NIL_LIT, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public String_Context string_() {
			return getRuleContext(String_Context.class,0);
		}
		public TerminalNode FLOAT_LIT() { return getToken(GoParser.FLOAT_LIT, 0); }
		public BasicLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterBasicLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitBasicLit(this);
		}
	}

	public final BasicLitContext basicLit() throws RecognitionException {
		BasicLitContext _localctx = new BasicLitContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_basicLit);
		try {
			setState(864);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NIL_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(860);
				match(NIL_LIT);
				}
				break;
			case DECIMAL_LIT:
			case BINARY_LIT:
			case OCTAL_LIT:
			case HEX_LIT:
			case IMAGINARY_LIT:
			case RUNE_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(861);
				integer();
				}
				break;
			case RAW_STRING_LIT:
			case INTERPRETED_STRING_LIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(862);
				string_();
				}
				break;
			case FLOAT_LIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(863);
				match(FLOAT_LIT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LIT() { return getToken(GoParser.DECIMAL_LIT, 0); }
		public TerminalNode BINARY_LIT() { return getToken(GoParser.BINARY_LIT, 0); }
		public TerminalNode OCTAL_LIT() { return getToken(GoParser.OCTAL_LIT, 0); }
		public TerminalNode HEX_LIT() { return getToken(GoParser.HEX_LIT, 0); }
		public TerminalNode IMAGINARY_LIT() { return getToken(GoParser.IMAGINARY_LIT, 0); }
		public TerminalNode RUNE_LIT() { return getToken(GoParser.RUNE_LIT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 399L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperandNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public OperandNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operandName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterOperandName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitOperandName(this);
		}
	}

	public final OperandNameContext operandName() throws RecognitionException {
		OperandNameContext _localctx = new OperandNameContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_operandName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868);
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

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedIdentContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GoParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GoParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(GoParser.DOT, 0); }
		public QualifiedIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterQualifiedIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitQualifiedIdent(this);
		}
	}

	public final QualifiedIdentContext qualifiedIdent() throws RecognitionException {
		QualifiedIdentContext _localctx = new QualifiedIdentContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_qualifiedIdent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			match(IDENTIFIER);
			setState(871);
			match(DOT);
			setState(872);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompositeLitContext extends ParserRuleContext {
		public LiteralTypeContext literalType() {
			return getRuleContext(LiteralTypeContext.class,0);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public CompositeLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterCompositeLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitCompositeLit(this);
		}
	}

	public final CompositeLitContext compositeLit() throws RecognitionException {
		CompositeLitContext _localctx = new CompositeLitContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_compositeLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			literalType();
			setState(875);
			literalValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralTypeContext extends ParserRuleContext {
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public TerminalNode ELLIPSIS() { return getToken(GoParser.ELLIPSIS, 0); }
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public ElementTypeContext elementType() {
			return getRuleContext(ElementTypeContext.class,0);
		}
		public SliceTypeContext sliceType() {
			return getRuleContext(SliceTypeContext.class,0);
		}
		public MapTypeContext mapType() {
			return getRuleContext(MapTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public LiteralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterLiteralType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitLiteralType(this);
		}
	}

	public final LiteralTypeContext literalType() throws RecognitionException {
		LiteralTypeContext _localctx = new LiteralTypeContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_literalType);
		int _la;
		try {
			setState(889);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(877);
				structType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(878);
				arrayType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(879);
				match(L_BRACKET);
				setState(880);
				match(ELLIPSIS);
				setState(881);
				match(R_BRACKET);
				setState(882);
				elementType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(883);
				sliceType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(884);
				mapType();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(885);
				typeName();
				setState(887);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==L_BRACKET) {
					{
					setState(886);
					typeArgs();
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralValueContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(GoParser.COMMA, 0); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitLiteralValue(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			match(L_CURLY);
			setState(896);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230370313236968L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
				{
				setState(892);
				elementList();
				setState(894);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(893);
					match(COMMA);
					}
				}

				}
			}

			setState(898);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementListContext extends ParserRuleContext {
		public List<KeyedElementContext> keyedElement() {
			return getRuleContexts(KeyedElementContext.class);
		}
		public KeyedElementContext keyedElement(int i) {
			return getRuleContext(KeyedElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitElementList(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_elementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			keyedElement();
			setState(905);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(901);
					match(COMMA);
					setState(902);
					keyedElement();
					}
					} 
				}
				setState(907);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeyedElementContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GoParser.COLON, 0); }
		public KeyedElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterKeyedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitKeyedElement(this);
		}
	}

	public final KeyedElementContext keyedElement() throws RecognitionException {
		KeyedElementContext _localctx = new KeyedElementContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_keyedElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(908);
				key();
				setState(909);
				match(COLON);
				}
				break;
			}
			setState(913);
			element();
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

	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_key);
		try {
			setState(917);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
			case INTERFACE:
			case MAP:
			case STRUCT:
			case CHAN:
			case NIL_LIT:
			case IDENTIFIER:
			case L_PAREN:
			case L_BRACKET:
			case EXCLAMATION:
			case PLUS:
			case MINUS:
			case CARET:
			case STAR:
			case AMPERSAND:
			case RECEIVE:
			case DECIMAL_LIT:
			case BINARY_LIT:
			case OCTAL_LIT:
			case HEX_LIT:
			case FLOAT_LIT:
			case IMAGINARY_LIT:
			case RUNE_LIT:
			case RAW_STRING_LIT:
			case INTERPRETED_STRING_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(915);
				expression(0);
				}
				break;
			case L_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(916);
				literalValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_element);
		try {
			setState(921);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
			case INTERFACE:
			case MAP:
			case STRUCT:
			case CHAN:
			case NIL_LIT:
			case IDENTIFIER:
			case L_PAREN:
			case L_BRACKET:
			case EXCLAMATION:
			case PLUS:
			case MINUS:
			case CARET:
			case STAR:
			case AMPERSAND:
			case RECEIVE:
			case DECIMAL_LIT:
			case BINARY_LIT:
			case OCTAL_LIT:
			case HEX_LIT:
			case FLOAT_LIT:
			case IMAGINARY_LIT:
			case RUNE_LIT:
			case RAW_STRING_LIT:
			case INTERPRETED_STRING_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(919);
				expression(0);
				}
				break;
			case L_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(920);
				literalValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructTypeContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(GoParser.STRUCT, 0); }
		public TerminalNode L_CURLY() { return getToken(GoParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(GoParser.R_CURLY, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterStructType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitStructType(this);
		}
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_structType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(923);
			match(STRUCT);
			setState(924);
			match(L_CURLY);
			setState(930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER || _la==STAR) {
				{
				{
				setState(925);
				fieldDecl();
				setState(926);
				eos();
				}
				}
				setState(932);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(933);
			match(R_CURLY);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public String_Context tag;
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public EmbeddedFieldContext embeddedField() {
			return getRuleContext(EmbeddedFieldContext.class,0);
		}
		public String_Context string_() {
			return getRuleContext(String_Context.class,0);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitFieldDecl(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(935);
				identifierList();
				setState(936);
				type_();
				}
				break;
			case 2:
				{
				setState(938);
				embeddedField();
				}
				break;
			}
			setState(942);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				{
				setState(941);
				((FieldDeclContext)_localctx).tag = string_();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class String_Context extends ParserRuleContext {
		public TerminalNode RAW_STRING_LIT() { return getToken(GoParser.RAW_STRING_LIT, 0); }
		public TerminalNode INTERPRETED_STRING_LIT() { return getToken(GoParser.INTERPRETED_STRING_LIT, 0); }
		public String_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterString_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitString_(this);
		}
	}

	public final String_Context string_() throws RecognitionException {
		String_Context _localctx = new String_Context(_ctx, getState());
		enterRule(_localctx, 188, RULE_string_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			_la = _input.LA(1);
			if ( !(_la==RAW_STRING_LIT || _la==INTERPRETED_STRING_LIT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmbeddedFieldContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode STAR() { return getToken(GoParser.STAR, 0); }
		public TypeArgsContext typeArgs() {
			return getRuleContext(TypeArgsContext.class,0);
		}
		public EmbeddedFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_embeddedField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterEmbeddedField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitEmbeddedField(this);
		}
	}

	public final EmbeddedFieldContext embeddedField() throws RecognitionException {
		EmbeddedFieldContext _localctx = new EmbeddedFieldContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_embeddedField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(946);
				match(STAR);
				}
			}

			setState(949);
			typeName();
			setState(951);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(950);
				typeArgs();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionLitContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(GoParser.FUNC, 0); }
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterFunctionLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitFunctionLit(this);
		}
	}

	public final FunctionLitContext functionLit() throws RecognitionException {
		FunctionLitContext _localctx = new FunctionLitContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_functionLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(953);
			match(FUNC);
			setState(954);
			signature();
			setState(955);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IndexContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitIndex(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			match(L_BRACKET);
			setState(958);
			expression(0);
			setState(959);
			match(R_BRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Slice_Context extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(GoParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(GoParser.R_BRACKET, 0); }
		public List<TerminalNode> COLON() { return getTokens(GoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(GoParser.COLON, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Slice_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterSlice_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitSlice_(this);
		}
	}

	public final Slice_Context slice_() throws RecognitionException {
		Slice_Context _localctx = new Slice_Context(_ctx, getState());
		enterRule(_localctx, 196, RULE_slice_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961);
			match(L_BRACKET);
			setState(977);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(963);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(962);
					expression(0);
					}
				}

				setState(965);
				match(COLON);
				setState(967);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(966);
					expression(0);
					}
				}

				}
				break;
			case 2:
				{
				setState(970);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
					{
					setState(969);
					expression(0);
					}
				}

				setState(972);
				match(COLON);
				setState(973);
				expression(0);
				setState(974);
				match(COLON);
				setState(975);
				expression(0);
				}
				break;
			}
			setState(979);
			match(R_BRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeAssertionContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(GoParser.DOT, 0); }
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public TypeAssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAssertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterTypeAssertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitTypeAssertion(this);
		}
	}

	public final TypeAssertionContext typeAssertion() throws RecognitionException {
		TypeAssertionContext _localctx = new TypeAssertionContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_typeAssertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(981);
			match(DOT);
			setState(982);
			match(L_PAREN);
			setState(983);
			type_();
			setState(984);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(GoParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(GoParser.R_PAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(GoParser.ELLIPSIS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GoParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(986);
			match(L_PAREN);
			setState(1001);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288230371386978792L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 99135L) != 0)) {
				{
				setState(993);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(987);
					expressionList();
					}
					break;
				case 2:
					{
					setState(988);
					type_();
					setState(991);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
					case 1:
						{
						setState(989);
						match(COMMA);
						setState(990);
						expressionList();
						}
						break;
					}
					}
					break;
				}
				setState(996);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELLIPSIS) {
					{
					setState(995);
					match(ELLIPSIS);
					}
				}

				setState(999);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(998);
					match(COMMA);
					}
				}

				}
			}

			setState(1003);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodExprContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode DOT() { return getToken(GoParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoParser.IDENTIFIER, 0); }
		public MethodExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterMethodExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitMethodExpr(this);
		}
	}

	public final MethodExprContext methodExpr() throws RecognitionException {
		MethodExprContext _localctx = new MethodExprContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_methodExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1005);
			type_();
			setState(1006);
			match(DOT);
			setState(1007);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EosContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(GoParser.SEMI, 0); }
		public TerminalNode EOF() { return getToken(GoParser.EOF, 0); }
		public TerminalNode EOS() { return getToken(GoParser.EOS, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).enterEos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GoParserListener ) ((GoParserListener)listener).exitEos(this);
		}
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_eos);
		try {
			setState(1013);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1009);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1010);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1011);
				match(EOS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1012);
				if (!(this.closingBracket())) throw new FailedPredicateException(this, "this.closingBracket()");
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return statementList_sempred((StatementListContext)_localctx, predIndex);
		case 76:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 77:
			return primaryExpr_sempred((PrimaryExprContext)_localctx, predIndex);
		case 102:
			return eos_sempred((EosContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statementList_sempred(StatementListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return this.closingBracket();
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primaryExpr_sempred(PrimaryExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eos_sempred(EosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return this.closingBracket();
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001Y\u03f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"+
		"d\u0007d\u0002e\u0007e\u0002f\u0007f\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\u00d2\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u00d7\b\u0000\n\u0000\f\u0000\u00da\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000\u00df\b\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u00e3"+
		"\b\u0000\n\u0000\f\u0000\u00e6\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u00f3\b\u0002\n\u0002\f\u0002\u00f6"+
		"\t\u0002\u0001\u0002\u0003\u0002\u00f9\b\u0002\u0001\u0003\u0003\u0003"+
		"\u00fc\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0105\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u010d\b\u0006"+
		"\n\u0006\f\u0006\u0110\t\u0006\u0001\u0006\u0003\u0006\u0113\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0117\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u011b\b\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u0120\b\b\n\b\f\b"+
		"\u0123\t\b\u0001\t\u0001\t\u0001\t\u0005\t\u0128\b\t\n\t\f\t\u012b\t\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0133\b\n\n\n"+
		"\f\n\u0136\t\n\u0001\n\u0003\n\u0139\b\n\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u013d\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003"+
		"\r\u0145\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u014d\b\u000e\n\u000e\f\u000e\u0150\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u015a\b\u0010\n\u0010\f\u0010\u015d\t\u0010\u0001"+
		"\u0011\u0003\u0011\u0160\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0167\b\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u016b\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0172\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u017c"+
		"\b\u0015\n\u0015\f\u0015\u017f\t\u0015\u0001\u0015\u0003\u0015\u0182\b"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0188"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u018c\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u0190\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0003\u0018\u0195\b\u0018\u0001\u0018\u0003\u0018\u0198\b\u0018\u0001"+
		"\u0018\u0003\u0018\u019b\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0004"+
		"\u0018\u01a0\b\u0018\u000b\u0018\f\u0018\u01a1\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u01b3\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u01ba\b\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0003\u001f\u01ca\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001!\u0001!\u0001!\u0003!\u01d5\b!\u0001\"\u0001\"\u0003\""+
		"\u01d9\b\"\u0001#\u0001#\u0003#\u01dd\b#\u0001$\u0001$\u0003$\u01e1\b"+
		"$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u01f4\b(\u0001"+
		"(\u0001(\u0001(\u0001(\u0003(\u01fa\b(\u0003(\u01fc\b(\u0001)\u0001)\u0003"+
		")\u0200\b)\u0001*\u0001*\u0003*\u0204\b*\u0001*\u0003*\u0207\b*\u0001"+
		"*\u0001*\u0003*\u020b\b*\u0003*\u020d\b*\u0001*\u0001*\u0005*\u0211\b"+
		"*\n*\f*\u0214\t*\u0001*\u0001*\u0001+\u0001+\u0001+\u0003+\u021b\b+\u0001"+
		",\u0001,\u0001,\u0003,\u0220\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0003-\u022b\b-\u0001-\u0001-\u0005-\u022f\b-\n"+
		"-\f-\u0232\t-\u0001-\u0001-\u0001.\u0001.\u0003.\u0238\b.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0003/\u0243\b/\u0001"+
		"0\u00010\u00010\u00030\u0248\b0\u00011\u00011\u00031\u024c\b1\u00011\u0001"+
		"1\u00011\u00031\u0251\b1\u00051\u0253\b1\n1\f1\u0256\t1\u00012\u00012"+
		"\u00012\u00052\u025b\b2\n2\f2\u025e\t2\u00012\u00012\u00013\u00013\u0001"+
		"3\u00033\u0265\b3\u00014\u00014\u00014\u00034\u026a\b4\u00014\u00034\u026d"+
		"\b4\u00015\u00015\u00015\u00015\u00015\u00015\u00035\u0275\b5\u00015\u0001"+
		"5\u00016\u00016\u00036\u027b\b6\u00016\u00016\u00036\u027f\b6\u00036\u0281"+
		"\b6\u00016\u00016\u00017\u00037\u0286\b7\u00017\u00017\u00037\u028a\b"+
		"7\u00017\u00017\u00037\u028e\b7\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00038\u0296\b8\u00018\u00018\u00018\u00019\u00019\u00019\u0001:\u0001"+
		":\u0003:\u02a0\b:\u0001:\u0001:\u0001:\u0001:\u0001:\u0003:\u02a7\b:\u0001"+
		";\u0001;\u0001;\u0003;\u02ac\b;\u0001;\u0001;\u0001<\u0001<\u0003<\u02b2"+
		"\b<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u02bc"+
		"\b=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001?\u0001?\u0001@\u0001@\u0001"+
		"A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0003B\u02ce\bB\u0001B\u0001"+
		"B\u0005B\u02d2\bB\nB\fB\u02d5\tB\u0001B\u0001B\u0001C\u0001C\u0001C\u0001"+
		"C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001"+
		"E\u0001E\u0003E\u02e8\bE\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0003F\u02f2\bF\u0001G\u0001G\u0001G\u0001H\u0001H\u0003H\u02f9"+
		"\bH\u0001I\u0001I\u0003I\u02fd\bI\u0001J\u0001J\u0001J\u0001J\u0005J\u0303"+
		"\bJ\nJ\fJ\u0306\tJ\u0001J\u0003J\u0309\bJ\u0003J\u030b\bJ\u0001J\u0001"+
		"J\u0001K\u0003K\u0310\bK\u0001K\u0003K\u0313\bK\u0001K\u0001K\u0001L\u0001"+
		"L\u0001L\u0001L\u0003L\u031b\bL\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0005"+
		"L\u032c\bL\nL\fL\u032f\tL\u0001M\u0001M\u0001M\u0001M\u0003M\u0335\bM"+
		"\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u033e\bM\u0005"+
		"M\u0340\bM\nM\fM\u0343\tM\u0001N\u0001N\u0001N\u0001N\u0003N\u0349\bN"+
		"\u0001N\u0001N\u0001O\u0001O\u0001O\u0003O\u0350\bO\u0001O\u0001O\u0001"+
		"O\u0001O\u0003O\u0356\bO\u0001P\u0001P\u0001P\u0003P\u035b\bP\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0003Q\u0361\bQ\u0001R\u0001R\u0001S\u0001S\u0001T\u0001"+
		"T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001V\u0001V\u0001V\u0001V\u0001"+
		"V\u0001V\u0001V\u0001V\u0001V\u0001V\u0003V\u0378\bV\u0003V\u037a\bV\u0001"+
		"W\u0001W\u0001W\u0003W\u037f\bW\u0003W\u0381\bW\u0001W\u0001W\u0001X\u0001"+
		"X\u0001X\u0005X\u0388\bX\nX\fX\u038b\tX\u0001Y\u0001Y\u0001Y\u0003Y\u0390"+
		"\bY\u0001Y\u0001Y\u0001Z\u0001Z\u0003Z\u0396\bZ\u0001[\u0001[\u0003[\u039a"+
		"\b[\u0001\\\u0001\\\u0001\\\u0001\\\u0001\\\u0005\\\u03a1\b\\\n\\\f\\"+
		"\u03a4\t\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0003]\u03ac\b"+
		"]\u0001]\u0003]\u03af\b]\u0001^\u0001^\u0001_\u0003_\u03b4\b_\u0001_\u0001"+
		"_\u0003_\u03b8\b_\u0001`\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0001"+
		"a\u0001b\u0001b\u0003b\u03c4\bb\u0001b\u0001b\u0003b\u03c8\bb\u0001b\u0003"+
		"b\u03cb\bb\u0001b\u0001b\u0001b\u0001b\u0001b\u0003b\u03d2\bb\u0001b\u0001"+
		"b\u0001c\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0001d\u0001"+
		"d\u0003d\u03e0\bd\u0003d\u03e2\bd\u0001d\u0003d\u03e5\bd\u0001d\u0003"+
		"d\u03e8\bd\u0003d\u03ea\bd\u0001d\u0001d\u0001e\u0001e\u0001e\u0001e\u0001"+
		"f\u0001f\u0001f\u0001f\u0003f\u03f6\bf\u0001f\u0000\u0002\u0098\u009a"+
		"g\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca"+
		"\u00cc\u0000\t\u0002\u0000\u001b\u001b&&\u0001\u0000\'(\u0002\u000038"+
		";?\u0001\u0000:@\u0002\u000048>?\u0002\u000033;=\u0001\u0000-2\u0002\u0000"+
		"ADHI\u0001\u0000OP\u043a\u0000\u00d1\u0001\u0000\u0000\u0000\u0002\u00e9"+
		"\u0001\u0000\u0000\u0000\u0004\u00ec\u0001\u0000\u0000\u0000\u0006\u00fb"+
		"\u0001\u0000\u0000\u0000\b\u00ff\u0001\u0000\u0000\u0000\n\u0104\u0001"+
		"\u0000\u0000\u0000\f\u0106\u0001\u0000\u0000\u0000\u000e\u0114\u0001\u0000"+
		"\u0000\u0000\u0010\u011c\u0001\u0000\u0000\u0000\u0012\u0124\u0001\u0000"+
		"\u0000\u0000\u0014\u012c\u0001\u0000\u0000\u0000\u0016\u013c\u0001\u0000"+
		"\u0000\u0000\u0018\u013e\u0001\u0000\u0000\u0000\u001a\u0142\u0001\u0000"+
		"\u0000\u0000\u001c\u0148\u0001\u0000\u0000\u0000\u001e\u0153\u0001\u0000"+
		"\u0000\u0000 \u0156\u0001\u0000\u0000\u0000\"\u015f\u0001\u0000\u0000"+
		"\u0000$\u0163\u0001\u0000\u0000\u0000&\u016c\u0001\u0000\u0000\u0000("+
		"\u0173\u0001\u0000\u0000\u0000*\u0175\u0001\u0000\u0000\u0000,\u0183\u0001"+
		"\u0000\u0000\u0000.\u018d\u0001\u0000\u0000\u00000\u019f\u0001\u0000\u0000"+
		"\u00002\u01b2\u0001\u0000\u0000\u00004\u01b9\u0001\u0000\u0000\u00006"+
		"\u01bb\u0001\u0000\u0000\u00008\u01bd\u0001\u0000\u0000\u0000:\u01c1\u0001"+
		"\u0000\u0000\u0000<\u01c4\u0001\u0000\u0000\u0000>\u01c9\u0001\u0000\u0000"+
		"\u0000@\u01cd\u0001\u0000\u0000\u0000B\u01d1\u0001\u0000\u0000\u0000D"+
		"\u01d6\u0001\u0000\u0000\u0000F\u01da\u0001\u0000\u0000\u0000H\u01de\u0001"+
		"\u0000\u0000\u0000J\u01e2\u0001\u0000\u0000\u0000L\u01e5\u0001\u0000\u0000"+
		"\u0000N\u01e7\u0001\u0000\u0000\u0000P\u01ea\u0001\u0000\u0000\u0000R"+
		"\u01ff\u0001\u0000\u0000\u0000T\u0201\u0001\u0000\u0000\u0000V\u0217\u0001"+
		"\u0000\u0000\u0000X\u021f\u0001\u0000\u0000\u0000Z\u0221\u0001\u0000\u0000"+
		"\u0000\\\u0237\u0001\u0000\u0000\u0000^\u023f\u0001\u0000\u0000\u0000"+
		"`\u0247\u0001\u0000\u0000\u0000b\u024b\u0001\u0000\u0000\u0000d\u0257"+
		"\u0001\u0000\u0000\u0000f\u0261\u0001\u0000\u0000\u0000h\u026c\u0001\u0000"+
		"\u0000\u0000j\u0274\u0001\u0000\u0000\u0000l\u0278\u0001\u0000\u0000\u0000"+
		"n\u0285\u0001\u0000\u0000\u0000p\u0295\u0001\u0000\u0000\u0000r\u029a"+
		"\u0001\u0000\u0000\u0000t\u02a6\u0001\u0000\u0000\u0000v\u02a8\u0001\u0000"+
		"\u0000\u0000x\u02b1\u0001\u0000\u0000\u0000z\u02bb\u0001\u0000\u0000\u0000"+
		"|\u02bd\u0001\u0000\u0000\u0000~\u02c2\u0001\u0000\u0000\u0000\u0080\u02c4"+
		"\u0001\u0000\u0000\u0000\u0082\u02c6\u0001\u0000\u0000\u0000\u0084\u02c9"+
		"\u0001\u0000\u0000\u0000\u0086\u02d8\u0001\u0000\u0000\u0000\u0088\u02dc"+
		"\u0001\u0000\u0000\u0000\u008a\u02e7\u0001\u0000\u0000\u0000\u008c\u02f1"+
		"\u0001\u0000\u0000\u0000\u008e\u02f3\u0001\u0000\u0000\u0000\u0090\u02f6"+
		"\u0001\u0000\u0000\u0000\u0092\u02fc\u0001\u0000\u0000\u0000\u0094\u02fe"+
		"\u0001\u0000\u0000\u0000\u0096\u030f\u0001\u0000\u0000\u0000\u0098\u031a"+
		"\u0001\u0000\u0000\u0000\u009a\u0334\u0001\u0000\u0000\u0000\u009c\u0344"+
		"\u0001\u0000\u0000\u0000\u009e\u0355\u0001\u0000\u0000\u0000\u00a0\u035a"+
		"\u0001\u0000\u0000\u0000\u00a2\u0360\u0001\u0000\u0000\u0000\u00a4\u0362"+
		"\u0001\u0000\u0000\u0000\u00a6\u0364\u0001\u0000\u0000\u0000\u00a8\u0366"+
		"\u0001\u0000\u0000\u0000\u00aa\u036a\u0001\u0000\u0000\u0000\u00ac\u0379"+
		"\u0001\u0000\u0000\u0000\u00ae\u037b\u0001\u0000\u0000\u0000\u00b0\u0384"+
		"\u0001\u0000\u0000\u0000\u00b2\u038f\u0001\u0000\u0000\u0000\u00b4\u0395"+
		"\u0001\u0000\u0000\u0000\u00b6\u0399\u0001\u0000\u0000\u0000\u00b8\u039b"+
		"\u0001\u0000\u0000\u0000\u00ba\u03ab\u0001\u0000\u0000\u0000\u00bc\u03b0"+
		"\u0001\u0000\u0000\u0000\u00be\u03b3\u0001\u0000\u0000\u0000\u00c0\u03b9"+
		"\u0001\u0000\u0000\u0000\u00c2\u03bd\u0001\u0000\u0000\u0000\u00c4\u03c1"+
		"\u0001\u0000\u0000\u0000\u00c6\u03d5\u0001\u0000\u0000\u0000\u00c8\u03da"+
		"\u0001\u0000\u0000\u0000\u00ca\u03ed\u0001\u0000\u0000\u0000\u00cc\u03f5"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003\u0002\u0001\u0000\u00cf\u00d0"+
		"\u0003\u00ccf\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0003\u0004\u0002\u0000\u00d4\u00d5\u0003"+
		"\u00ccf\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00e4\u0001\u0000"+
		"\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00df\u0003$\u0012"+
		"\u0000\u00dc\u00df\u0003&\u0013\u0000\u00dd\u00df\u0003\n\u0005\u0000"+
		"\u00de\u00db\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e1\u0003\u00ccf\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2"+
		"\u00de\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0005\u0000\u0000\u0001\u00e8\u0001\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0005\u000e\u0000\u0000\u00ea\u00eb\u0005\u001b\u0000\u0000\u00eb"+
		"\u0003\u0001\u0000\u0000\u0000\u00ec\u00f8\u0005\u0017\u0000\u0000\u00ed"+
		"\u00f9\u0003\u0006\u0003\u0000\u00ee\u00f4\u0005\u001c\u0000\u0000\u00ef"+
		"\u00f0\u0003\u0006\u0003\u0000\u00f0\u00f1\u0003\u00ccf\u0000\u00f1\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f2\u00ef\u0001\u0000\u0000\u0000\u00f3\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f9\u0005\u001d\u0000\u0000\u00f8\u00ed"+
		"\u0001\u0000\u0000\u0000\u00f8\u00ee\u0001\u0000\u0000\u0000\u00f9\u0005"+
		"\u0001\u0000\u0000\u0000\u00fa\u00fc\u0007\u0000\u0000\u0000\u00fb\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0003\b\u0004\u0000\u00fe\u0007\u0001"+
		"\u0000\u0000\u0000\u00ff\u0100\u0003\u00bc^\u0000\u0100\t\u0001\u0000"+
		"\u0000\u0000\u0101\u0105\u0003\f\u0006\u0000\u0102\u0105\u0003\u0014\n"+
		"\u0000\u0103\u0105\u0003*\u0015\u0000\u0104\u0101\u0001\u0000\u0000\u0000"+
		"\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000"+
		"\u0105\u000b\u0001\u0000\u0000\u0000\u0106\u0112\u0005\u0010\u0000\u0000"+
		"\u0107\u0113\u0003\u000e\u0007\u0000\u0108\u010e\u0005\u001c\u0000\u0000"+
		"\u0109\u010a\u0003\u000e\u0007\u0000\u010a\u010b\u0003\u00ccf\u0000\u010b"+
		"\u010d\u0001\u0000\u0000\u0000\u010c\u0109\u0001\u0000\u0000\u0000\u010d"+
		"\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0001\u0000\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110"+
		"\u010e\u0001\u0000\u0000\u0000\u0111\u0113\u0005\u001d\u0000\u0000\u0112"+
		"\u0107\u0001\u0000\u0000\u0000\u0112\u0108\u0001\u0000\u0000\u0000\u0113"+
		"\r\u0001\u0000\u0000\u0000\u0114\u011a\u0003\u0010\b\u0000\u0115\u0117"+
		"\u0003t:\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0005\"\u0000"+
		"\u0000\u0119\u011b\u0003\u0012\t\u0000\u011a\u0116\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u000f\u0001\u0000\u0000\u0000"+
		"\u011c\u0121\u0005\u001b\u0000\u0000\u011d\u011e\u0005#\u0000\u0000\u011e"+
		"\u0120\u0005\u001b\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120"+
		"\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121"+
		"\u0122\u0001\u0000\u0000\u0000\u0122\u0011\u0001\u0000\u0000\u0000\u0123"+
		"\u0121\u0001\u0000\u0000\u0000\u0124\u0129\u0003\u0098L\u0000\u0125\u0126"+
		"\u0005#\u0000\u0000\u0126\u0128\u0003\u0098L\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0128\u012b\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000"+
		"\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u0013\u0001\u0000"+
		"\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u0138\u0005\u0014"+
		"\u0000\u0000\u012d\u0139\u0003\u0016\u000b\u0000\u012e\u0134\u0005\u001c"+
		"\u0000\u0000\u012f\u0130\u0003\u0016\u000b\u0000\u0130\u0131\u0003\u00cc"+
		"f\u0000\u0131\u0133\u0001\u0000\u0000\u0000\u0132\u012f\u0001\u0000\u0000"+
		"\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000"+
		"\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0137\u0001\u0000\u0000"+
		"\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u0139\u0005\u001d\u0000"+
		"\u0000\u0138\u012d\u0001\u0000\u0000\u0000\u0138\u012e\u0001\u0000\u0000"+
		"\u0000\u0139\u0015\u0001\u0000\u0000\u0000\u013a\u013d\u0003\u0018\f\u0000"+
		"\u013b\u013d\u0003\u001a\r\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c"+
		"\u013b\u0001\u0000\u0000\u0000\u013d\u0017\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0005\u001b\u0000\u0000\u013f\u0140\u0005\"\u0000\u0000\u0140\u0141"+
		"\u0003t:\u0000\u0141\u0019\u0001\u0000\u0000\u0000\u0142\u0144\u0005\u001b"+
		"\u0000\u0000\u0143\u0145\u0003\u001c\u000e\u0000\u0144\u0143\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0003t:\u0000\u0147\u001b\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0005 \u0000\u0000\u0149\u014e\u0003\u001e\u000f\u0000\u014a"+
		"\u014b\u0005#\u0000\u0000\u014b\u014d\u0003\u001e\u000f\u0000\u014c\u014a"+
		"\u0001\u0000\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c"+
		"\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0151"+
		"\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0152"+
		"\u0005!\u0000\u0000\u0152\u001d\u0001\u0000\u0000\u0000\u0153\u0154\u0003"+
		"\u0010\b\u0000\u0154\u0155\u0003 \u0010\u0000\u0155\u001f\u0001\u0000"+
		"\u0000\u0000\u0156\u015b\u0003\"\u0011\u0000\u0157\u0158\u00053\u0000"+
		"\u0000\u0158\u015a\u0003\"\u0011\u0000\u0159\u0157\u0001\u0000\u0000\u0000"+
		"\u015a\u015d\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0001\u0000\u0000\u0000\u015c!\u0001\u0000\u0000\u0000\u015d"+
		"\u015b\u0001\u0000\u0000\u0000\u015e\u0160\u00059\u0000\u0000\u015f\u015e"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0161"+
		"\u0001\u0000\u0000\u0000\u0161\u0162\u0003t:\u0000\u0162#\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0005\u0003\u0000\u0000\u0164\u0166\u0005\u001b"+
		"\u0000\u0000\u0165\u0167\u0003\u001c\u000e\u0000\u0166\u0165\u0001\u0000"+
		"\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000"+
		"\u0000\u0000\u0168\u016a\u0003\u0090H\u0000\u0169\u016b\u0003.\u0017\u0000"+
		"\u016a\u0169\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000"+
		"\u016b%\u0001\u0000\u0000\u0000\u016c\u016d\u0005\u0003\u0000\u0000\u016d"+
		"\u016e\u0003(\u0014\u0000\u016e\u016f\u0005\u001b\u0000\u0000\u016f\u0171"+
		"\u0003\u0090H\u0000\u0170\u0172\u0003.\u0017\u0000\u0171\u0170\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\'\u0001\u0000\u0000"+
		"\u0000\u0173\u0174\u0003\u0094J\u0000\u0174)\u0001\u0000\u0000\u0000\u0175"+
		"\u0181\u0005\u0019\u0000\u0000\u0176\u0182\u0003,\u0016\u0000\u0177\u017d"+
		"\u0005\u001c\u0000\u0000\u0178\u0179\u0003,\u0016\u0000\u0179\u017a\u0003"+
		"\u00ccf\u0000\u017a\u017c\u0001\u0000\u0000\u0000\u017b\u0178\u0001\u0000"+
		"\u0000\u0000\u017c\u017f\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u0180\u0001\u0000"+
		"\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u0180\u0182\u0005\u001d"+
		"\u0000\u0000\u0181\u0176\u0001\u0000\u0000\u0000\u0181\u0177\u0001\u0000"+
		"\u0000\u0000\u0182+\u0001\u0000\u0000\u0000\u0183\u018b\u0003\u0010\b"+
		"\u0000\u0184\u0187\u0003t:\u0000\u0185\u0186\u0005\"\u0000\u0000\u0186"+
		"\u0188\u0003\u0012\t\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0187\u0188"+
		"\u0001\u0000\u0000\u0000\u0188\u018c\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0005\"\u0000\u0000\u018a\u018c\u0003\u0012\t\u0000\u018b\u0184\u0001"+
		"\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018c-\u0001\u0000"+
		"\u0000\u0000\u018d\u018f\u0005\u001e\u0000\u0000\u018e\u0190\u00030\u0018"+
		"\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000"+
		"\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0192\u0005\u001f\u0000"+
		"\u0000\u0192/\u0001\u0000\u0000\u0000\u0193\u0195\u0005$\u0000\u0000\u0194"+
		"\u0193\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195"+
		"\u019b\u0001\u0000\u0000\u0000\u0196\u0198\u0005X\u0000\u0000\u0197\u0196"+
		"\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198\u019b"+
		"\u0001\u0000\u0000\u0000\u0199\u019b\u0004\u0018\u0000\u0000\u019a\u0194"+
		"\u0001\u0000\u0000\u0000\u019a\u0197\u0001\u0000\u0000\u0000\u019a\u0199"+
		"\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019d"+
		"\u00032\u0019\u0000\u019d\u019e\u0003\u00ccf\u0000\u019e\u01a0\u0001\u0000"+
		"\u0000\u0000\u019f\u019a\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000"+
		"\u0000\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a21\u0001\u0000\u0000\u0000\u01a3\u01b3\u0003\n\u0005"+
		"\u0000\u01a4\u01b3\u0003B!\u0000\u01a5\u01b3\u00034\u001a\u0000\u01a6"+
		"\u01b3\u0003r9\u0000\u01a7\u01b3\u0003D\"\u0000\u01a8\u01b3\u0003F#\u0000"+
		"\u01a9\u01b3\u0003H$\u0000\u01aa\u01b3\u0003J%\u0000\u01ab\u01b3\u0003"+
		"L&\u0000\u01ac\u01b3\u0003.\u0017\u0000\u01ad\u01b3\u0003P(\u0000\u01ae"+
		"\u01b3\u0003R)\u0000\u01af\u01b3\u0003d2\u0000\u01b0\u01b3\u0003l6\u0000"+
		"\u01b1\u01b3\u0003N\'\u0000\u01b2\u01a3\u0001\u0000\u0000\u0000\u01b2"+
		"\u01a4\u0001\u0000\u0000\u0000\u01b2\u01a5\u0001\u0000\u0000\u0000\u01b2"+
		"\u01a6\u0001\u0000\u0000\u0000\u01b2\u01a7\u0001\u0000\u0000\u0000\u01b2"+
		"\u01a8\u0001\u0000\u0000\u0000\u01b2\u01a9\u0001\u0000\u0000\u0000\u01b2"+
		"\u01aa\u0001\u0000\u0000\u0000\u01b2\u01ab\u0001\u0000\u0000\u0000\u01b2"+
		"\u01ac\u0001\u0000\u0000\u0000\u01b2\u01ad\u0001\u0000\u0000\u0000\u01b2"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b2\u01af\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000\u0000\u01b3"+
		"3\u0001\u0000\u0000\u0000\u01b4\u01ba\u00038\u001c\u0000\u01b5\u01ba\u0003"+
		":\u001d\u0000\u01b6\u01ba\u0003<\u001e\u0000\u01b7\u01ba\u00036\u001b"+
		"\u0000\u01b8\u01ba\u0003@ \u0000\u01b9\u01b4\u0001\u0000\u0000\u0000\u01b9"+
		"\u01b5\u0001\u0000\u0000\u0000\u01b9\u01b6\u0001\u0000\u0000\u0000\u01b9"+
		"\u01b7\u0001\u0000\u0000\u0000\u01b9\u01b8\u0001\u0000\u0000\u0000\u01ba"+
		"5\u0001\u0000\u0000\u0000\u01bb\u01bc\u0003\u0098L\u0000\u01bc7\u0001"+
		"\u0000\u0000\u0000\u01bd\u01be\u0003\u0098L\u0000\u01be\u01bf\u0005@\u0000"+
		"\u0000\u01bf\u01c0\u0003\u0098L\u0000\u01c09\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c2\u0003\u0098L\u0000\u01c2\u01c3\u0007\u0001\u0000\u0000\u01c3;\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c5\u0003\u0012\t\u0000\u01c5\u01c6\u0003>"+
		"\u001f\u0000\u01c6\u01c7\u0003\u0012\t\u0000\u01c7=\u0001\u0000\u0000"+
		"\u0000\u01c8\u01ca\u0007\u0002\u0000\u0000\u01c9\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000"+
		"\u0000\u01cb\u01cc\u0005\"\u0000\u0000\u01cc?\u0001\u0000\u0000\u0000"+
		"\u01cd\u01ce\u0003\u0010\b\u0000\u01ce\u01cf\u0005)\u0000\u0000\u01cf"+
		"\u01d0\u0003\u0012\t\u0000\u01d0A\u0001\u0000\u0000\u0000\u01d1\u01d2"+
		"\u0005\u001b\u0000\u0000\u01d2\u01d4\u0005%\u0000\u0000\u01d3\u01d5\u0003"+
		"2\u0019\u0000\u01d4\u01d3\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d5C\u0001\u0000\u0000\u0000\u01d6\u01d8\u0005\u0018\u0000"+
		"\u0000\u01d7\u01d9\u0003\u0012\t\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9E\u0001\u0000\u0000\u0000\u01da"+
		"\u01dc\u0005\u0001\u0000\u0000\u01db\u01dd\u0005\u001b\u0000\u0000\u01dc"+
		"\u01db\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000\u01dd"+
		"G\u0001\u0000\u0000\u0000\u01de\u01e0\u0005\u0015\u0000\u0000\u01df\u01e1"+
		"\u0005\u001b\u0000\u0000\u01e0\u01df\u0001\u0000\u0000\u0000\u01e0\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e1I\u0001\u0000\u0000\u0000\u01e2\u01e3\u0005"+
		"\r\u0000\u0000\u01e3\u01e4\u0005\u001b\u0000\u0000\u01e4K\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e6\u0005\u0011\u0000\u0000\u01e6M\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e8\u0005\u0007\u0000\u0000\u01e8\u01e9\u0003\u0098L\u0000"+
		"\u01e9O\u0001\u0000\u0000\u0000\u01ea\u01f3\u0005\u0012\u0000\u0000\u01eb"+
		"\u01f4\u0003\u0098L\u0000\u01ec\u01ed\u0003\u00ccf\u0000\u01ed\u01ee\u0003"+
		"\u0098L\u0000\u01ee\u01f4\u0001\u0000\u0000\u0000\u01ef\u01f0\u00034\u001a"+
		"\u0000\u01f0\u01f1\u0003\u00ccf\u0000\u01f1\u01f2\u0003\u0098L\u0000\u01f2"+
		"\u01f4\u0001\u0000\u0000\u0000\u01f3\u01eb\u0001\u0000\u0000\u0000\u01f3"+
		"\u01ec\u0001\u0000\u0000\u0000\u01f3\u01ef\u0001\u0000\u0000\u0000\u01f4"+
		"\u01f5\u0001\u0000\u0000\u0000\u01f5\u01fb\u0003.\u0017\u0000\u01f6\u01f9"+
		"\u0005\f\u0000\u0000\u01f7\u01fa\u0003P(\u0000\u01f8\u01fa\u0003.\u0017"+
		"\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01f9\u01f8\u0001\u0000\u0000"+
		"\u0000\u01fa\u01fc\u0001\u0000\u0000\u0000\u01fb\u01f6\u0001\u0000\u0000"+
		"\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fcQ\u0001\u0000\u0000\u0000"+
		"\u01fd\u0200\u0003T*\u0000\u01fe\u0200\u0003Z-\u0000\u01ff\u01fd\u0001"+
		"\u0000\u0000\u0000\u01ff\u01fe\u0001\u0000\u0000\u0000\u0200S\u0001\u0000"+
		"\u0000\u0000\u0201\u020c\u0005\u000f\u0000\u0000\u0202\u0204\u0003\u0098"+
		"L\u0000\u0203\u0202\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000"+
		"\u0000\u0204\u020d\u0001\u0000\u0000\u0000\u0205\u0207\u00034\u001a\u0000"+
		"\u0206\u0205\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000"+
		"\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u020a\u0003\u00ccf\u0000\u0209"+
		"\u020b\u0003\u0098L\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020a\u020b"+
		"\u0001\u0000\u0000\u0000\u020b\u020d\u0001\u0000\u0000\u0000\u020c\u0203"+
		"\u0001\u0000\u0000\u0000\u020c\u0206\u0001\u0000\u0000\u0000\u020d\u020e"+
		"\u0001\u0000\u0000\u0000\u020e\u0212\u0005\u001e\u0000\u0000\u020f\u0211"+
		"\u0003V+\u0000\u0210\u020f\u0001\u0000\u0000\u0000\u0211\u0214\u0001\u0000"+
		"\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000"+
		"\u0000\u0000\u0213\u0215\u0001\u0000\u0000\u0000\u0214\u0212\u0001\u0000"+
		"\u0000\u0000\u0215\u0216\u0005\u001f\u0000\u0000\u0216U\u0001\u0000\u0000"+
		"\u0000\u0217\u0218\u0003X,\u0000\u0218\u021a\u0005%\u0000\u0000\u0219"+
		"\u021b\u00030\u0018\u0000\u021a\u0219\u0001\u0000\u0000\u0000\u021a\u021b"+
		"\u0001\u0000\u0000\u0000\u021bW\u0001\u0000\u0000\u0000\u021c\u021d\u0005"+
		"\u0006\u0000\u0000\u021d\u0220\u0003\u0012\t\u0000\u021e\u0220\u0005\u0002"+
		"\u0000\u0000\u021f\u021c\u0001\u0000\u0000\u0000\u021f\u021e\u0001\u0000"+
		"\u0000\u0000\u0220Y\u0001\u0000\u0000\u0000\u0221\u022a\u0005\u000f\u0000"+
		"\u0000\u0222\u022b\u0003\\.\u0000\u0223\u0224\u0003\u00ccf\u0000\u0224"+
		"\u0225\u0003\\.\u0000\u0225\u022b\u0001\u0000\u0000\u0000\u0226\u0227"+
		"\u00034\u001a\u0000\u0227\u0228\u0003\u00ccf\u0000\u0228\u0229\u0003\\"+
		".\u0000\u0229\u022b\u0001\u0000\u0000\u0000\u022a\u0222\u0001\u0000\u0000"+
		"\u0000\u022a\u0223\u0001\u0000\u0000\u0000\u022a\u0226\u0001\u0000\u0000"+
		"\u0000\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u0230\u0005\u001e\u0000"+
		"\u0000\u022d\u022f\u0003^/\u0000\u022e\u022d\u0001\u0000\u0000\u0000\u022f"+
		"\u0232\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000\u0230"+
		"\u0231\u0001\u0000\u0000\u0000\u0231\u0233\u0001\u0000\u0000\u0000\u0232"+
		"\u0230\u0001\u0000\u0000\u0000\u0233\u0234\u0005\u001f\u0000\u0000\u0234"+
		"[\u0001\u0000\u0000\u0000\u0235\u0236\u0005\u001b\u0000\u0000\u0236\u0238"+
		"\u0005)\u0000\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0237\u0238\u0001"+
		"\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239\u023a\u0003"+
		"\u009aM\u0000\u023a\u023b\u0005&\u0000\u0000\u023b\u023c\u0005\u001c\u0000"+
		"\u0000\u023c\u023d\u0005\u0014\u0000\u0000\u023d\u023e\u0005\u001d\u0000"+
		"\u0000\u023e]\u0001\u0000\u0000\u0000\u023f\u0240\u0003`0\u0000\u0240"+
		"\u0242\u0005%\u0000\u0000\u0241\u0243\u00030\u0018\u0000\u0242\u0241\u0001"+
		"\u0000\u0000\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243_\u0001\u0000"+
		"\u0000\u0000\u0244\u0245\u0005\u0006\u0000\u0000\u0245\u0248\u0003b1\u0000"+
		"\u0246\u0248\u0005\u0002\u0000\u0000\u0247\u0244\u0001\u0000\u0000\u0000"+
		"\u0247\u0246\u0001\u0000\u0000\u0000\u0248a\u0001\u0000\u0000\u0000\u0249"+
		"\u024c\u0003t:\u0000\u024a\u024c\u0005\u001a\u0000\u0000\u024b\u0249\u0001"+
		"\u0000\u0000\u0000\u024b\u024a\u0001\u0000\u0000\u0000\u024c\u0254\u0001"+
		"\u0000\u0000\u0000\u024d\u0250\u0005#\u0000\u0000\u024e\u0251\u0003t:"+
		"\u0000\u024f\u0251\u0005\u001a\u0000\u0000\u0250\u024e\u0001\u0000\u0000"+
		"\u0000\u0250\u024f\u0001\u0000\u0000\u0000\u0251\u0253\u0001\u0000\u0000"+
		"\u0000\u0252\u024d\u0001\u0000\u0000\u0000\u0253\u0256\u0001\u0000\u0000"+
		"\u0000\u0254\u0252\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000"+
		"\u0000\u0255c\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000\u0000"+
		"\u0257\u0258\u0005\u0005\u0000\u0000\u0258\u025c\u0005\u001e\u0000\u0000"+
		"\u0259\u025b\u0003f3\u0000\u025a\u0259\u0001\u0000\u0000\u0000\u025b\u025e"+
		"\u0001\u0000\u0000\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025c\u025d"+
		"\u0001\u0000\u0000\u0000\u025d\u025f\u0001\u0000\u0000\u0000\u025e\u025c"+
		"\u0001\u0000\u0000\u0000\u025f\u0260\u0005\u001f\u0000\u0000\u0260e\u0001"+
		"\u0000\u0000\u0000\u0261\u0262\u0003h4\u0000\u0262\u0264\u0005%\u0000"+
		"\u0000\u0263\u0265\u00030\u0018\u0000\u0264\u0263\u0001\u0000\u0000\u0000"+
		"\u0264\u0265\u0001\u0000\u0000\u0000\u0265g\u0001\u0000\u0000\u0000\u0266"+
		"\u0269\u0005\u0006\u0000\u0000\u0267\u026a\u00038\u001c\u0000\u0268\u026a"+
		"\u0003j5\u0000\u0269\u0267\u0001\u0000\u0000\u0000\u0269\u0268\u0001\u0000"+
		"\u0000\u0000\u026a\u026d\u0001\u0000\u0000\u0000\u026b\u026d\u0005\u0002"+
		"\u0000\u0000\u026c\u0266\u0001\u0000\u0000\u0000\u026c\u026b\u0001\u0000"+
		"\u0000\u0000\u026di\u0001\u0000\u0000\u0000\u026e\u026f\u0003\u0012\t"+
		"\u0000\u026f\u0270\u0005\"\u0000\u0000\u0270\u0275\u0001\u0000\u0000\u0000"+
		"\u0271\u0272\u0003\u0010\b\u0000\u0272\u0273\u0005)\u0000\u0000\u0273"+
		"\u0275\u0001\u0000\u0000\u0000\u0274\u026e\u0001\u0000\u0000\u0000\u0274"+
		"\u0271\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000\u0000\u0275"+
		"\u0276\u0001\u0000\u0000\u0000\u0276\u0277\u0003\u0098L\u0000\u0277k\u0001"+
		"\u0000\u0000\u0000\u0278\u0280\u0005\u0016\u0000\u0000\u0279\u027b\u0003"+
		"\u0098L\u0000\u027a\u0279\u0001\u0000\u0000\u0000\u027a\u027b\u0001\u0000"+
		"\u0000\u0000\u027b\u0281\u0001\u0000\u0000\u0000\u027c\u0281\u0003n7\u0000"+
		"\u027d\u027f\u0003p8\u0000\u027e\u027d\u0001\u0000\u0000\u0000\u027e\u027f"+
		"\u0001\u0000\u0000\u0000\u027f\u0281\u0001\u0000\u0000\u0000\u0280\u027a"+
		"\u0001\u0000\u0000\u0000\u0280\u027c\u0001\u0000\u0000\u0000\u0280\u027e"+
		"\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282\u0283"+
		"\u0003.\u0017\u0000\u0283m\u0001\u0000\u0000\u0000\u0284\u0286\u00034"+
		"\u001a\u0000\u0285\u0284\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000"+
		"\u0000\u0000\u0286\u0287\u0001\u0000\u0000\u0000\u0287\u0289\u0003\u00cc"+
		"f\u0000\u0288\u028a\u0003\u0098L\u0000\u0289\u0288\u0001\u0000\u0000\u0000"+
		"\u0289\u028a\u0001\u0000\u0000\u0000\u028a\u028b\u0001\u0000\u0000\u0000"+
		"\u028b\u028d\u0003\u00ccf\u0000\u028c\u028e\u00034\u001a\u0000\u028d\u028c"+
		"\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028eo\u0001"+
		"\u0000\u0000\u0000\u028f\u0290\u0003\u0012\t\u0000\u0290\u0291\u0005\""+
		"\u0000\u0000\u0291\u0296\u0001\u0000\u0000\u0000\u0292\u0293\u0003\u0010"+
		"\b\u0000\u0293\u0294\u0005)\u0000\u0000\u0294\u0296\u0001\u0000\u0000"+
		"\u0000\u0295\u028f\u0001\u0000\u0000\u0000\u0295\u0292\u0001\u0000\u0000"+
		"\u0000\u0295\u0296\u0001\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000"+
		"\u0000\u0297\u0298\u0005\u0013\u0000\u0000\u0298\u0299\u0003\u0098L\u0000"+
		"\u0299q\u0001\u0000\u0000\u0000\u029a\u029b\u0005\b\u0000\u0000\u029b"+
		"\u029c\u0003\u0098L\u0000\u029cs\u0001\u0000\u0000\u0000\u029d\u029f\u0003"+
		"x<\u0000\u029e\u02a0\u0003v;\u0000\u029f\u029e\u0001\u0000\u0000\u0000"+
		"\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a7\u0001\u0000\u0000\u0000"+
		"\u02a1\u02a7\u0003z=\u0000\u02a2\u02a3\u0005\u001c\u0000\u0000\u02a3\u02a4"+
		"\u0003t:\u0000\u02a4\u02a5\u0005\u001d\u0000\u0000\u02a5\u02a7\u0001\u0000"+
		"\u0000\u0000\u02a6\u029d\u0001\u0000\u0000\u0000\u02a6\u02a1\u0001\u0000"+
		"\u0000\u0000\u02a6\u02a2\u0001\u0000\u0000\u0000\u02a7u\u0001\u0000\u0000"+
		"\u0000\u02a8\u02a9\u0005 \u0000\u0000\u02a9\u02ab\u0003b1\u0000\u02aa"+
		"\u02ac\u0005#\u0000\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000\u02ab\u02ac"+
		"\u0001\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000\u0000\u02ad\u02ae"+
		"\u0005!\u0000\u0000\u02aew\u0001\u0000\u0000\u0000\u02af\u02b2\u0003\u00a8"+
		"T\u0000\u02b0\u02b2\u0005\u001b\u0000\u0000\u02b1\u02af\u0001\u0000\u0000"+
		"\u0000\u02b1\u02b0\u0001\u0000\u0000\u0000\u02b2y\u0001\u0000\u0000\u0000"+
		"\u02b3\u02bc\u0003|>\u0000\u02b4\u02bc\u0003\u00b8\\\u0000\u02b5\u02bc"+
		"\u0003\u0082A\u0000\u02b6\u02bc\u0003\u008eG\u0000\u02b7\u02bc\u0003\u0084"+
		"B\u0000\u02b8\u02bc\u0003\u0086C\u0000\u02b9\u02bc\u0003\u0088D\u0000"+
		"\u02ba\u02bc\u0003\u008aE\u0000\u02bb\u02b3\u0001\u0000\u0000\u0000\u02bb"+
		"\u02b4\u0001\u0000\u0000\u0000\u02bb\u02b5\u0001\u0000\u0000\u0000\u02bb"+
		"\u02b6\u0001\u0000\u0000\u0000\u02bb\u02b7\u0001\u0000\u0000\u0000\u02bb"+
		"\u02b8\u0001\u0000\u0000\u0000\u02bb\u02b9\u0001\u0000\u0000\u0000\u02bb"+
		"\u02ba\u0001\u0000\u0000\u0000\u02bc{\u0001\u0000\u0000\u0000\u02bd\u02be"+
		"\u0005 \u0000\u0000\u02be\u02bf\u0003~?\u0000\u02bf\u02c0\u0005!\u0000"+
		"\u0000\u02c0\u02c1\u0003\u0080@\u0000\u02c1}\u0001\u0000\u0000\u0000\u02c2"+
		"\u02c3\u0003\u0098L\u0000\u02c3\u007f\u0001\u0000\u0000\u0000\u02c4\u02c5"+
		"\u0003t:\u0000\u02c5\u0081\u0001\u0000\u0000\u0000\u02c6\u02c7\u0005>"+
		"\u0000\u0000\u02c7\u02c8\u0003t:\u0000\u02c8\u0083\u0001\u0000\u0000\u0000"+
		"\u02c9\u02ca\u0005\u0004\u0000\u0000\u02ca\u02d3\u0005\u001e\u0000\u0000"+
		"\u02cb\u02ce\u0003\u008cF\u0000\u02cc\u02ce\u0003 \u0010\u0000\u02cd\u02cb"+
		"\u0001\u0000\u0000\u0000\u02cd\u02cc\u0001\u0000\u0000\u0000\u02ce\u02cf"+
		"\u0001\u0000\u0000\u0000\u02cf\u02d0\u0003\u00ccf\u0000\u02d0\u02d2\u0001"+
		"\u0000\u0000\u0000\u02d1\u02cd\u0001\u0000\u0000\u0000\u02d2\u02d5\u0001"+
		"\u0000\u0000\u0000\u02d3\u02d1\u0001\u0000\u0000\u0000\u02d3\u02d4\u0001"+
		"\u0000\u0000\u0000\u02d4\u02d6\u0001\u0000\u0000\u0000\u02d5\u02d3\u0001"+
		"\u0000\u0000\u0000\u02d6\u02d7\u0005\u001f\u0000\u0000\u02d7\u0085\u0001"+
		"\u0000\u0000\u0000\u02d8\u02d9\u0005 \u0000\u0000\u02d9\u02da\u0005!\u0000"+
		"\u0000\u02da\u02db\u0003\u0080@\u0000\u02db\u0087\u0001\u0000\u0000\u0000"+
		"\u02dc\u02dd\u0005\t\u0000\u0000\u02dd\u02de\u0005 \u0000\u0000\u02de"+
		"\u02df\u0003t:\u0000\u02df\u02e0\u0005!\u0000\u0000\u02e0\u02e1\u0003"+
		"\u0080@\u0000\u02e1\u0089\u0001\u0000\u0000\u0000\u02e2\u02e8\u0005\u000b"+
		"\u0000\u0000\u02e3\u02e4\u0005\u000b\u0000\u0000\u02e4\u02e8\u0005@\u0000"+
		"\u0000\u02e5\u02e6\u0005@\u0000\u0000\u02e6\u02e8\u0005\u000b\u0000\u0000"+
		"\u02e7\u02e2\u0001\u0000\u0000\u0000\u02e7\u02e3\u0001\u0000\u0000\u0000"+
		"\u02e7\u02e5\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000"+
		"\u02e9\u02ea\u0003\u0080@\u0000\u02ea\u008b\u0001\u0000\u0000\u0000\u02eb"+
		"\u02ec\u0005\u001b\u0000\u0000\u02ec\u02ed\u0003\u0094J\u0000\u02ed\u02ee"+
		"\u0003\u0092I\u0000\u02ee\u02f2\u0001\u0000\u0000\u0000\u02ef\u02f0\u0005"+
		"\u001b\u0000\u0000\u02f0\u02f2\u0003\u0094J\u0000\u02f1\u02eb\u0001\u0000"+
		"\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f2\u008d\u0001\u0000"+
		"\u0000\u0000\u02f3\u02f4\u0005\u0003\u0000\u0000\u02f4\u02f5\u0003\u0090"+
		"H\u0000\u02f5\u008f\u0001\u0000\u0000\u0000\u02f6\u02f8\u0003\u0094J\u0000"+
		"\u02f7\u02f9\u0003\u0092I\u0000\u02f8\u02f7\u0001\u0000\u0000\u0000\u02f8"+
		"\u02f9\u0001\u0000\u0000\u0000\u02f9\u0091\u0001\u0000\u0000\u0000\u02fa"+
		"\u02fd\u0003\u0094J\u0000\u02fb\u02fd\u0003t:\u0000\u02fc\u02fa\u0001"+
		"\u0000\u0000\u0000\u02fc\u02fb\u0001\u0000\u0000\u0000\u02fd\u0093\u0001"+
		"\u0000\u0000\u0000\u02fe\u030a\u0005\u001c\u0000\u0000\u02ff\u0304\u0003"+
		"\u0096K\u0000\u0300\u0301\u0005#\u0000\u0000\u0301\u0303\u0003\u0096K"+
		"\u0000\u0302\u0300\u0001\u0000\u0000\u0000\u0303\u0306\u0001\u0000\u0000"+
		"\u0000\u0304\u0302\u0001\u0000\u0000\u0000\u0304\u0305\u0001\u0000\u0000"+
		"\u0000\u0305\u0308\u0001\u0000\u0000\u0000\u0306\u0304\u0001\u0000\u0000"+
		"\u0000\u0307\u0309\u0005#\u0000\u0000\u0308\u0307\u0001\u0000\u0000\u0000"+
		"\u0308\u0309\u0001\u0000\u0000\u0000\u0309\u030b\u0001\u0000\u0000\u0000"+
		"\u030a\u02ff\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000"+
		"\u030b\u030c\u0001\u0000\u0000\u0000\u030c\u030d\u0005\u001d\u0000\u0000"+
		"\u030d\u0095\u0001\u0000\u0000\u0000\u030e\u0310\u0003\u0010\b\u0000\u030f"+
		"\u030e\u0001\u0000\u0000\u0000\u030f\u0310\u0001\u0000\u0000\u0000\u0310"+
		"\u0312\u0001\u0000\u0000\u0000\u0311\u0313\u0005*\u0000\u0000\u0312\u0311"+
		"\u0001\u0000\u0000\u0000\u0312\u0313\u0001\u0000\u0000\u0000\u0313\u0314"+
		"\u0001\u0000\u0000\u0000\u0314\u0315\u0003t:\u0000\u0315\u0097\u0001\u0000"+
		"\u0000\u0000\u0316\u0317\u0006L\uffff\uffff\u0000\u0317\u031b\u0003\u009a"+
		"M\u0000\u0318\u0319\u0007\u0003\u0000\u0000\u0319\u031b\u0003\u0098L\u0006"+
		"\u031a\u0316\u0001\u0000\u0000\u0000\u031a\u0318\u0001\u0000\u0000\u0000"+
		"\u031b\u032d\u0001\u0000\u0000\u0000\u031c\u031d\n\u0005\u0000\u0000\u031d"+
		"\u031e\u0007\u0004\u0000\u0000\u031e\u032c\u0003\u0098L\u0006\u031f\u0320"+
		"\n\u0004\u0000\u0000\u0320\u0321\u0007\u0005\u0000\u0000\u0321\u032c\u0003"+
		"\u0098L\u0005\u0322\u0323\n\u0003\u0000\u0000\u0323\u0324\u0007\u0006"+
		"\u0000\u0000\u0324\u032c\u0003\u0098L\u0004\u0325\u0326\n\u0002\u0000"+
		"\u0000\u0326\u0327\u0005,\u0000\u0000\u0327\u032c\u0003\u0098L\u0003\u0328"+
		"\u0329\n\u0001\u0000\u0000\u0329\u032a\u0005+\u0000\u0000\u032a\u032c"+
		"\u0003\u0098L\u0002\u032b\u031c\u0001\u0000\u0000\u0000\u032b\u031f\u0001"+
		"\u0000\u0000\u0000\u032b\u0322\u0001\u0000\u0000\u0000\u032b\u0325\u0001"+
		"\u0000\u0000\u0000\u032b\u0328\u0001\u0000\u0000\u0000\u032c\u032f\u0001"+
		"\u0000\u0000\u0000\u032d\u032b\u0001\u0000\u0000\u0000\u032d\u032e\u0001"+
		"\u0000\u0000\u0000\u032e\u0099\u0001\u0000\u0000\u0000\u032f\u032d\u0001"+
		"\u0000\u0000\u0000\u0330\u0331\u0006M\uffff\uffff\u0000\u0331\u0335\u0003"+
		"\u009eO\u0000\u0332\u0335\u0003\u009cN\u0000\u0333\u0335\u0003\u00cae"+
		"\u0000\u0334\u0330\u0001\u0000\u0000\u0000\u0334\u0332\u0001\u0000\u0000"+
		"\u0000\u0334\u0333\u0001\u0000\u0000\u0000\u0335\u0341\u0001\u0000\u0000"+
		"\u0000\u0336\u033d\n\u0001\u0000\u0000\u0337\u0338\u0005&\u0000\u0000"+
		"\u0338\u033e\u0005\u001b\u0000\u0000\u0339\u033e\u0003\u00c2a\u0000\u033a"+
		"\u033e\u0003\u00c4b\u0000\u033b\u033e\u0003\u00c6c\u0000\u033c\u033e\u0003"+
		"\u00c8d\u0000\u033d\u0337\u0001\u0000\u0000\u0000\u033d\u0339\u0001\u0000"+
		"\u0000\u0000\u033d\u033a\u0001\u0000\u0000\u0000\u033d\u033b\u0001\u0000"+
		"\u0000\u0000\u033d\u033c\u0001\u0000\u0000\u0000\u033e\u0340\u0001\u0000"+
		"\u0000\u0000\u033f\u0336\u0001\u0000\u0000\u0000\u0340\u0343\u0001\u0000"+
		"\u0000\u0000\u0341\u033f\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000"+
		"\u0000\u0000\u0342\u009b\u0001\u0000\u0000\u0000\u0343\u0341\u0001\u0000"+
		"\u0000\u0000\u0344\u0345\u0003t:\u0000\u0345\u0346\u0005\u001c\u0000\u0000"+
		"\u0346\u0348\u0003\u0098L\u0000\u0347\u0349\u0005#\u0000\u0000\u0348\u0347"+
		"\u0001\u0000\u0000\u0000\u0348\u0349\u0001\u0000\u0000\u0000\u0349\u034a"+
		"\u0001\u0000\u0000\u0000\u034a\u034b\u0005\u001d\u0000\u0000\u034b\u009d"+
		"\u0001\u0000\u0000\u0000\u034c\u0356\u0003\u00a0P\u0000\u034d\u034f\u0003"+
		"\u00a6S\u0000\u034e\u0350\u0003v;\u0000\u034f\u034e\u0001\u0000\u0000"+
		"\u0000\u034f\u0350\u0001\u0000\u0000\u0000\u0350\u0356\u0001\u0000\u0000"+
		"\u0000\u0351\u0352\u0005\u001c\u0000\u0000\u0352\u0353\u0003\u0098L\u0000"+
		"\u0353\u0354\u0005\u001d\u0000\u0000\u0354\u0356\u0001\u0000\u0000\u0000"+
		"\u0355\u034c\u0001\u0000\u0000\u0000\u0355\u034d\u0001\u0000\u0000\u0000"+
		"\u0355\u0351\u0001\u0000\u0000\u0000\u0356\u009f\u0001\u0000\u0000\u0000"+
		"\u0357\u035b\u0003\u00a2Q\u0000\u0358\u035b\u0003\u00aaU\u0000\u0359\u035b"+
		"\u0003\u00c0`\u0000\u035a\u0357\u0001\u0000\u0000\u0000\u035a\u0358\u0001"+
		"\u0000\u0000\u0000\u035a\u0359\u0001\u0000\u0000\u0000\u035b\u00a1\u0001"+
		"\u0000\u0000\u0000\u035c\u0361\u0005\u001a\u0000\u0000\u035d\u0361\u0003"+
		"\u00a4R\u0000\u035e\u0361\u0003\u00bc^\u0000\u035f\u0361\u0005E\u0000"+
		"\u0000\u0360\u035c\u0001\u0000\u0000\u0000\u0360\u035d\u0001\u0000\u0000"+
		"\u0000\u0360\u035e\u0001\u0000\u0000\u0000\u0360\u035f\u0001\u0000\u0000"+
		"\u0000\u0361\u00a3\u0001\u0000\u0000\u0000\u0362\u0363\u0007\u0007\u0000"+
		"\u0000\u0363\u00a5\u0001\u0000\u0000\u0000\u0364\u0365\u0005\u001b\u0000"+
		"\u0000\u0365\u00a7\u0001\u0000\u0000\u0000\u0366\u0367\u0005\u001b\u0000"+
		"\u0000\u0367\u0368\u0005&\u0000\u0000\u0368\u0369\u0005\u001b\u0000\u0000"+
		"\u0369\u00a9\u0001\u0000\u0000\u0000\u036a\u036b\u0003\u00acV\u0000\u036b"+
		"\u036c\u0003\u00aeW\u0000\u036c\u00ab\u0001\u0000\u0000\u0000\u036d\u037a"+
		"\u0003\u00b8\\\u0000\u036e\u037a\u0003|>\u0000\u036f\u0370\u0005 \u0000"+
		"\u0000\u0370\u0371\u0005*\u0000\u0000\u0371\u0372\u0005!\u0000\u0000\u0372"+
		"\u037a\u0003\u0080@\u0000\u0373\u037a\u0003\u0086C\u0000\u0374\u037a\u0003"+
		"\u0088D\u0000\u0375\u0377\u0003x<\u0000\u0376\u0378\u0003v;\u0000\u0377"+
		"\u0376\u0001\u0000\u0000\u0000\u0377\u0378\u0001\u0000\u0000\u0000\u0378"+
		"\u037a\u0001\u0000\u0000\u0000\u0379\u036d\u0001\u0000\u0000\u0000\u0379"+
		"\u036e\u0001\u0000\u0000\u0000\u0379\u036f\u0001\u0000\u0000\u0000\u0379"+
		"\u0373\u0001\u0000\u0000\u0000\u0379\u0374\u0001\u0000\u0000\u0000\u0379"+
		"\u0375\u0001\u0000\u0000\u0000\u037a\u00ad\u0001\u0000\u0000\u0000\u037b"+
		"\u0380\u0005\u001e\u0000\u0000\u037c\u037e\u0003\u00b0X\u0000\u037d\u037f"+
		"\u0005#\u0000\u0000\u037e\u037d\u0001\u0000\u0000\u0000\u037e\u037f\u0001"+
		"\u0000\u0000\u0000\u037f\u0381\u0001\u0000\u0000\u0000\u0380\u037c\u0001"+
		"\u0000\u0000\u0000\u0380\u0381\u0001\u0000\u0000\u0000\u0381\u0382\u0001"+
		"\u0000\u0000\u0000\u0382\u0383\u0005\u001f\u0000\u0000\u0383\u00af\u0001"+
		"\u0000\u0000\u0000\u0384\u0389\u0003\u00b2Y\u0000\u0385\u0386\u0005#\u0000"+
		"\u0000\u0386\u0388\u0003\u00b2Y\u0000\u0387\u0385\u0001\u0000\u0000\u0000"+
		"\u0388\u038b\u0001\u0000\u0000\u0000\u0389\u0387\u0001\u0000\u0000\u0000"+
		"\u0389\u038a\u0001\u0000\u0000\u0000\u038a\u00b1\u0001\u0000\u0000\u0000"+
		"\u038b\u0389\u0001\u0000\u0000\u0000\u038c\u038d\u0003\u00b4Z\u0000\u038d"+
		"\u038e\u0005%\u0000\u0000\u038e\u0390\u0001\u0000\u0000\u0000\u038f\u038c"+
		"\u0001\u0000\u0000\u0000\u038f\u0390\u0001\u0000\u0000\u0000\u0390\u0391"+
		"\u0001\u0000\u0000\u0000\u0391\u0392\u0003\u00b6[\u0000\u0392\u00b3\u0001"+
		"\u0000\u0000\u0000\u0393\u0396\u0003\u0098L\u0000\u0394\u0396\u0003\u00ae"+
		"W\u0000\u0395\u0393\u0001\u0000\u0000\u0000\u0395\u0394\u0001\u0000\u0000"+
		"\u0000\u0396\u00b5\u0001\u0000\u0000\u0000\u0397\u039a\u0003\u0098L\u0000"+
		"\u0398\u039a\u0003\u00aeW\u0000\u0399\u0397\u0001\u0000\u0000\u0000\u0399"+
		"\u0398\u0001\u0000\u0000\u0000\u039a\u00b7\u0001\u0000\u0000\u0000\u039b"+
		"\u039c\u0005\n\u0000\u0000\u039c\u03a2\u0005\u001e\u0000\u0000\u039d\u039e"+
		"\u0003\u00ba]\u0000\u039e\u039f\u0003\u00ccf\u0000\u039f\u03a1\u0001\u0000"+
		"\u0000\u0000\u03a0\u039d\u0001\u0000\u0000\u0000\u03a1\u03a4\u0001\u0000"+
		"\u0000\u0000\u03a2\u03a0\u0001\u0000\u0000\u0000\u03a2\u03a3\u0001\u0000"+
		"\u0000\u0000\u03a3\u03a5\u0001\u0000\u0000\u0000\u03a4\u03a2\u0001\u0000"+
		"\u0000\u0000\u03a5\u03a6\u0005\u001f\u0000\u0000\u03a6\u00b9\u0001\u0000"+
		"\u0000\u0000\u03a7\u03a8\u0003\u0010\b\u0000\u03a8\u03a9\u0003t:\u0000"+
		"\u03a9\u03ac\u0001\u0000\u0000\u0000\u03aa\u03ac\u0003\u00be_\u0000\u03ab"+
		"\u03a7\u0001\u0000\u0000\u0000\u03ab\u03aa\u0001\u0000\u0000\u0000\u03ac"+
		"\u03ae\u0001\u0000\u0000\u0000\u03ad\u03af\u0003\u00bc^\u0000\u03ae\u03ad"+
		"\u0001\u0000\u0000\u0000\u03ae\u03af\u0001\u0000\u0000\u0000\u03af\u00bb"+
		"\u0001\u0000\u0000\u0000\u03b0\u03b1\u0007\b\u0000\u0000\u03b1\u00bd\u0001"+
		"\u0000\u0000\u0000\u03b2\u03b4\u0005>\u0000\u0000\u03b3\u03b2\u0001\u0000"+
		"\u0000\u0000\u03b3\u03b4\u0001\u0000\u0000\u0000\u03b4\u03b5\u0001\u0000"+
		"\u0000\u0000\u03b5\u03b7\u0003x<\u0000\u03b6\u03b8\u0003v;\u0000\u03b7"+
		"\u03b6\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000\u03b8"+
		"\u00bf\u0001\u0000\u0000\u0000\u03b9\u03ba\u0005\u0003\u0000\u0000\u03ba"+
		"\u03bb\u0003\u0090H\u0000\u03bb\u03bc\u0003.\u0017\u0000\u03bc\u00c1\u0001"+
		"\u0000\u0000\u0000\u03bd\u03be\u0005 \u0000\u0000\u03be\u03bf\u0003\u0098"+
		"L\u0000\u03bf\u03c0\u0005!\u0000\u0000\u03c0\u00c3\u0001\u0000\u0000\u0000"+
		"\u03c1\u03d1\u0005 \u0000\u0000\u03c2\u03c4\u0003\u0098L\u0000\u03c3\u03c2"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000\u0000\u03c4\u03c5"+
		"\u0001\u0000\u0000\u0000\u03c5\u03c7\u0005%\u0000\u0000\u03c6\u03c8\u0003"+
		"\u0098L\u0000\u03c7\u03c6\u0001\u0000\u0000\u0000\u03c7\u03c8\u0001\u0000"+
		"\u0000\u0000\u03c8\u03d2\u0001\u0000\u0000\u0000\u03c9\u03cb\u0003\u0098"+
		"L\u0000\u03ca\u03c9\u0001\u0000\u0000\u0000\u03ca\u03cb\u0001\u0000\u0000"+
		"\u0000\u03cb\u03cc\u0001\u0000\u0000\u0000\u03cc\u03cd\u0005%\u0000\u0000"+
		"\u03cd\u03ce\u0003\u0098L\u0000\u03ce\u03cf\u0005%\u0000\u0000\u03cf\u03d0"+
		"\u0003\u0098L\u0000\u03d0\u03d2\u0001\u0000\u0000\u0000\u03d1\u03c3\u0001"+
		"\u0000\u0000\u0000\u03d1\u03ca\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001"+
		"\u0000\u0000\u0000\u03d3\u03d4\u0005!\u0000\u0000\u03d4\u00c5\u0001\u0000"+
		"\u0000\u0000\u03d5\u03d6\u0005&\u0000\u0000\u03d6\u03d7\u0005\u001c\u0000"+
		"\u0000\u03d7\u03d8\u0003t:\u0000\u03d8\u03d9\u0005\u001d\u0000\u0000\u03d9"+
		"\u00c7\u0001\u0000\u0000\u0000\u03da\u03e9\u0005\u001c\u0000\u0000\u03db"+
		"\u03e2\u0003\u0012\t\u0000\u03dc\u03df\u0003t:\u0000\u03dd\u03de\u0005"+
		"#\u0000\u0000\u03de\u03e0\u0003\u0012\t\u0000\u03df\u03dd\u0001\u0000"+
		"\u0000\u0000\u03df\u03e0\u0001\u0000\u0000\u0000\u03e0\u03e2\u0001\u0000"+
		"\u0000\u0000\u03e1\u03db\u0001\u0000\u0000\u0000\u03e1\u03dc\u0001\u0000"+
		"\u0000\u0000\u03e2\u03e4\u0001\u0000\u0000\u0000\u03e3\u03e5\u0005*\u0000"+
		"\u0000\u03e4\u03e3\u0001\u0000\u0000\u0000\u03e4\u03e5\u0001\u0000\u0000"+
		"\u0000\u03e5\u03e7\u0001\u0000\u0000\u0000\u03e6\u03e8\u0005#\u0000\u0000"+
		"\u03e7\u03e6\u0001\u0000\u0000\u0000\u03e7\u03e8\u0001\u0000\u0000\u0000"+
		"\u03e8\u03ea\u0001\u0000\u0000\u0000\u03e9\u03e1\u0001\u0000\u0000\u0000"+
		"\u03e9\u03ea\u0001\u0000\u0000\u0000\u03ea\u03eb\u0001\u0000\u0000\u0000"+
		"\u03eb\u03ec\u0005\u001d\u0000\u0000\u03ec\u00c9\u0001\u0000\u0000\u0000"+
		"\u03ed\u03ee\u0003t:\u0000\u03ee\u03ef\u0005&\u0000\u0000\u03ef\u03f0"+
		"\u0005\u001b\u0000\u0000\u03f0\u00cb\u0001\u0000\u0000\u0000\u03f1\u03f6"+
		"\u0005$\u0000\u0000\u03f2\u03f6\u0005\u0000\u0000\u0001\u03f3\u03f6\u0005"+
		"X\u0000\u0000\u03f4\u03f6\u0004f\u0007\u0000\u03f5\u03f1\u0001\u0000\u0000"+
		"\u0000\u03f5\u03f2\u0001\u0000\u0000\u0000\u03f5\u03f3\u0001\u0000\u0000"+
		"\u0000\u03f5\u03f4\u0001\u0000\u0000\u0000\u03f6\u00cd\u0001\u0000\u0000"+
		"\u0000y\u00d1\u00d8\u00de\u00e4\u00f4\u00f8\u00fb\u0104\u010e\u0112\u0116"+
		"\u011a\u0121\u0129\u0134\u0138\u013c\u0144\u014e\u015b\u015f\u0166\u016a"+
		"\u0171\u017d\u0181\u0187\u018b\u018f\u0194\u0197\u019a\u01a1\u01b2\u01b9"+
		"\u01c9\u01d4\u01d8\u01dc\u01e0\u01f3\u01f9\u01fb\u01ff\u0203\u0206\u020a"+
		"\u020c\u0212\u021a\u021f\u022a\u0230\u0237\u0242\u0247\u024b\u0250\u0254"+
		"\u025c\u0264\u0269\u026c\u0274\u027a\u027e\u0280\u0285\u0289\u028d\u0295"+
		"\u029f\u02a6\u02ab\u02b1\u02bb\u02cd\u02d3\u02e7\u02f1\u02f8\u02fc\u0304"+
		"\u0308\u030a\u030f\u0312\u031a\u032b\u032d\u0334\u033d\u0341\u0348\u034f"+
		"\u0355\u035a\u0360\u0377\u0379\u037e\u0380\u0389\u038f\u0395\u0399\u03a2"+
		"\u03ab\u03ae\u03b3\u03b7\u03c3\u03c7\u03ca\u03d1\u03df\u03e1\u03e4\u03e7"+
		"\u03e9\u03f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}