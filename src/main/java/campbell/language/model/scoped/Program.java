package campbell.language.model.scoped;

import campbell.language.model.Statement;
import campbell.language.model.Symbol;
import campbell.language.model.unscoped.DeclStatement;
import campbell.parser.CampbellStreamParser;
import campbell.parser.gen.CampbellParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class Program extends Scope {
    private List<? extends Statement> statements;

    public Program(List<? extends Statement> statements) {
        this.statements = statements;
    }

    public static Program fromContext(CampbellParser.ProgramContext context) {
        return at(context.getStart(), new Program(Statement.fromContexts(context.statement())));
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;

        for (Statement s : statements) {
            s.setScope(this);
        }
    }

    @Override
    public String toString(int indent) {
        String result = indent(indent) + getComment();

        for(Statement stat : statements) {
            result += "\n";
            result += stat.toString(indent);
        }

        return result;
    }

    public static Program parseFrom(InputStream input) {
        return Program.fromContext(CampbellStreamParser.parse(input));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Program p = parseFrom(new FileInputStream("/home/pieter/programming/haskell/campbell/example.ham"));
        p.setScope(null);
        p.findDefinitions();
        p.findImpls();
        System.out.println(p);
    }

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

    @Override
    public void findImpls() {
        for(Statement stat : statements) {
            if(stat instanceof Scope) {
                ((Scope) stat).findImpls();
            }
        }
    }

    public void toRoborovski(campbell.roborovski.model.Program program) {

    }
}