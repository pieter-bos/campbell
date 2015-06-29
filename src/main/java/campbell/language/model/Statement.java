package campbell.language.model;

import campbell.language.model.scoped.*;
import campbell.language.model.unscoped.AssignStatement;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.model.unscoped.Expression;
import campbell.language.model.unscoped.ReturnStatement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;
import java.util.List;

public abstract class Statement implements Node {
    protected int line;
    protected int col;
    protected Scope scope;

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
        } else if(ctx.haskell() != null) {
            return HaskellStatement.fromContext(ctx.haskell());
        }

        throw new campbell.language.model.NotImplementedException(ctx);
    }

    // We cannot overload functions that differ only in generic type since those types are erased compile-time,
    // but we can also not override functions that differ in generic type since the types differ before erasure...
    @SuppressWarnings("unchecked")
    public static List<? extends Statement> fromContexts(List/*<CampbellParser.StatementContext>*/ untypedStatements) {
        List<CampbellParser.StatementContext> statements = (List<CampbellParser.StatementContext>) untypedStatements;
        LinkedList<Statement> result = new LinkedList<>();

        for(CampbellParser.StatementContext ctx : statements) {
            result.add(fromContext(ctx));
        }

        return result;
    }

    public abstract void setScope(Scope scope);

    public abstract String toString(int indent);

    protected String indent(int indent) {
        String result = "";

        for(int i = 0; i < indent; i++) {
            result += "    ";
        }

        return result;
    }

    public static <T extends Statement> T at(Token start, T s) {
        s.line = start.getLine();
        s.col = start.getCharPositionInLine();
        return s;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public Scope getScope() {
        return scope;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getCol() {
        return col;
    }

    public Type findType(String name) {
        return getScope().findType(name);
    }

    public Symbol findSymbol(String name) {
        System.out.println(this + " " + getScope());
        return getScope().findSymbol(name);
    }

    public Symbol requireSymbol(String name, Node place) {
        Symbol symbol = findSymbol(name);

        if(symbol == null) {
            throw new CompileException(place, "Usage of nonexistant symbol " + name);
        } else {
            return symbol;
        }
    }

    public abstract void toRoborovski(campbell.roborovski.model.Program program, campbell.roborovski.model.Block block);

    public Program toRoborovski() {
        Program p = new Program();
        toRoborovski(p, p);
        return p;
    }

    public abstract Statement deepCopy();

    public abstract void replaceType(Type replace, Type replaceWith);
}
