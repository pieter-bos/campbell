package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.ClassStatement;

import java.util.HashMap;

public abstract class Scope extends Statement {
    /**
     * Variabelen
     * Functies
     * Classes
     * Implementations
     * Traits
     *
     * Type, definitie, naam
     * find(naam) -> definitie:type
     */

    protected HashMap<String, ClassStatement> classes = new HashMap<>();
    protected HashMap<String, Symbol> symbols = new HashMap<>();

    public abstract void findDefinitions();
}