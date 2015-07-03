package campbell.roborovski.model;

import java.util.LinkedList;

/**
 * Struct, block of memory, (compound type) in Roborovski
 */
public class Struct {
    /**
     * Variables in struct
     */
    private final LinkedList<Variable> variables = new LinkedList<>();

    /**
     * Add given variable to the struct
     * @param var
     */
    public void addVariable(Variable var) {
        variables.add(var);
    }

    /**
     * Returns the offset of this struct
     * @param varName
     * @return
     */
    public int getOffset(String varName) {
        int current = 0;

        for(Variable var : variables) {
            if(var.getName().equals(varName)) {
                return current;
            } else {
                current += var.getSize();
            }
        }

        throw new RuntimeException("Internal error: Unknown variable " + varName + " in struct");
    }

    /**
     * Returns the number of instructions for this struct
     * @return
     */
    public int getSize() {
        int size = 0;

        for(Variable var : variables) {
            size += var.getSize();
        }

        return size;
    }
}
