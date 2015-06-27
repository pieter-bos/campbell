package sprockell;

public enum SprockellCompute {
    Add("Add"),
    Sub("Sub"),
    Mul("Mul"),
    Div("Div"),
    Mod("Mod"),
    Equal("Equal"),
    NotEqual("NEq"),
    GreaterThan("Gt"),
    LessThan("Lt"),
    GreaterThanEquals("GtE"),
    LessThanEquals("LtE"),
    And("And"),
    Or("Or"),
    Xor("Xor"),
    LShift("LShift"),
    RShift("RShift");

    private String haskell;

    SprockellCompute(String haskell) {
        this.haskell = haskell;
    }

    @Override
    public String toString() {
        return haskell;
    }
}
