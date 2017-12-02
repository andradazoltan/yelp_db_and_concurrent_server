// Generated from Grammar.g4 by ANTLR 4.5.1
package ca.ece.ubc.cpen221.mp5;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, WORD=6, SPACE=7, NUM=8, OR=9, 
		AND=10, LPAREN=11, RPAREN=12, EQ=13, LTE=14, LT=15, GT=16, GTE=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "WORD", "SPACE", "NUM", "OR", 
		"AND", "LPAREN", "RPAREN", "EQ", "LTE", "LT", "GT", "GTE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'in'", "'category'", "'name'", "'price'", "'rating'", null, null, 
		null, "'||'", "'&&'", "'('", "')'", "'='", "'<='", "'<'", "'>'", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "WORD", "SPACE", "NUM", "OR", "AND", 
		"LPAREN", "RPAREN", "EQ", "LTE", "LT", "GT", "GTE"
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23g\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\6\7E\n\7\r\7\16"+
		"\7F\3\b\6\bJ\n\b\r\b\16\bK\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23\3\2\5\4\2C\\c|\4\2\13\f\"\"\3\2\62;h\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3"+
		"%\3\2\2\2\5(\3\2\2\2\7\61\3\2\2\2\t\66\3\2\2\2\13<\3\2\2\2\rD\3\2\2\2"+
		"\17I\3\2\2\2\21O\3\2\2\2\23Q\3\2\2\2\25T\3\2\2\2\27W\3\2\2\2\31Y\3\2\2"+
		"\2\33[\3\2\2\2\35]\3\2\2\2\37`\3\2\2\2!b\3\2\2\2#d\3\2\2\2%&\7k\2\2&\'"+
		"\7p\2\2\'\4\3\2\2\2()\7e\2\2)*\7c\2\2*+\7v\2\2+,\7g\2\2,-\7i\2\2-.\7q"+
		"\2\2./\7t\2\2/\60\7{\2\2\60\6\3\2\2\2\61\62\7p\2\2\62\63\7c\2\2\63\64"+
		"\7o\2\2\64\65\7g\2\2\65\b\3\2\2\2\66\67\7r\2\2\678\7t\2\289\7k\2\29:\7"+
		"e\2\2:;\7g\2\2;\n\3\2\2\2<=\7t\2\2=>\7c\2\2>?\7v\2\2?@\7k\2\2@A\7p\2\2"+
		"AB\7i\2\2B\f\3\2\2\2CE\t\2\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2"+
		"G\16\3\2\2\2HJ\t\3\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2"+
		"\2MN\b\b\2\2N\20\3\2\2\2OP\t\4\2\2P\22\3\2\2\2QR\7~\2\2RS\7~\2\2S\24\3"+
		"\2\2\2TU\7(\2\2UV\7(\2\2V\26\3\2\2\2WX\7*\2\2X\30\3\2\2\2YZ\7+\2\2Z\32"+
		"\3\2\2\2[\\\7?\2\2\\\34\3\2\2\2]^\7>\2\2^_\7?\2\2_\36\3\2\2\2`a\7>\2\2"+
		"a \3\2\2\2bc\7@\2\2c\"\3\2\2\2de\7@\2\2ef\7?\2\2f$\3\2\2\2\5\2FK\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}