package campbell.roborovski.model;


import java.util.LinkedList;

public class While extends Block {
    private final Expression condition;

    public While(Expression condition) {
        this.condition = condition;
    }
}
