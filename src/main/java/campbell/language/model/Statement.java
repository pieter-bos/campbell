package campbell.language.model;

import campbell.parser.gen.CampbellParser;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

public abstract class Statement {
    public static Statement fromContext(CampbellParser.StatementContext ctx) {
        if(ctx.fun() != null) {
            return FunStatement.fromContext(ctx.fun());
        } else if(ctx.unsafe() != null) {
            return UnsafeStatement.fromContext(ctx.unsafe());
        } else if(ctx.whileNode() != null) {
            return WhileStatement.fromContext(ctx.whileNode());
        } else if(ctx.ifNode() != null) {
            return IfStatement.fromContext(ctx.ifNode());
        } else if(ctx.impl() != null) {
            return ImplStatement.fromContext(ctx.impl());
        } else if(ctx.trait() != null) {
            return TraitStatement.fromContext(ctx.trait());
        } else if(ctx.returnNode() != null) {
            return ReturnStatement.fromContext(ctx.returnNode());
        } else if(ctx.expr() != null) {
            return Expression.fromContext(ctx.expr());
        } else if(ctx.decl() != null) {
            return DeclStatement.fromContext(ctx.decl());
        } else if(ctx.assign() != null) {
            return AssignStatement.fromContext(ctx.assign());
        } else if(ctx.classNode() != null) {
            return ClassStatement.fromContext(ctx.classNode());
        } else if(ctx.forNode() != null) {
            return ForStatement.fromContext(ctx.forNode());
        }

        return null;
    }

    public static List<Statement> fromContexts(List<CampbellParser.StatementContext> statements) {
        LinkedList<Statement> result = new LinkedList<>();

        for(CampbellParser.StatementContext ctx : statements) {
            result.add(fromContext(ctx));
        }

        return result;
    }
}
