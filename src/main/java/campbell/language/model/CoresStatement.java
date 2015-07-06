package campbell.language.model;

import campbell.language.model.scoped.Scope;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;

public class CoresStatement extends Statement {
    private int cores;

    public CoresStatement(int cores) {
        this.cores = cores;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString(int indent) {
        return indent(indent) + "threads " + cores;
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        program.setCores(cores);
    }

    @Override
    public Statement deepCopy() {
        return new CoresStatement(cores);
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
        if(cores < 1) {
            throw new CompileException(this, "The number of concurrent threads must be one or larger.");
        }
    }

    public static CoresStatement fromContext(CampbellParser.CoresContext ctx) {
        return new CoresStatement(Integer.valueOf(ctx.INT().getText()));
    }
}
