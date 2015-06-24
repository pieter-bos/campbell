package campbell.language.model.scoped;

import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.model.unscoped.Expression;
import campbell.language.model.Statement;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class WhileStatement extends Scope {
    private final Expression condition;
    private final List<? extends Statement> statements;

    public WhileStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.WhileNodeContext whileNodeContext) {
        return at(whileNodeContext.getStart(), new WhileStatement(Expression.fromContext(whileNodeContext.expr()), Statement.fromContexts(whileNodeContext.block().statement())));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        this.condition.setScope(scope);

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "while " + condition.toString(0) + " " + getComment();

        for(Statement stat : statements) {
            result += "\n" + stat.toString(indent + 1);
        }

        return result;
    }

    @Override
    public void findDefinitions() {
        for(Statement stat : statements) {
            if(stat instanceof FunStatement) {
                symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof DeclStatement) {
                symbols.put(((DeclStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof ClassStatement) {
                classes.put(((ClassStatement) stat).getType().getName(), (ClassStatement) stat);
            }

            if(stat instanceof Scope) {
                ((Scope) stat).findDefinitions();
            }
        }
    }
}
