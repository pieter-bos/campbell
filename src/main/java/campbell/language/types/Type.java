package campbell.language.types;

import campbell.parser.gen.CampbellParser;

import java.util.LinkedList;
import java.util.List;

public abstract class Type {
    public static Type fromContext(CampbellParser.ClassNameContext classNameContext) {
        if (!genericType) {
            if (primitiveType) {

            } else {
                // simple class
            }
        } else {
            // Class with generic arguments
        }
    }

    public static List<Type> fromContexts(List<CampbellParser.ClassNameContext> classNameContexts) {
        LinkedList<Type> result = new LinkedList<>();

        for(CampbellParser.ClassNameContext ctx : classNameContexts) {
            result.add(fromContext(ctx));
        }

        return result;
    }
}
