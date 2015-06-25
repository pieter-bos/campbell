package campbell.roborovski.model;

import java.util.LinkedList;
import java.util.List;

public class Program extends Block {
    private List<Function> functions = new LinkedList<>();
    private List<Struct> structs = new LinkedList<>();
    private int internalNameNo = 0;

    public void addFunction(Function func) {
        functions.add(func);
    }

    public void addStruct(Struct struct) {
        structs.add(struct);
    }

    public String newInternalName() {
        return "#" + (internalNameNo++);
    }
}
