package campbell.roborovski.model;

public class VariableExpression extends Expression {
    private Variable var;

    public VariableExpression(Variable var) {
        this.var = var;
    }
}
