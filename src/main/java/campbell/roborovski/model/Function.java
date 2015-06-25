package campbell.roborovski.model;

import java.util.LinkedList;
import java.util.List;

public class Function extends Block {
    private List<Variable> arguments = new LinkedList<>();

    public void addArgument(Variable arg) {
        arguments.add(arg);
    }
}
