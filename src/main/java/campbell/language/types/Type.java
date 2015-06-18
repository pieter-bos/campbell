package campbell.language.types;

import campbell.parser.gen.CampbellParser;

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
}
