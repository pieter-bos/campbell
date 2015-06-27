package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.model.Statement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Return;

public class ReturnStatement extends Statement {
    private Expression returnExpression;

    public ReturnStatement(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }

    public static Statement fromContext(CampbellParser.ReturnNodeContext returnNodeContext) {
        return at(returnNodeContext.getStart(), new ReturnStatement(Expression.fromContext(returnNodeContext.expr())));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "return " + returnExpression.toString(0);
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        Scope s = getScope();

        while(!(s instanceof FunStatement)) {
            s = s.getScope();

            if(s == null) {
                throw new CompileException(this, "Cannot return outside of all functions");
            }
        }

        block.addStatement(new Return(returnExpression.toRoborovski(program), ((FunStatement) s).getFunction()));
    }

    @Override
    public Statement deepCopy() {
        return new ReturnStatement(returnExpression.deepCopy());
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        returnExpression.replaceType(replace, replaceWith);
    }
}
