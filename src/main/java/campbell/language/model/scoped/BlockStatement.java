package campbell.language.model.scoped;

import campbell.language.model.Statement;

import java.util.Iterator;
import java.util.List;

public class BlockStatement extends Scope implements Iterable<Statement> {
    private List<? extends Statement> statements;

    public BlockStatement(List<? extends Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void findDefinitions() {

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
    public Iterator<Statement> iterator() {
        return statements.stream().map(s -> ((Statement) s)).iterator();
    }
}
