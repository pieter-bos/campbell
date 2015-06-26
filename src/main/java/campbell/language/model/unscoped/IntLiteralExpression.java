package campbell.language.model.unscoped;

import campbell.language.model.scoped.Scope;
import campbell.language.types.IntType;
import campbell.language.types.Type;
import campbell.roborovski.model.ConstExpression;
import campbell.roborovski.model.Program;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;

public class IntLiteralExpression extends Expression {
    private BigInteger value;

    public IntLiteralExpression(String value) {
        this.value = new BigInteger(value);
    }

    public static IntLiteralExpression fromContext(TerminalNode ctx) {
        return at(ctx.getSymbol(), new IntLiteralExpression(ctx.getText()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return value.toString();
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        return new ConstExpression(value.intValue());
    }

    @Override
    public IntLiteralExpression deepCopy() {
        return new IntLiteralExpression(value.toString());
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // Nop
    }
}
