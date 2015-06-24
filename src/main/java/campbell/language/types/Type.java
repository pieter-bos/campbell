package campbell.language.types;

import campbell.language.model.Node;
import campbell.language.model.scoped.ClassStatement;
import campbell.parser.gen.CampbellParser;

import java.util.LinkedList;
import java.util.List;

public abstract class Type {
    private Node implementation = null;

    public static Type fromContext(CampbellParser.ClassNameContext classNameContext) {
        String id = classNameContext.IDENTIFIER().getText();

        if(classNameContext.className().size() == 0) {
            if(PrimitiveType.isPrimitive(id)) {
                return PrimitiveType.fromId(id);
            } else {
                return new ClassType(id, new LinkedList<>());
            }
        } else {
            return new ClassType(id, fromContexts(classNameContext.className()));
        }
    }

    public static List<Type> fromContexts(List<CampbellParser.ClassNameContext> classNameContexts) {
        LinkedList<Type> result = new LinkedList<>();

        for(CampbellParser.ClassNameContext ctx : classNameContexts) {
            result.add(fromContext(ctx));
        }

        return result;
    }

    public abstract String getName();

    public Node getImplementation() {
        return implementation;
    }

    public void setImplementation(Node implementation) {
        this.implementation = implementation;
    }
}
