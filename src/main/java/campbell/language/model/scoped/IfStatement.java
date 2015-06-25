package campbell.language.model.scoped;

import campbell.language.model.unscoped.Expression;
import campbell.language.model.Statement;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.*;
import campbell.roborovski.model.Program;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IfStatement extends Scope {
    private final Expression condition;
    private final BlockStatement statements;
    private final BlockStatement elseStatements;

    public IfStatement(Expression condition, List<? extends Statement> statements) {
        this.condition = condition;
        this.statements = new BlockStatement(statements);
        this.elseStatements = null;
    }

    public IfStatement(Expression condition, List<? extends Statement> statements, List<? extends Statement> elseStatements) {
        this.condition = condition;
        this.statements = new BlockStatement(statements);
        this.elseStatements = new BlockStatement(elseStatements);
    }

    public static IfStatement fromContext(CampbellParser.IfNodeContext ifNodeContext) {
        Expression condition = Expression.fromContext(ifNodeContext.expr());
        List<? extends Statement> block1 = fromContexts(ifNodeContext.block(0).statement());

        if (ifNodeContext.block().size() != 1) {
            return new IfStatement(condition, block1, fromContexts(ifNodeContext.block(1).statement()));
        } else {
            return new IfStatement(condition, block1);
        }
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
        this.condition.setScope(scope);

        statements.setScope(scope);

        if (elseStatements != null) {
            elseStatements.setScope(scope);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "if " + condition.toString(0) + "\n";

        result += statements.toString(indent + 1);

        if(elseStatements != null) {
            result += "\n" + indent(indent) + "else" + "\n";
            result += elseStatements.toString(indent + 1);
        }

        return result;
    }

    @Override
    public void toRoborovski(Program program, Block block) {
        Block ifBlock = new Block();
        Block elseBlock = new Block();

        statements.toRoborovski(program, ifBlock);

        if(elseStatements != null) {
            elseStatements.toRoborovski(program, elseBlock);
        }

        block.addStatement(new If(condition.toRoborovski(), ifBlock, elseBlock));
    }

    @Override
    public IfStatement deepCopy() {
        if(elseStatements == null) {
            return new IfStatement(condition.deepCopy(),
                    StreamSupport.stream(statements.spliterator(), true).collect(Collectors.toList()));
        } else {
            return new IfStatement(condition.deepCopy(),
                    StreamSupport.stream(statements.spliterator(), true).collect(Collectors.toList()),
                    StreamSupport.stream(elseStatements.spliterator(), true).collect(Collectors.toList()));
        }
    }

    @Override
    public void replaceType(Type replace, Type replaceWith) {
        condition.replaceType(replace, replaceWith);

        for (Statement stat : statements) {
            stat.replaceType(replace, replaceWith);
        }

        if (elseStatements != null) {
            for (Statement stat : elseStatements) {
                stat.replaceType(replace, replaceWith);
            }
        }
    }

    @Override
    public void findDefinitions() {
        statements.findDefinitions();

        if(elseStatements != null) {
            elseStatements.findDefinitions();
        }
    }

    @Override
    public void findImpls() {
        statements.findImpls();

        if(elseStatements != null) {
            elseStatements.findImpls();
        }
    }
}
