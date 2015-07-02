package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.FunctionType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Return;

public class ReturnStatement extends Statement {
    /**
     * Expression that should be returned
     */
    private Expression returnExpression;

    public ReturnStatement(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }

    public static Statement fromContext(CampbellParser.ReturnNodeContext returnNodeContext) {
        return at(returnNodeContext.getStart(), new ReturnStatement(Expression.fromContext(returnNodeContext.expr())));
    }

    /**
     * Sets the scope of this return statement
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        returnExpression.setScope(scope);
    }

    /**
     * Makes a string representation of this return statement with correct indenting
     * @param indent - indent level of this return statement
     * @return string representation of this return statement
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + "return " + returnExpression.toString(0);
    }

    /**
     * Converts this return statement to the IR Roborovski
     * @param program
     * @param block
     * @return
     */
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

    /**
     * Makes a deep copy of this return statement
     * @return deep copy of return statement
     */
    @Override
    public Statement deepCopy() {
        return new ReturnStatement(returnExpression.deepCopy());
    }

    /**
     * Replaces a given type by another given type within this return statement
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        returnExpression.replaceType(replace, replaceWith);
    }

    /**
     * Type checking for return statements
     *
     * Return statements must return an expression of the same type as the function's return type
     */
    @Override
    public void checkType() {
        Scope s = getScope();

        while (!(s instanceof FunStatement)) {
            s = s.getScope();

            if (s == null) {
               throw new CompileException(this, "Cannot return outside of all functions");
            }
        }
        Type functionReturnType = ((FunctionType) ((FunStatement) s).getType()).getReturnType();
        if (!functionReturnType.equals(returnExpression.getType())) {
            throw new CompileException(this, "Type of return expression ("+returnExpression.getType().toString()+") does not correspond to the function's contract ("+functionReturnType.getName()+")");
        }
    }
}
