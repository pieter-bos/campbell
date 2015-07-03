package campbell.parser;

import campbell.language.model.CompileException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

/**
 * Created by sophie on 7/3/15.
 */
public class ErrorListener extends BaseErrorListener implements ANTLRErrorListener {
    /**
     * Method that handles syntax errors
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
        throw new CompileException(i, i1, o.toString(), s);
    }

    /**
     * Unused method from ANTLRErrorListener
     */
    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
        // Nop
    }

    /**
     * Unused method from ANTLRErrorListener
     */
    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
        // Nop
    }

    /**
     * Unused method from ANTLRErrorListener
     */
    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
        // Nop
    }
}
