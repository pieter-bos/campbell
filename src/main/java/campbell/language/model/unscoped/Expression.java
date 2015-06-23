package campbell.language.model.unscoped;

import campbell.language.model.*;
import campbell.parser.gen.CampbellParser;

import java.util.LinkedList;
import java.util.List;

public abstract class Expression extends Statement {
    public static Expression fromContext(CampbellParser.ExprContext expr) {
        if(expr instanceof CampbellParser.LtContext) {
            return ComparisonExpression.fromContext((CampbellParser.LtContext) expr);
        } else if(expr instanceof CampbellParser.GtContext) {
            return ComparisonExpression.fromContext((CampbellParser.GtContext) expr);
        } else if(expr instanceof CampbellParser.LteContext) {
            return ComparisonExpression.fromContext((CampbellParser.LteContext) expr);
        } else if(expr instanceof  CampbellParser.GteContext) {
            return ComparisonExpression.fromContext((CampbellParser.GteContext) expr);
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
}
