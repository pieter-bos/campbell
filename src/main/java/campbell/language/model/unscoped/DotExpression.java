package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.ClassStatement;
import campbell.language.model.scoped.FunStatement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.CallExpression;

import java.util.LinkedList;

public class DotExpression extends Expression {
    private final Expression expr;
    private final String property;

    public DotExpression(Expression expr, String property) {
        this.expr = expr;
        this.property = property;
    }

    public static DotExpression fromContext(CampbellParser.GetContext ctx, Expression expr) {
        return at(ctx.getStart(), new DotExpression(expr, ctx.IDENTIFIER().getText()));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        expr.setScope(scope);
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "(" + expr.toString(0) + "." + property + ")";
    }

    @Override
    public DotExpression deepCopy() {
        return new DotExpression(expr.deepCopy(), property);
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        expr.replaceType(replace, replaceWith);
    }

    @Override
    public Type getType() {
        if(expr.getType() instanceof ClassType) {
            return ((ClassStatement) expr.getType().getImplementation()).findSymbol(property).getType();
        } else {
            throw new CompileException(this, "Cannot get a property of type " + expr.getType());
        }
    }

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
}
