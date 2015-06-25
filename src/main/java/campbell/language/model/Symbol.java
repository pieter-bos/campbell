package campbell.language.model;

import campbell.language.types.Type;

public interface Symbol extends Node {
    String getName();
    Type getType();
}
