package campbell.language.model.scoped;

import campbell.language.model.Statement;
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
        String result = "";
        boolean firstStatement = true;

        for(Statement stat : statements) {
            if(!firstStatement) {
                result += "\n";
            }

            firstStatement = false;

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
    }
}