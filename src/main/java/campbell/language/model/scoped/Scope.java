package campbell.language.model.scoped;

import campbell.language.model.Node;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.SymbolMap;

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

    protected SymbolMap<String, ClassStatement> classes = new SymbolMap<>();
    protected SymbolMap<String, Symbol> symbols = new SymbolMap<>();

    public abstract void findDefinitions();

    @Override
    public ClassStatement findClass(String name) {
        if(classes.containsKey(name)) {
            return classes.get(name);
        } else if(getScope() != null) {
            return getScope().findClass(name);
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
            if(classes.size() == 0) {
                result += "(no definitions)";
            } else {
                result += "classes: [";
                boolean firstClass = true;

                for(ClassStatement cls : classes.values()) {
                    if(!firstClass) {
                        result += ", ";
                    }

                    firstClass = false;

                    result += cls.getName();
                }

                result += "]";
            }
        } else {
            if(classes.size() == 0) {
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
                result += "classes: [";
                boolean firstClass = true;

                for(ClassStatement cls : classes.values()) {
                    if(!firstClass) {
                        result += ", ";
                    }

                    firstClass = false;

                    result += cls.getName();
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