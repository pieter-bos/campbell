package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Program extends Block {
    public static final int NEW = 0;

    private List<Function> functions = new LinkedList<>();
    private List<Struct> structs = new LinkedList<>();
    private int internalNameNo = 0;

    public void addFunction(Function func) {
        functions.add(func);
        func.superBlock = this;
    }

    public void addStruct(Struct struct) {
        structs.add(struct);
    }

    public String newInternalName() {
        return "#" + (internalNameNo++);
    }

    @Override
    public void calcOffsets() {
        super.calcOffsets();

        for(Function func : functions) {
            func.calcOffsets();
        }
    }

    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        // Calculate variable offsets recursively
        calcOffsets();

        // Calculate code offsets recursively
        setOffset(1);

        start(emitter);

        // Initialize heap
        emitter.emitConst(NEW + 1, SprockellRegister.a);
        emitter.store(SprockellRegister.a, NEW);

        // Jump to start of program
        emitter.jumpAbsolute(getOffset());

        // Compile all functions
        for(Function func : functions) {
            func.compile(emitter, this);
        }

        // Compile the program code
        super.compile(emitter, this);

        end(emitter);

        System.out.println("Program size is " + getSize());
    }

    @Override
    public void setOffset(int offset) {
        int current = offset + 3;

        for(Function function : functions) {
            function.setOffset(current);
            current += function.getSize();
        }

        this.offset = current;

        super.setOffset(current);
    }

    @Override
    public int getSize() {
        int size = 3;

        for(Function function : functions) {
            size += function.getSize();
        }

        return size + super.getSize();
    }
}