package campbell.language.model.scoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.*;
import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ForStatement extends Scope {
    /**
     * Expression that iterates
     */
    private final Expression var;
    /**
     * Expression where the for should iterate over
     */
    private final Expression iterable;
    /**
     * List containing all statements in this for-loop
     */
    private final List<? extends Statement> statements;

    public ForStatement(Expression var, Expression iterable, List<? extends Statement> statements) {
        this.var = var;
        this.iterable = iterable;
        this.statements = statements;
    }

    public static ForStatement fromContext(CampbellParser.ForNodeContext forNodeContext) {
        Expression arg = Expression.fromContext(forNodeContext.expr(0));
        Expression args = Expression.fromContext(forNodeContext.expr(1));
        List<? extends Statement> block = Statement.fromContexts(forNodeContext.block().statement());

        return at(forNodeContext.getStart(), new ForStatement(arg, args, block));
    }

    /**
     * Sets the scope of this for, its var, iterable and statements
     * @param scope - Scope of this for
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        var.setScope(this);
        iterable.setScope(scope);

        for(Statement stat : statements) {
            stat.setScope(this);
        }
    }

    /**
     * Makes a string representation of this for with correct indenting and all its statements
     * @param indent - indent level of this block
     * @return string representation of this block
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + "for " + var.toString(0) + " in " + iterable.toString(0) + " " + getComment();

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }

    /**
     * Converts this for to the IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(campbell.roborovski.model.Program program, Block block) {
        Block forBlock = new Block();
        block.addStatement(forBlock);

        String it = program.newInternalName();

        new DeclStatement(iterable.getType(), it).toRoborovski(program, forBlock);
        new AssignStatement(new IdentifierExpression(it), iterable).toRoborovski(program, forBlock);

        LinkedList<Statement> whileBody = new LinkedList<>();
        Expression whileCondition = new CallExpression(new DotExpression(new IdentifierExpression(it), "hasNext"), new LinkedList<>());

        whileBody.add(new AssignStatement(var, new CallExpression(new DotExpression(new IdentifierExpression(it), "next"), new LinkedList<Expression>())));
        whileBody.addAll(statements);

        new WhileStatement(whileCondition, whileBody).toRoborovski(program, block);
    }

    /**
     * Makes a deep copy of this for
     * @return deep copy of this for
     */
    @Override
    public ForStatement deepCopy() {
        return new ForStatement(var.deepCopy(), iterable.deepCopy(), statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
    }

    /**
     * Replaces a given type by another given type within this for
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        var.replaceType(replace, replaceWith);
        iterable.replaceType(replace, replaceWith);

        for(Statement stat : statements) {
            stat.replaceType(replace, replaceWith);
        }
    }

    /**
     * Finds definitions in this for.
     * Definition can be a function, declaration or a class.
     */
    @Override
    public void findDefinitions() {
        for(Statement stat : statements) {
            if(stat instanceof DeclStatement) {
                symbols.put(((DeclStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof FunStatement) {
                symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof ClassStatement) {
                types.put(((ClassStatement) stat).getType().getName(), ((ClassStatement) stat).getType());
            }

            if(stat instanceof Scope) {
                ((Scope) stat).findDefinitions();
            }
        }
    }

    /**
     * Finds implementations in this scope
     */
    @Override
    public void findImpls() {
        for(Statement stat : statements) {
            if(stat instanceof Scope) {
                ((Scope) stat).findImpls();
            }
        }
    }

    /**
     * Type checking for the for loops
     *
     * It checks the type of the iterator, iterable and inner statements
     */
    @Override
    public void checkType() {
        if (statements != null) {
            for (Statement stat : statements) {
                stat.checkType();
            }
        }

        if (iterable != null) {
            Type type = iterable.getType();
            if (type instanceof ClassType) {
                //if (!type.isIterable()) {
                    // TODO: Find out how to check iterability
                //}
            }
        }
        if (var != null) {
            if (var.getType() != iterable.getType()) {
                throw new CompileException(this, "Incompatible types for var ("+var.getLine()+") and iterable");
            }
        }
    }
}
