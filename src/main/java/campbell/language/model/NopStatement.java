package campbell.language.model;

import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

public class NopStatement extends Statement {
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "nop";
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        // nop!
    }

    @Override
    public Statement deepCopy() {
        return new NopStatement();
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        // nop
    }

    @Override
    public boolean returns() {
        return false;
    }

    @Override
    public void checkType() {
        // nop
    }

    public static Statement fromContext(CampbellParser.NopContext nop) {
        return new NopStatement();
    }
}
