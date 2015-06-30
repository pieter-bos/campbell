package campbell.language.model.unscoped;

import campbell.language.model.Statement;
import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Haskell;
import campbell.roborovski.model.Program;

public class HaskellStatement extends Statement {
    private String haskell;

    public HaskellStatement(String haskell) {
        this.haskell = haskell;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "\\" + haskell;
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        block.addStatement(new Haskell(haskell));
    }

    @Override
    public Statement deepCopy() {
        return null;
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {

    }

    public static HaskellStatement fromContext(CampbellParser.HaskellContext ctx) {
        return new HaskellStatement(ctx.HASKELL().getText());
    }
}
