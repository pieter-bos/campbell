package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.ClassStatement;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.FunctionType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.FunctionExpression;
import campbell.roborovski.model.Program;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Call expression represents an expression used to call a function in Campbell
 */
public class CallExpression extends Expression {
    /**
     * Name of the function to be called
     */
    private final Expression callee;

    /**
     * List containing all arguments given when the function is called
     */
    private final List<? extends Expression> arguments;

    public CallExpression(Expression callee, List<? extends Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }

    /**
     * Tries to parse a CallExpression from a given context
     * @param call
     * @param callee
     * @return
     */
    public static CallExpression fromContext(CampbellParser.CallContext call, Expression callee) {
        return at(call.getStart(), new CallExpression(callee, Expression.fromContexts(call.expr())));
    }

    /**
     * Sets the scope of this call expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        callee.setScope(scope);

        for(Expression expr : arguments) {
            expr.setScope(scope);
        }
    }

    /**
     * Makes a string representation of this call expression with correct indenting
     * @param indent - indent level of this call expression
     * @return string representation of this call expression
     */
    @Override
    public String toString(int indent) {
        String result = callee.toString(indent) + "(";
        boolean firstArgument = true;

        for(Expression arg : arguments) {
            if(!firstArgument) {
                result += ", ";
            }

            firstArgument = false;

            result += arg.toString(0);
        }

        result += ")";

        return result;
    }

    /**
     * Makes a deep copy of this call expression
     * @return deep copy of this call expression
     */
    @Override
    public CallExpression deepCopy() {
        return new CallExpression(callee.deepCopy(), arguments.stream().map(Expression::deepCopy).collect(Collectors.toList()));
    }

    /**
     * Replaces a given type by another given type within this call expression
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        callee.replaceType(replace, replaceWith);
        for (Expression e : arguments) {
            e.replaceType(replace, replaceWith);
        }
    }

    /**
     * Returns the type of the expression
     * @return
     */
    @Override
    public Type getType() {
        Type currentType = callee.getType();

        for(int i = 0; i < arguments.size(); i++) {
            if(currentType instanceof FunctionType) {
                currentType = ((FunctionType) currentType).getReturnType();
            } else {
                throw new CompileException(this, "Type " + currentType.getName() + " is not callable.");
            }
        }

        return currentType;
    }

    /**
     * Converts this call expression to the IR Roborovski
     *
     * @param program
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        LinkedList<campbell.roborovski.model.Expression> args = new LinkedList<>();

        for(Expression e : arguments) {
            args.add(e.toRoborovski(program));
        }

        boolean curried = getType() instanceof FunctionType;

        if(callee instanceof IdentifierExpression
                && findSymbol(((IdentifierExpression) callee).getId()) == null
                && findType(((IdentifierExpression) callee).getId()) != null) {
            ClassStatement type = (ClassStatement) findType(((IdentifierExpression) callee).getId()).getImplementation();
            return new campbell.roborovski.model.CallExpression(curried, new FunctionExpression(((FunStatement) type.getImplementation(Collections.emptyList(), program).findSymbol("#construct")).getFunction()), args);
        } else {
            return new campbell.roborovski.model.CallExpression(curried, callee.toRoborovski(program), args);
        }
    }

    /**
     * Type checking for call expressions
     */
    @Override
    public void checkType() {
        //nop
    }
}
