package campbell.language.model;

import campbell.language.types.Type;

/**
 * Symbol is a node in the AST with a name and type
 */
public interface Symbol extends Node {
    String getName();
    Type getType();
}
