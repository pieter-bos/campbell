package campbell.roborovski.model;

public class If extends Statement {
    private final Expression condition;
    private final Block thenBlock;
    private final Block elseBlock;

    public If(Expression condition, Block thenBlock, Block elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }
}
