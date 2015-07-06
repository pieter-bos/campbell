package campbell.language.model.scoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.*;
import campbell.language.model.unscoped.CallExpression;
import campbell.language.model.unscoped.DotExpression;
import campbell.language.model.unscoped.Expression;
import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * For statement represents a for loop in Campbell
 */
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

    /**
     * Tries to parse a ForStatement from a given context
     *
     * @param forNodeContext
     * @return
     */
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
        Variable it = new Variable(program.newInternalName());
        block.addVariable(it);

        block.addStatement(new Assign(new VariableExpression(it), iterable.toRoborovski(program)));
        While forBlock = new While(new campbell.roborovski.model.CallExpression(false,
                new FunctionExpression(((ClassStatement) iterable.getType().getImplementation()).requireFunction("hasNext", this).getFunction()),
                Arrays.asList(new VariableExpression(it))));
        block.addStatement(forBlock);

        forBlock.addStatement(new Assign(new VariableExpression(it), new campbell.roborovski.model.CallExpression(false,
                new FunctionExpression(((ClassStatement) iterable.getType().getImplementation()).requireFunction("next", this).getFunction()),
                Arrays.asList(new VariableExpression(it)))));

        for(Statement stat : statements) {
            stat.toRoborovski(program, forBlock);
        }
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
     * Method that checks whether this for statement returns
     *
     * For statement never return
     * @return
     */
    @Override
    public boolean returns() {
        for (Statement stat : statements) {
            if (stat.returns()) {
                return true;
            }
        }
        return false;
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
//        if (statements != null) {
//            for (Statement stat : statements) {
//                stat.checkType();
//            }
//        }
//
//        if (iterable != null) {
//            Type type = iterable.getType();
//            if (type instanceof ClassType) {
//                //if (!type.isIterable()) {
//                    // TODO: Find out how to check iterability
//                //}
//            }
//        }
//        if (var != null) {
//            if (var.getType() != iterable.getType()) {
//                throw new CompileException(this, "Incompatible types for var ("+var.getLine()+") and iterable");
//            }
//        }
    }
}
