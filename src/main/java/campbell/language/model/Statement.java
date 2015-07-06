package campbell.language.model;

import campbell.language.model.scoped.*;
import campbell.language.model.unscoped.*;
import campbell.language.model.unscoped.Expression;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Program;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;
import java.util.List;

/**
 * Statement is an enveloping class for all statements
 */
public abstract class Statement implements Node {
    /**
     * Line number of statement
     * Used for place in AST
     */
    protected int line;

    /**
     * Column of statement
     * Used for place in AST
     */
    protected int col;

    /**
     * Scope of this statement
     */
    protected Scope scope;

    /**
     * Tries to parse a Statement from a given context
     *
     * If this fails, it shall throw a NotImplementedException
     * @param ctx
     * @return
     */
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
        } else if(ctx.nop() != null) {
            return NopStatement.fromContext(ctx.nop());
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

    /**
     * Tries to parse a top-level statement from a given context
     * @param ctx
     * @return
     */
    public static Statement fromContext(CampbellParser.TopLevelStatementContext ctx) {
        if(ctx instanceof CampbellParser.NormalStatementContext) {
            return fromContext(((CampbellParser.NormalStatementContext) ctx).statement());
        } else if(ctx instanceof CampbellParser.SharedDeclContext) {
            return SharedDeclStatement.fromContext((CampbellParser.SharedDeclContext) ctx);
        } else if(ctx instanceof CampbellParser.CoresContext) {
            return CoresStatement.fromContext((CampbellParser.CoresContext) ctx);
        }

        throw new NotImplementedException(ctx);
    }

    /**
     * Abstract method to set the scope of the statement
     * @param scope
     */
    public abstract void setScope(Scope scope);

    /**
     * Abstract method to make a string representation of the statement with indenting
     * @param indent
     * @return
     */
    public abstract String toString(int indent);

    /**
     * Returns a string representation of this statement with indenting
     * @param indent
     * @return
     */
    protected String indent(int indent) {
        String result = "";

        for(int i = 0; i < indent; i++) {
            result += "    ";
        }

        return result;
    }

    /**
     * Shall return a Statement with its place set to the place of this Statement
     * @param start
     * @param s
     * @param <T>
     * @return
     */
    public static <T extends Statement> T at(Token start, T s) {
        s.line = start.getLine();
        s.col = start.getCharPositionInLine();
        return s;
    }

    /**
     * Returns a string representation of this statement with no indenting
     * @return
     */
    @Override
    public String toString() {
        return toString(0);
    }

    /**
     * Returns the scope of this statement
     * @return
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * Returns the line (location) of this statement
     * @return
     */
    @Override
    public int getLine() {
        return line;
    }

    /**
     * Returns the column (location) of this statement
     * @return
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * Tries to find the type of a given string
     * @param name - variable's name whose type is wanted
     * @return
     */
    public Type findType(String name) {
        return getScope().findType(name);
    }

    /**
     * Tries to find the symbol of a given string
     * @param name - variable's name whose symbol is wanted
     * @return
     */
    public Symbol findSymbol(String name) {
        return getScope().findSymbol(name);
    }

    /**
     * Method that will return the symbol of a given string
     *
     * If the symbol cannot be found, it shall throw a CompileException
     * @param name
     * @param place
     * @return
     */
    public Symbol requireSymbol(String name, Node place) {
        Symbol symbol = findSymbol(name);

        if(symbol == null) {
            throw new CompileException(place, "Usage of nonexistant symbol " + name);
        } else {
            return symbol;
        }
    }

    /**
     * Abstract method to convert given statement to IR Roborovski
     * @param program
     * @param block
     */
    public abstract void toRoborovski(campbell.roborovski.model.Program program, campbell.roborovski.model.Block block);

    /**
     * Method that will return this statement in IR Roborovski
     * @return
     */
    public Program toRoborovski() {
        Program p = new Program();
        toRoborovski(p, p);
        return p;
    }

    /**
     * Abstract method to make a deep copy of a statement
     * @return
     */
    public abstract Statement deepCopy();

    /**
     * Abstract method that will replace the first given type in statements by the second given type
     * @param replace
     * @param replaceWith
     */
    public abstract void replaceType(Type replace, Type replaceWith);

    /**
     * Abstract method that checks whether this statement returns
     * @return
     */
    public abstract boolean returns();

    /**
     * Checks whether a function is required
     * @param name
     * @param place
     * @return
     */
    public FunStatement requireFunction(String name, Node place) {
        Symbol symbol = requireSymbol(name, place);

        if(!(symbol instanceof FunStatement)) {
            throw new CompileException(place, "Symbol " + name + " is not a function, whereas it should be.");
        }

        return (FunStatement) symbol;
    }
}
