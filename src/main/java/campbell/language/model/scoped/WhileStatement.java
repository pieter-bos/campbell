package campbell.language.model.scoped;

import campbell.language.model.Symbol;
import campbell.language.model.unscoped.BoolLiteralExpression;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.model.unscoped.Expression;
import campbell.language.model.Statement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;

import java.util.List;
import java.util.stream.Collectors;

public class WhileStatement extends Scope {
    /**
     * Condition of the while loop
     */
    private final Expression condition;
    /**
     * List containing all statements in the while-loop
     */
    private final List<? extends Statement> statements;

    public WhileStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.WhileNodeContext whileNodeContext) {
        return at(whileNodeContext.getStart(), new WhileStatement(Expression.fromContext(whileNodeContext.expr()), Statement.fromContexts(whileNodeContext.block().statement())));
    }

    /**
     * Sets the scope of this while-loop and all its statements
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        this.condition.setScope(scope);

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    /**
     * Makes a string representation of this while-loop with correct indenting and all its statements
     * @param indent - indent level of this while-loop
     * @return string representation of this while-loop
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + "while " + condition.toString(0) + " " + getComment();

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }

    /**
     * Converts this while-loop to the IR Roborovski
     *
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        While wh = new While(condition.toRoborovski(program));
        block.addStatement(wh);

        for(Statement stat : statements) {
            stat.toRoborovski(program, wh);
        }
    }

    /**
     * Makes a deep copy of this while-loop and its statements
     * @return deep copy of this while-loop
     */
    @Override
    public Statement deepCopy() {
        return new WhileStatement(condition.deepCopy(), statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
    }

    /**
     * Replaces a given type by another given type within this while-loop
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        condition.replaceType(replace, replaceWith);

        for (Statement s : statements) {
            s.replaceType(replace, replaceWith);
        }
    }

    /**
     * Finds definitions in this while-loop
     * Definition can be a function, declaration or a class.
     */
    @Override
    public void findDefinitions() {
        for(Statement stat : statements) {
            if(stat instanceof FunStatement) {
                symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof DeclStatement) {
                symbols.put(((DeclStatement) stat).getName(), (Symbol) stat);
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
     * Type checking for a while loop
     *
     * It checks whether the condition is a boolean expression,
     * as well as all statements within the while loop
     */
    @Override
    public void checkType() {
        if (condition instanceof BoolLiteralExpression) {
            if (statements != null) {
                for (Statement stat : statements) {
                    stat.checkType();
                }
            }
        }
    }
}
