package sprockell;

/**
 * Enum containing all operators that can be used in Sprockell
 */
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

    /**
     * Haskell code used for this computation
     */
    private String haskell;

    SprockellCompute(String haskell) {
        this.haskell = haskell;
    }

    /**
     * Returns a string representation of the Haskell code
     * @return
     */
    @Override
    public String toString() {
        return haskell;
    }
}
