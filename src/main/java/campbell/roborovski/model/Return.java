package campbell.roborovski.model;

public class Return extends Statement {
    private Expression value;

    public Return(Expression value) {
        this.value = value;
    }
}
