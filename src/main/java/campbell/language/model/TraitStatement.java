package campbell.language.model;

import campbell.language.types.ClassType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;

import java.util.List;

public class TraitStatement extends Scope {
    private final Type type;
    private final List<? extends Type> of;
    private final List<? extends Statement> statements;

    public TraitStatement(Type type, List<? extends Statement> statements) {
        this.type = type;
        this.of = null;
        this.statements = statements;
    }

    public TraitStatement(Type type, List<? extends Type> of, List<? extends Statement> statements) {
        this.type = type;
        this.of = of;
        this.statements = statements;
    }

    public static Statement fromContext(CampbellParser.TraitContext trait) {
        Type type = Type.fromContext(trait.className());
        List<? extends Statement> statements = Statement.fromContexts(trait.block().statement());

        if(trait.classList() != null) {
            List<Type> of = Type.fromContexts(trait.classList().className());
            return new TraitStatement(type, of, statements);
        } else {
            return new TraitStatement(type, statements);
        }
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + "trait " + type.toString();

        if(of != null) {
            result += " of ";

            if(of.size() == 1) {
                result += of.get(0).toString();
            } else {
                result += "(";

                boolean firstType = true;

                for(Type t : of) {
                    if(!firstType) {
                        result += ", ";
                    }

                    firstType = false;

                    result += t.toString();
                }

                result += ')';
            }
        }

        for(Statement stat : statements) {
            result += "\n"  + stat.toString(indent + 1);
        }

        return result;
    }
}
