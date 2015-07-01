package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.language.types.Type;
import campbell.parser.CampbellStreamParser;
import campbell.parser.gen.CampbellParser;
import sprockell.SprockellEmitter;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Program extends Scope {
    /**
     * List containing all statements in this program
     */
    private List<? extends Statement> statements;

    public Program(List<? extends Statement> statements) {
        this.statements = statements;
    }

    public static Program fromContext(CampbellParser.ProgramContext context) {
        return at(context.getStart(), new Program(Statement.fromContexts(context.statement())));
    }

    public static Program parseFrom(InputStream input) {
        return Program.fromContext(CampbellStreamParser.parse(input));
    }

    /**
     * Sets the scope for this program and all its statements
     * @param scope - Scope of this program
     */
    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    /**
     * Makes a string representation of this program with correct indenting and all its statements
     * @param indent - indent level of this program
     * @return string representation of this program
     */
    @Override
    public String toString(int indent) {
        String result = indent(indent) + getComment();

        for(Statement stat : statements) {
            result += "\n";
            result += stat.toString(indent);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Program p = parseFrom(new FileInputStream("/home/sophie/Downloads/Campbell/campbell/badExample.ham"));
        p.setScope(null);
        p.findDefinitions();
        p.findImpls();
        p.checkType();

        System.out.println(p);

        campbell.roborovski.model.Program program = p.toRoborovski();
        program.compile(new SprockellEmitter(new FileWriter("/home/sophie/Downloads/Campbell/campbell/badExample.hs")));
    }

    /**
     * Finds definitions in this program.
     * Definition can be a function, declaration or a class.
     */
    @Override
    public void findDefinitions() {
        for(Statement stat : statements) {
            if(stat instanceof FunStatement) {
                symbols.put(((FunStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof DeclStatement) {
                symbols.put(((DeclStatement) stat).getName(), (Symbol) stat);
            } else if(stat instanceof ClassStatement) {
                types.put(((ClassStatement) stat).getType().getName(), ((ClassStatement) stat).getType());
            }

            if(stat instanceof Scope) {
                ((Scope) stat).findDefinitions();
            }
        }
    }

    /**
     * Finds implementations in this scope
     */
    @Override
    public void findImpls() {
        for(Statement stat : statements) {
            if(stat instanceof Scope) {
                ((Scope) stat).findImpls();
            }
        }
    }

    /**
     * Converts this program to the IR Roborovski
     * @param program
     * @param block
     */
    @Override
    public void toRoborovski(campbell.roborovski.model.Program program, campbell.roborovski.model.Block block) {
        /**
         * ClassStatement -> functies en een struct
         * ForStatement -> compilet naar een while
         * FunStatement -> functies
         * If -> compilet naar een if
         * Program -> block
         * Unsafe -> block
         * While -> compilet naar een while, block
         * Assign
         * Return
         * Expressions
         */

        for(Statement statement : statements) {
            statement.toRoborovski(program, block);
        }
    }

    /**
     * Makes a deep copy of this program
     * @return deep copy of this program
     */
    @Override
    public Statement deepCopy() {
        return new Program(statements.stream().map(Statement::deepCopy).collect(Collectors.toList()));
    }

    /**
     * Replaces a given type by another given type within this program
     * @param replace - type that should be replaced
     * @param replaceWith - replacement type
     */
    @Override
    public void replaceType(Type replace, Type replaceWith) {
        for (Statement s : statements) {
            s.replaceType(replace, replaceWith);
        }
    }

    /**
     * Type checking for a program
     */
    @Override
    public void checkType() {
        if (statements != null) {
            for (Statement stat : statements) {
                stat.checkType();
            }
        }
    }
}