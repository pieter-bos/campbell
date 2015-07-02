package sprockell;

/**
 * Enum containing all registers that can be used in SprIl/Sprockell
 */
public enum SprockellRegister {
    zero("Zero"),
    pc("PC"),
    sp("SP"),
    spid("SPID"),
    a("RegA"),
    b("RegB"),
    c("RegC"),
    d("RegD"),
    e("RegE");

    /**
     * Haskell code used for these registers
     */
    private final String haskell;

    SprockellRegister(String haskell) {
        this.haskell = haskell;
    }

    /**
     * Returns string representation of this register
     * @return
     */
    @Override
    public String toString() {
        return haskell;
    }
}
