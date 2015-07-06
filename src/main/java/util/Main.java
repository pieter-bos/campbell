package util;

import campbell.language.model.CompileException;
import campbell.language.model.scoped.Program;
import sprockell.SprockellEmitter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main class of the compiler, can compile Campbell to haskell.
 */
public class Main {
    /**
     * Compiles the given file, entry point of the compiler.
     * @param args command line arguments, expects an input and output file.
     */
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: compile file.ham file.hs");
        }

        try {
            Program std = Program.parseFrom(ClassLoader.getSystemResourceAsStream("std.ham"));
            Program p = Program.parseFrom(new FileInputStream(args[0]));
            p = p.merge(std);
            p.setScope(null);
            p.findDefinitions();
            p.findImpls();
            p.checkType();

            campbell.roborovski.model.Program program = p.toRoborovski();
            program.compile(new SprockellEmitter(new FileWriter(args[1])));
        } catch(IOException e) {
            System.out.println("Something went wrong while trying to access one of the given files: " + e.getMessage());
            System.exit(1);
        } catch(CompileException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
