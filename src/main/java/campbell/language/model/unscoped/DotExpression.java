package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.NotImplementedException;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.ClassStatement;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.CallExpression;
import campbell.roborovski.model.FunctionExpression;
import campbell.roborovski.model.Program;

import java.util.LinkedList;

/**
 * Dot expression represents the getting of a variable from a class in Campbell
 */
public class DotExpression extends Expression {
    /**
     * Expression of which the property is wanted
     */
    private final Expression expr;

    /**
     * Property that is wanted from the given expression
     */
    private final String property;

    public DotExpression(Expression expr, String property) {
        this.expr = expr;
        this.property = property;
    }

    /**
     * Tries to parse a DotExpression from a given context
     * @param ctx
     * @param expr
     * @return
     */
    public static DotExpression fromContext(CampbellParser.GetContext ctx, Expression expr) {
        return at(ctx.getStart(), new DotExpression(expr, ctx.IDENTIFIER().getText()));
    }

    /**
     * Sets the scope of this dot expression
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        expr.setScope(scope);
    }

    /**
     * Makes a string representation of this dot expression with correct indenting
     * @param indent - indent level of this dot expression
     * @return string representation of this dot expression
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + "(" + expr.toString(0) + "." + property + ")";
    }

    /**
     * Makes a deep copy of this dot expression
     * @return deep copy of this dot expression
     */
    @Override
    public DotExpression deepCopy() {
        return new DotExpression(expr.deepCopy(), property);
    }

    /**
     * Replaces a given type by another given type within this dot expression
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        expr.replaceType(replace, replaceWith);
    }

    /**
     * Returns the type of the property of the given expression
     * @return type of the dot expression
     */
    @Override
    public Type getType() {
        if(expr.getType() instanceof ClassType) {
            return ((ClassStatement) findType(expr.getType().getName()).getImplementation()).findSymbol(property).getType();
        } else {
            throw new CompileException(this, "Cannot get a property of type " + expr.getType());
        }
    }

    /**
     * Converts this dot expression to the IR Roborovski
     * @param program
     * @return
     */
    @Override
    public campbell.roborovski.model.Expression toRoborovski(Program program) {
        if(expr.getType() instanceof ClassType) {
            ClassStatement genericClass = (ClassStatement) findType(expr.getType().getName()).getImplementation();
            ClassStatement specificClass = genericClass.getImplementation(((ClassType) expr.getType()).getParametricTypes(), program);
            Symbol symbol = specificClass.findSymbol(property);

            if(symbol == null) {
                throw new CompileException(this, "Unknown property " + property + " of type " + specificClass.getType());
            }

            if(symbol instanceof FunStatement) {
                LinkedList<campbell.roborovski.model.Expression> args = new LinkedList<>();
                args.add(expr.toRoborovski(program));
                return new CallExpression(false, new FunctionExpression(((FunStatement) symbol).getFunction()), args);
            } else if(symbol instanceof DeclStatement) {
                return new campbell.roborovski.model.DotExpression(expr.toRoborovski(program), specificClass.getStruct(), property);
            }

            throw new CompileException(this, "Internal error: dot not implemented for type " + symbol.getClass());
        } else {
            throw new CompileException(this, "Cannot get a property of type " + expr.getType());
        }
    }

    /**
     * Type checking for dot expressions
     */
    @Override
    public void checkType() {
        if (expr.getType() instanceof ClassType && expr.getType().getImplementation() == null) {
            throw new NotImplementedException(""+expr.getType().getName()+" not implemented");
        }
    }
}
