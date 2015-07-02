package sprockell;

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

    private final String haskell;

    SprockellRegister(String haskell) {
        this.haskell = haskell;
    }

    @Override
    public String toString() {
        return haskell;
    }
}
