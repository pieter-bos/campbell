package campbell.roborovski.model;

import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Program representation in Roborovski
 */
public class Program extends Block {
    /**
     * Memory location that points to a location which tells you from where you can start with allocating
     */
    public static final int NEW = 0;

    /**
     * List containing all functions of the program
     */
    private List<Function> functions = new LinkedList<>();

    /**
     * List containing all structs of the program
     */
    private List<Struct> structs = new LinkedList<>();

    private List<Variable> sharedVariables = new LinkedList<>();

    /**
     * Used if a new unique variable is needed
     */
    private int internalNameNo = 0;
    private int cores = 1;

    /**
     * Add a function to this program
     * @param func
     */
    public void addFunction(Function func) {
        functions.add(func);
        func.superBlock = this;
    }

    /**
     * Add a struct to this program
     * @param struct
     */
    public void addStruct(Struct struct) {
        structs.add(struct);
    }

    /**
     * Get a new unique variable
     *
     * It is unique because lines in Campbell that start with '#' are ignored in an earlier stage,
     * This is because comments start with '#'
     * @return
     */
    public String newInternalName() {
        return "#" + (internalNameNo++);
    }

    /**
     * Calculates the offsets of all functions in this program and its super block
     */
    @Override
    public void calcOffsets() {
        super.calcOffsets();

        for(Function func : functions) {
            func.calcOffsets();
        }

        int position = 0;

        for(Variable var : sharedVariables) {
            var.setOffset(position);
            position += var.getSize();
        }
    }

    /**
     * Generates SprIl/Sprockell code for this program
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.setCores(cores);

        // Calculate variable offsets recursively
        calcOffsets();

        // Calculate code offsets recursively
        setOffset(1);

        // Calculate value spills recursively
        calcSpill();

        for(Function func : functions) {
            func.calcSpill();
        }

        start(emitter);

        // Initialize heap
        emitter.emitConst(NEW + 1, SprockellRegister.a);
        emitter.store(SprockellRegister.a, NEW);
        emitter.emitConst(0, SprockellRegister.sp);

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

    /**
     * Sets the offsets of this program, its functions and its super block
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        int current = offset + 4;

        for(Function function : functions) {
            function.setOffset(current);
            current += function.getSize();
        }

        this.offset = current;

        super.setOffset(current);
    }

    /**
     * Returns the number of instructions for this program
     * @return
     */
    @Override
    public int getSize() {
        int size = 4;

        for(Function function : functions) {
            size += function.getSize();
        }

        return size + super.getSize();
    }

    public void addSharedVariable(Variable var) {
        sharedVariables.add(var);
    }

    public void setCores(int cores) {
        this.cores = cores;
    }
}