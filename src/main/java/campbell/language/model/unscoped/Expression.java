package campbell.language.model.unscoped;

import campbell.language.model.*;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

import java.util.LinkedList;
import java.util.List;

/**
 * Expression is an enveloping class for all expressions
 */
public abstract class Expression extends Statement {
    /**
     * Tries to parse an Expression based on the type of context given
     * Expr: And/Or/Xor/Super
     *
     * If this fails, it shall throw a NotImplementedException
     * @param expr
     * @return
     */
    public static Expression fromContext(CampbellParser.ExprContext expr) {
        if (expr instanceof CampbellParser.AndContext) {
            return MathExpression.fromContext((CampbellParser.AndContext) expr);
        } else if (expr instanceof CampbellParser.OrContext) {
            return MathExpression.fromContext((CampbellParser.OrContext) expr);
        } else if (expr instanceof CampbellParser.XorContext) {
            return MathExpression.fromContext((CampbellParser.XorContext) expr);
        } else if(expr instanceof CampbellParser.SuperExprContext) {
            return fromContext(((CampbellParser.SuperExprContext) expr).expr0());
        }

        throw new NotImplementedException(expr);
    }

    /**
     * Tries to parse an Expression based on the type of context given
     * Expr0: GreaterThan/GreaterThanEquals/LessThan/LessThanEquals/Equals/NotEquals/Negate
     *
     * If this fails, it shall throw a NotImplementedException
     * @param expr
     * @return
     */
    public static Expression fromContext(CampbellParser.Expr0Context expr) {
        if(expr instanceof CampbellParser.LtContext) {
            return ComparisonExpression.fromContext((CampbellParser.LtContext) expr);
        } else if(expr instanceof CampbellParser.GtContext) {
            return ComparisonExpression.fromContext((CampbellParser.GtContext) expr);
        } else if(expr instanceof CampbellParser.LteContext) {
            return ComparisonExpression.fromContext((CampbellParser.LteContext) expr);
        } else if(expr instanceof  CampbellParser.GteContext) {
            return ComparisonExpression.fromContext((CampbellParser.GteContext) expr);
        } else if(expr instanceof CampbellParser.EqContext) {
            return ComparisonExpression.fromContext((CampbellParser.EqContext) expr);
        } else if(expr instanceof CampbellParser.NeqContext) {
            return ComparisonExpression.fromContext((CampbellParser.NeqContext) expr);
        } else if(expr instanceof CampbellParser.SimpleExprContext) {
            return fromContext(((CampbellParser.SimpleExprContext) expr).expr1());
        }

        throw new NotImplementedException(expr);
    }

    public static Expression fromContext(CampbellParser.Expr1Context expr) {
        if(expr instanceof CampbellParser.AddContext) {
            return MathExpression.fromContext((CampbellParser.AddContext) expr);
        } else if(expr instanceof CampbellParser.SubtractContext) {
            return MathExpression.fromContext((CampbellParser.SubtractContext) expr);
        } else if(expr instanceof CampbellParser.SimpleExpr1Context) {
            return fromContext(((CampbellParser.SimpleExpr1Context) expr).expr2());
        }

        throw new NotImplementedException(expr);
    }

    public static Expression fromContext(CampbellParser.Expr2Context expr) {
        if(expr instanceof CampbellParser.MultiplyContext) {
            return MathExpression.fromContext((CampbellParser.MultiplyContext) expr);
        } else if(expr instanceof CampbellParser.DivideContext) {
            return MathExpression.fromContext((CampbellParser.DivideContext) expr);
        } else if(expr instanceof CampbellParser.ModuloContext) {
            return MathExpression.fromContext((CampbellParser.ModuloContext) expr);
        } else if(expr instanceof CampbellParser.LshContext) {
            return MathExpression.fromContext((CampbellParser.LshContext) expr);
        } else if(expr instanceof CampbellParser.RshContext) {
            return MathExpression.fromContext((CampbellParser.RshContext) expr);
        } else if(expr instanceof CampbellParser.SimpleExpr2Context) {
            return fromContext(((CampbellParser.SimpleExpr2Context) expr).expr3());
        }

        throw new NotImplementedException(expr);
    }

    public static Expression fromContext(CampbellParser.Expr3Context expr) {
        if(expr instanceof CampbellParser.NegateContext) {
            return UnaryMathExpression.fromContext((CampbellParser.NegateContext) expr);
        } else if(expr instanceof CampbellParser.SimpleExpr3Context) {
            return fromContext(((CampbellParser.SimpleExpr3Context) expr).expr4());
        }

        throw new NotImplementedException(expr);
    }

    private static Expression fromContext(CampbellParser.Expr4Context expr) {
        Expression current = null;
        List<CampbellParser.ExprAddonContext> addons = null;

        if(expr instanceof CampbellParser.IntContext) {
            current = IntLiteralExpression.fromContext(((CampbellParser.IntContext) expr).INT());
            addons = ((CampbellParser.IntContext) expr).exprAddon();
        } else if(expr instanceof CampbellParser.BoolExprContext) {
            current = BoolLiteralExpression.fromContext(((CampbellParser.BoolExprContext) expr).bool());
            addons = ((CampbellParser.BoolExprContext) expr).exprAddon();
        } else if(expr instanceof CampbellParser.IdContext) {
            current = IdentifierExpression.fromContext(((CampbellParser.IdContext) expr).IDENTIFIER());
            addons = ((CampbellParser.IdContext) expr).exprAddon();
        } else if(expr instanceof CampbellParser.ParenContext) {
            current = fromContext(((CampbellParser.ParenContext) expr).expr());
            addons = ((CampbellParser.ParenContext) expr).exprAddon();
        }

        if(current == null) {
            throw new NotImplementedException(expr);
        }

        for(CampbellParser.ExprAddonContext addon : addons) {
            current = fromContext(addon, current);
        }

        return current;
    }

    private static Expression fromContext(CampbellParser.ExprAddonContext addon, Expression current) {
        if(addon instanceof CampbellParser.CallContext) {
            return CallExpression.fromContext((CampbellParser.CallContext) addon, current);
        } else if(addon instanceof CampbellParser.GetContext) {
            return DotExpression.fromContext((CampbellParser.GetContext) addon, current);
        }

        throw new NotImplementedException(addon);
    }


    @SuppressWarnings("unchecked")
    public static List<? extends Expression> fromContexts(List/*<CampbellParser.ExprContext>*/ untypedExpressions) {
        List<CampbellParser.ExprContext> expressions = (List<CampbellParser.ExprContext>) untypedExpressions;
        LinkedList<Expression> result = new LinkedList<>();

        for(CampbellParser.ExprContext expr : expressions) {
            result.add(fromContext(expr));
        }

        return result;
    }

    /**
     * Method to return the type of the expression
     * @return type of expression
     */
    public abstract Type getType();

    /**
     * Converts expression to the IR Roborovski
     * @param program
     * @return
     */
    public abstract campbell.roborovski.model.Expression toRoborovski(Program program);

    /**
     * Converts expression to the IR Roborovski
     * This is then added to the given block
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        block.addStatement(toRoborovski(program));
    }

    /**
     * Method to return a deep copy of the expression
     * @return
     */
    public abstract Expression deepCopy();
}