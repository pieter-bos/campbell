package campbell.language.model.unscoped;

import campbell.language.model.CompileException;
import campbell.language.model.NotImplementedException;
import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.scoped.Scope;
import campbell.language.types.ClassType;
import campbell.language.types.GenericType;
import campbell.language.types.Type;
import campbell.parser.gen.CampbellParser;
import campbell.roborovski.model.Block;
import campbell.roborovski.model.Program;
import campbell.roborovski.model.Variable;

import java.util.LinkedList;
import java.util.List;

/**
 * Decl statement represents the declaration of a variable in Campbell
 */
public class DeclStatement extends Statement implements Symbol {
    /**
     * Type of the variable that is declared in this statement
     */
    private Type type;

    /**
     * Name of the variable that is declared in this statement
     */
    private final String name;

    /**
     * Variable form of the variable that is declared in this statement
     * This is used by IR Roborovski
     */
    private Variable variable = null;

    public DeclStatement(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Tries to parse a DeclStatement from a given context
     * @param decl
     * @return
     */
    public static DeclStatement fromContext(CampbellParser.DeclContext decl) {
        return at(decl.getStart(), new DeclStatement(Type.fromContext(decl.className()), decl.IDENTIFIER().getText()));
    }

    /**
     * Tries to parse DeclStatements from multiple given contexts
     * @param decl
     * @param javaIsStom
     * @return
     */
    public static List<DeclStatement> fromContexts(List<CampbellParser.DeclContext> decl, boolean... javaIsStom) {
        //TODO: Remove boolean javaIsStom? Or at least rename it
        List<DeclStatement> result = new LinkedList<>();
        for (CampbellParser.DeclContext i : decl) {
            result.add(fromContext(i));
        }
        return result;
    }

    /**
     * Tries to parse DeclStatements from a list of untyped statements
     * @param untypedStatements
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<? extends DeclStatement> fromContexts(List untypedStatements) {
        List<CampbellParser.DeclContext> statements = (List<CampbellParser.DeclContext>) untypedStatements;
        LinkedList<DeclStatement> result = new LinkedList<>();

        for(CampbellParser.DeclContext ctx : statements) {
            result.add(fromContext(ctx));
        }

        return result;
    }

    /**
     * Sets the scope of this declaration
     * @param scope
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * Makes a string representation of this declaration with correct indenting
     * @param indent - indent level of this declaration
     * @return string representation of this declaration
     */
    @Override
    public String toString(int indent) {
        return indent(indent) + type.toString() + " " + name;
    }

    /**
     * Converts this declaration to the IR Roborovski
     *
     * @param program
     */
    @Override
    public void toRoborovski(Program program, Block block) {
        variable = new Variable(name);
        block.addVariable(variable);
    }

    /**
     * Makes a deep copy of this declaration
     * @return deep copy of this declaration
     */
    @Override
    public DeclStatement deepCopy() {
        return new DeclStatement(type, name);
    }

    /**
     * Replaces a given type by another given type within this declaration
     *
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        if(type.getName().equals(replace.getName())) {
            type = replaceWith;
        } else {
            type.replaceType(replace, replaceWith);
        }
    }

    /**
     * Returns the name of the variable that is declared
     * @return name of declared variable
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the variable that is declared
     * @return type of declared variable
     */
    @Override
    public Type getType() {
        return type;
    }

    /**
     * Returns the Variable of the variable that is declared
     * @return Variable form of declared variable
     */
    public Variable getVariable() {
        return variable;
    }

    /**
     * Type checking of declarations
     *
     * Declarations may be of each type but if they are a class,
     * then this class should be defined
     */
    @Override
    public void checkType() {
        if (findType(type.getName()) instanceof ClassType && findType(type.getName()).getImplementation() == null && !(findType(type.getName()) instanceof GenericType)) {
            throw new NotImplementedException("Class of "+getName()+" is not implemented");
        }
    }
}
