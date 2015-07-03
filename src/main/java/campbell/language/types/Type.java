package campbell.language.types;

import campbell.language.model.Node;
import campbell.language.model.NotImplementedException;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Function;
import util.ListTools;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    public static Type fromContext(CampbellParser.ClassNameClassContext classNameContext) {
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

    public static Type fromContext(CampbellParser.ClassNameFuncContext funcContext) {
        List<Type> types = funcContext.className().stream().map(Type::fromContext).collect(Collectors.toList());

        List<Type> arguments = types.subList(0, types.size() - 1);
        Type returnType = types.get(types.size() - 1);

        return new FunctionType(returnType, arguments);
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

    public static Type fromContext(CampbellParser.ClassNameContext ctx) {
        if(ctx instanceof CampbellParser.ClassNameClassContext) {
            return fromContext((CampbellParser.ClassNameClassContext) ctx);
        } else if(ctx instanceof CampbellParser.ClassNameFuncContext) {
            return fromContext((CampbellParser.ClassNameFuncContext) ctx);
        }

        throw new NotImplementedException(ctx);
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
