package campbell.language.model.scoped;

import campbell.language.model.*;
import campbell.language.types.Type;

/**
 * Scope represents a new scope in a Campbell program
 * It reminds what types and symbols can be found in this scope
 */
public abstract class Scope extends Statement implements Node {
    /**
     * Map containing all types in this scope
     */
    protected TypeMap<String, Type> types = new TypeMap<>();

    /**
     * Map containing all symbols in this scope
     */
    protected SymbolMap<String, Symbol> symbols = new SymbolMap<>();

    /**
     * Method to find definitions in a scope
     * Definition can be a function, declaration or class
     */
    public abstract void findDefinitions();

    /**
     * Method to find implementations in a scope
     */
    public abstract void findImpls();

    /**
     * Method to find type of a given name in this scope
     * @param name - Name of which the type should be found
     * @return type of the given name
     */
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

    /**
     * Method to find symbol of a given name in this scope
     * @param name - Name of which the symbol should be found
     * @return symbol of the given name
     */
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

    /**
     * Returns the comment of this scope which describes the symbols and types of this scope
     * @return string representation of this scope's symbols and types
     */
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