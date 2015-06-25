package campbell.roborovski.model;

import java.util.LinkedList;
import java.util.List;

public class Block extends Statement {
    private List<Variable> variables = new LinkedList<>();
    private List<Statement> statements = new LinkedList<>();

    public void addVariable(Variable var) {
        variables.add(var);
    }

    public void addStatement(Statement stat) {
        statements.add(stat);
    }
}
