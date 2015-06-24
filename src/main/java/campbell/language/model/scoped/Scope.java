package campbell.language.model.scoped;

import campbell.language.model.*;
import campbell.language.types.Type;

public abstract class Scope extends Statement implements Node {
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

    protected TypeMap<String, Type> types = new TypeMap<>();
    protected SymbolMap<String, Symbol> symbols = new SymbolMap<>();

    /**
     * plain functie
     * functie in een class voor bepaalde generieke argumenten
     *
     * structs voor class voor bepaalde generieke argumenten
     *
     */

    public abstract void findDefinitions();
    public abstract void findImpls();

    @Override
    public Type findType(String name) {
        if(types.containsKey(name)) {
            return types.get(name);
        } else if(getScope() != null) {
            return getScope().findType(name);
        } else {
            return null;
        }
    }

    @Override
    public Symbol findSymbol(String name) {
        if(symbols.containsKey(name)) {
            return symbols.get(name);
        } else if(getScope() != null) {
            return getScope().findSymbol(name);
        } else {
            return null;
        }
    }

    public String getComment() {
        String result = "# ";

        if(symbols.size() == 0) {
            if(types.size() == 0) {
                result += "(no definitions)";
            } else {
                result += "types: [";
                boolean firstClass = true;

                for(Type t : types.values()) {
                    if(!firstClass) {
                        result += ", ";
                    }

                    firstClass = false;

                    result += t.getName();
                }

                result += "]";
            }
        } else {
            if(types.size() == 0) {
                result += "symbols: [";
                boolean firstSymbol = true;

                for(Symbol s : symbols.values()) {
                    if(!firstSymbol) {
                        result += ", ";
                    }

                    firstSymbol = false;

                    result += s.getName();
                }

                result += "]";
            } else {
                result += "types: [";
                boolean firstClass = true;

                for(Type t : types.values()) {
                    if(!firstClass) {
                        result += ", ";
                    }

                    firstClass = false;

                    result += t.getName();
                }

                result += "]";

                result += "; symbols: [";
                boolean firstSymbol = true;

                for(Symbol s : symbols.values()) {
                    if(!firstSymbol) {
                        result += ", ";
                    }

                    firstSymbol = false;

                    result += s.getName();
                }

                result += "]";
            }
        }

        return result;
    }
}