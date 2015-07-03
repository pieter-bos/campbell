package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.unscoped.BoolLiteralExpression;
import campbell.language.model.unscoped.Expression;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.If;
import campbell.roborovski.model.Program;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * If statement represents an if statement in Campbell
 */
public class IfStatement extends Scope {
    /**
     * Expression that is the condition of the if
     */
    private final Expression condition;
    /**
     * List containing all statements in the then-block of the if
     */
    private final BlockStatement statements;
    /**
     * List containing all statements in the else-block of the if
     */
    private final BlockStatement elseStatements;

    public IfStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = new BlockStatement(statements);
        this.elseStatements = null;
    }

    public IfStatement(Expression condition, List<? extends Statement> statements, List<? extends Statement> elseStatements) {
        this.condition = condition;
        this.statements = new BlockStatement(statements);
        this.elseStatements = new BlockStatement(elseStatements);
    }

    /**
     * Tries to parse an IfStatement from a given context
     * @param ifNodeContext
     * @return
     */
    public static IfStatement fromContext(CampbellParser.IfNodeContext ifNodeContext) {
        Expression condition = Expression.fromContext(ifNodeContext.expr());
        List<? extends Statement> block1 = fromContexts(ifNodeContext.block(0).statement());

        if (ifNodeContext.block().size() != 1) {
            return new IfStatement(condition, block1, fromContexts(ifNodeContext.block(1).statement()));
        } else {
            return new IfStatement(condition, block1);
        }
    }

    /**
     * Sets the scope of this if and all its statements
     * @param scope - Scope of this if
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        this.condition.setScope(scope);

        statements.setScope(scope);

        if (elseStatements != null) {
            elseStatements.setScope(scope);
        }
    }

    /**
     * Makes a string representation of this if with correct indenting and all its statements
     * @param indent - indent level of this if
     * @return string representation of this if
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + "if " + condition.toString(0) + "\n";

        result += statements.toString(indent + 1);

        if(elseStatements != null) {
            result += "\n" + indent(indent) + "else" + "\n";
            result += elseStatements.toString(indent + 1);
        }

        return result;
    }

    /**
     * Converts this if to the IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        Block ifBlock = new Block();
        Block elseBlock = new Block();

        statements.toRoborovski(program, ifBlock);

        if(elseStatements != null) {
            elseStatements.toRoborovski(program, elseBlock);
        }

        block.addStatement(new If(condition.toRoborovski(program), ifBlock, elseBlock));
    }

    /**
     * Makes a deep copy of this if
     * @return deep copy of this if
     */
    @Override
    public IfStatement deepCopy() {
        if(elseStatements == null) {
            return new IfStatement(condition.deepCopy(),
                    StreamSupport.stream(statements.spliterator(), true).collect(Collectors.toList()));
        } else {
            return new IfStatement(condition.deepCopy(),
                    StreamSupport.stream(statements.spliterator(), true).collect(Collectors.toList()),
                    StreamSupport.stream(elseStatements.spliterator(), true).collect(Collectors.toList()));
        }
    }

    /**
     * Replaces a given type by another given type within this function
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        condition.replaceType(replace, replaceWith);

        for (Statement stat : statements) {
            stat.replaceType(replace, replaceWith);
        }

        if (elseStatements != null) {
            for (Statement stat : elseStatements) {
                stat.replaceType(replace, replaceWith);
            }
        }
    }

    /**
     * Method that checks whether this if statement returns
     *
     * If statements only return if both blocks contain a return statement
     * @return
     */
    @Override
    public boolean returns() {
        return elseStatements.returns() && statements.returns();
    }

    /**
     * Finds definitions in this if.
     * Definition can be a function, declaration or a class.
     */
    @Override
    public void findDefinitions() {
        statements.findDefinitions();

        if(elseStatements != null) {
            elseStatements.findDefinitions();
        }
    }

    /**
     * Finds implementations in this scope
     */
    @Override
    public void findImpls() {
        statements.findImpls();

        if(elseStatements != null) {
            elseStatements.findImpls();
        }
    }

    /**
     * Type checking for the if statement
     *
     * It checks whether the condition is a boolean expression,
     * as well as the inner statements of the if/else blocks
     */
    @Override
    public void checkType() {
        if (condition instanceof BoolLiteralExpression) {
            if (statements != null) {
                for (Statement stat : statements) {
                    stat.checkType();
                }
            }
            if (elseStatements != null) {
                for (Statement elseStat : elseStatements) {
                    elseStat.checkType();
                }
            }
        }
    }
}
