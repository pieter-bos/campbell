package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.types.Type;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BlockStatement extends Scope implements Iterable<Statement> {
    private List<? extends Statement> statements;

    public BlockStatement(List<? extends Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void findDefinitions() {

    }

    @Override
    public void findImpls() {
        for(Statement stat : statements) {
            if(stat instanceof Scope) {
                ((Scope) stat).findImpls();
            }
        }
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for(Statement stat : statements) {
            stat.setScope(scope);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + getComment();

        for(Statement stat : statements) {
            result += "\n";
            result += stat.toString(indent);
        }

        return result;
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        Block innerBlock = new Block();

        block.addStatement(innerBlock);

        for(Statement stat : statements) {
            stat.toRoborovski(program, innerBlock);
        }
    }

    @Override
    public BlockStatement deepCopy() {
        return new BlockStatement(statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        for(Statement stat : statements) {
            stat.replaceType(replace, replaceWith);
        }
    }

    @Override
    public Iterator<Statement> iterator() {
        return statements.stream().map(s -> ((Statement) s)).iterator();
    }
}
