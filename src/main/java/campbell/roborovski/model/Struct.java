package campbell.roborovski.model;

import java.util.LinkedList;

public class Struct {
    private final LinkedList<Variable> variables = new LinkedList<>();

    public void addVariable(Variable var) {
        variables.add(var);
    }
}
