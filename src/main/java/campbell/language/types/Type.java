package campbell.language.types;

import campbell.language.model.Node;
import campbell.parser.gen.CampbellParser;

import java.util.LinkedList;
import java.util.List;

/**
 * Type is an enveloping abstract class for all types
 */
public abstract class Type {
    /**
     * Implementation of the type
     */
    private Node implementation = null;

    /**
     * Tries to parse a Type from a given context
     * @param classNameContext
     * @return
     */
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

    /**
     * Tries to parse multiple types from a list of contexts
     * @param classNameContexts
     * @return
     */
    public static List<Type> fromContexts(List<CampbellParser.ClassNameContext> classNameContexts) {
        LinkedList<Type> result = new LinkedList<>();

        for(CampbellParser.ClassNameContext ctx : classNameContexts) {
            result.add(fromContext(ctx));
        }

        return result;
    }

    /**
     * Abstract method for returning the name of the type
     * @return
     */
    public abstract String getName();

    /**
     * Abstract method for replacing types
     * @param replace
     * @param replaceWith
     */
    public abstract void replaceType(Type replace, Type replaceWith);

    /**
     * Returns the implementation of the type
     * @return
     */
    public Node getImplementation() {
        return implementation;
    }

    /**
     * Sets the implementation of the type
     * @param implementation
     */
    public void setImplementation(Node implementation) {
        this.implementation = implementation;
    }
}
