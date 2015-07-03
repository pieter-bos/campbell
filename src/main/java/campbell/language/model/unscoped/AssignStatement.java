package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.Statement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Assign;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

/**
 * Assign statement represents an assignment in Campbell
 */
public class AssignStatement extends Statement {
    /**
     * Expression representing left side of the assignment
     */
    private final Expression left;

    /**
     * Expression representing right side of the assignment
     */
    private final Expression right;

    public AssignStatement(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Tries to parse an AssignStatement from a given context
     * @param assign
     * @return
     */
    public static AssignStatement fromContext(CampbellParser.AssignContext assign) {
        // TODO nested assignment/declaration
        return at(assign.getStart(), new AssignStatement(Expression.fromContext(assign.expr(0)), Expression.fromContext(assign.expr(1))));
    }

    /**
     * Sets the scope of this assignment and its expressions
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        left.setScope(scope);
        right.setScope(scope);
    }

    /**
     * Makes a string representation of this assignment with correct indenting
     * @param indent - indent level of this assignment
     * @return string representation of this assignment
     */
    @Override
    public String toString(int indent) {
        return left.toString(indent) + " = " + right.toString(0);
    }

    /**
     * Converts this assignment to the IR Roborovski
     *
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        block.addStatement(new Assign(left.toRoborovski(program), right.toRoborovski(program)));
    }

    /**
     * Makes a deep copy of this assignment
     * @return deep copy of this assignment
     */
    @Override
    public AssignStatement deepCopy() {
        return new AssignStatement(left.deepCopy(), right.deepCopy());
    }

    /**
     * Replaces a given type by another given type within this assignment
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        left.replaceType(replace, replaceWith);
        right.replaceType(replace, replaceWith);
    }

    /**
     * Method that checks whether this assignment returns
     *
     * Assignments never return
     * @return
     */
    @Override
    public boolean returns() {
        return false;
    }

    /**
     * Type checking for assignments
     *
     * The left side of the assignment must be of the same type as the right side of the expression
     */
    @Override
    public void checkType() {
        if (hasDef(left) && !left.getType().equals(right.getType())) {
            throw new CompileException(this, "Type error: left expression is of type "+left.getType()+" whereas right is of type "+ right.getType());
        }
    }

    /**
     * Tries to find definition of a given expression
     *
     * Used for type checking
     * @param expr
     * @return
     */
    private boolean hasDef(Expression expr) {
        Scope s = getScope();
        while (s == null || (s.findSymbol(expr.toString()) == null  && s.findType(expr.toString()) == null)) {
            if (s == null) {
                throw new CompileException(this, "No definition of " + expr.toString() + " can be found");
            } else {
                s = s.getScope();
            }
        }
        return true;
    }
}
