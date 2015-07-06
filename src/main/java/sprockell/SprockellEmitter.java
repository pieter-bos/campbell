package sprockell;

import java.io.IOException;
import java.io.Writer;

/**
 * Class that emits SprIl/Sprockell
 */
public class SprockellEmitter {
    /**
     * Beginning, Prelude, of each generated Haskell program
     */
    private static final String PRELUDE = "import Sprockell.System\n\nprog = [Nop,\n    ";

    /**
     * Ending, Epilogue, of each generated Haskell program
     */
    private static final String EPILOGUE = "EndProg]\n\nmain = run %d prog";

    /**
     * Writer
     */
    private final Writer writer;

    /**
     * Where to write
     */
    private int loc = 1;

    /**
     * Number of cores to be used
     */
    private int cores = 1;

    public SprockellEmitter(Writer writer) throws IOException {
        this.writer = writer;
        write(PRELUDE);
    }

    /**
     * Writes a given String
     * @param s - What to write
     * @throws IOException
     */
    private void write(String s) throws IOException {
        writer.write(s.toCharArray());
    }

    /**
     * When done with writing instructions,
     * This is executed to end the compiled Haskell file correctly and close the writer
     * @throws IOException
     */
    public void close() throws IOException {
        write(String.format(EPILOGUE, cores));
        writer.close();
    }

    /**
     * Emits a computation expression
     * @param op - operand to be executed on left and right
     * @param left - register
     * @param right - register
     * @param dest - destination register
     * @param comments - possible comments
     * @throws IOException
     */
    public void compute(SprockellCompute op, SprockellRegister left, SprockellRegister right, SprockellRegister dest, String... comments) throws IOException {
        emit("Compute", comments, op, left, right, dest);
    }

    /**
     * Emits a constant
     * @param value - value to be stored
     * @param reg - register where value should be stored
     * @param comments - possible comments
     * @throws IOException
     */
    public void emitConst(int value, SprockellRegister reg, String... comments) throws IOException {
        emit("Const", comments, value, reg);
    }

    /**
     * Emits a Load instruction
     * @param address - where to load from
     * @param reg - in which register to store
     * @param comments - possible comments
     * @throws IOException
     */
    public void load(int address, SprockellRegister reg, String... comments) throws IOException {
        emit("Load", comments, "(Addr " + address + ")", reg);
    }

    /**
     * Emits a load instruction for a local or shared memory address
     * @param address - register to get memory address from
     * @param reg - in which register to store
     * @param comments - possible comments
     * @throws IOException
     */
    public void load(SprockellRegister address, SprockellRegister reg, String... comments) throws IOException {
        emit("Load", comments, "(Deref " + address + ")", reg);
    }

    /**
     * Emits a store instruction
     * @param reg - where to get value from
     * @param address - where to store value
     * @param comments - possible comments
     * @throws IOException
     */
    public void store(SprockellRegister reg, int address, String... comments) throws IOException {
        emit("Store", comments, reg, "(Addr " + address + ")");
    }

    /**
     * Emits a store instruction for a local or shared memory address
     * @param reg - register to get memory address from
     * @param address - where to store value
     * @param comments - possible comments
     * @throws IOException
     */
    public void store(SprockellRegister reg, SprockellRegister address, String... comments) throws IOException {
        emit("Store", comments, reg, "(Deref " + address + ")");
    }

    /**
     * Emits an absolute branch
     * @param cond - register in which condition is stored
     * @param address - where to jump to (absolute address)
     * @param comments - possible comments
     * @throws IOException
     */
    public void branchAbsolute(SprockellRegister cond, int address, String... comments) throws IOException {
        emit("Branch", comments, cond, "(Abs " + address + ")");
    }

    /**
     * Emits a relative branch
     * @param cond - register in which condition is stored
     * @param jump - where to jump to (relative jump)
     * @param comments - possible comments
     * @throws IOException
     */
    public void branchRelative(SprockellRegister cond, int jump, String... comments) throws IOException {
        emit("Branch", comments, cond, "(Rel (" + jump + "))");
    }

    /**
     * Emits a branch to instruction number
     * @param cond - register in which condition is stored
     * @param reg - register where instruction number is stored
     * @param comments - possible comments
     * @throws IOException
     */
    public void branch(SprockellRegister cond, SprockellRegister reg, String... comments) throws IOException {
        emit("Branch", comments, cond, "(Ind " + reg + ")");
    }

    /**
     * Emits an absolute jump
     * @param address - address to jump to
     * @param comments - possible comments
     * @throws IOException
     */
    public void jumpAbsolute(int address, String... comments) throws IOException {
        emit("Jump", comments, "(Abs " + address + ")");
    }

    /**
     * Emits a relative jump
     * @param jump - where to jump to (relative)
     * @param comments - possible comments
     * @throws IOException
     */
    public void jumpRelative(int jump, String... comments) throws IOException {
        emit("Jump", comments, "(Rel (" + jump + "))");
    }

    /**
     * Emits a jump to an instruction number
     * @param reg - register where instruction number is stored
     * @param comments - possible comments
     * @throws IOException
     */
    public void jump(SprockellRegister reg, String... comments) throws IOException {
        emit("Jump", comments, "(Ind " + reg + ")");
    }

    /**
     * Emits a push instruction
     * @param reg - register which contains the value to push
     * @param comments - possible comments
     * @throws IOException
     */
    public void push(SprockellRegister reg, String... comments) throws IOException {
        emit("Push", comments, reg);
    }

    /**
     * Emits a pop instruction
     * @param reg - register where to store the result
     * @param comments - possible comments
     * @throws IOException
     */
    public void pop(SprockellRegister reg, String... comments) throws IOException {
        emit("Pop", comments, reg);
    }

    /**
     * Emits a nop instruction
     * @param comments - possible comments
     * @throws IOException
     */
    public void nop(String... comments) throws IOException {
        emit("Nop", comments);
    }

    /**
     * Emits a read from memory address
     * @param address - address to read from
     * @param comments - possible comments
     * @throws IOException
     */
    public void read(int address, String... comments) throws IOException {
        emit("Read", comments, "(Addr " + address + ")");
    }

    /**
     * Emits a read from register where memory address is stored
     * @param address - register to read memory address from
     * @param comments - possible comments
     * @throws IOException
     */
    public void read(SprockellRegister address, String... comments) throws IOException {
        emit("Read", comments, "(Deref " + address + ")");
    }

    /**
     * Emits a receive instruction
     * @param reg - register where to store the result
     * @param comments - possible comments
     * @throws IOException
     */
    public void receive(SprockellRegister reg, String... comments) throws IOException {
        emit("Receive", comments, reg);
    }

    /**
     * Emits a write instruction to memory address
     * @param reg - register that contains what to write
     * @param address - memory address where to write to
     * @param comments - possible comments
     * @throws IOException
     */
    public void write(SprockellRegister reg, int address, String... comments) throws IOException {
        emit("Write", comments, reg, "(Addr " + address + ")");
    }

    /**
     * Emits a write instruction to memory address that is stored in a register
     * @param reg - register that contains what to write
     * @param address - register that contains memory address where to write to
     * @param comments - possible comments
     * @throws IOException
     */
    public void write(SprockellRegister reg, SprockellRegister address, String... comments) throws IOException {
        emit("Write", comments, reg, "(Deref " + address + ")");
    }

    /**
     * Emits a testAndSet instruction for memory address
     * @param address - memory address to test and set
     * @param comments - possible comments
     * @throws IOException
     */
    public void testAndSet(int address, String... comments) throws IOException {
        emit("TestAndSet", comments, "(Addr " + address + ")");
    }

    /**
     * Emits a testAndSet instruction for memory address that is stored in a register
     * @param address - register that contains memory address to test and set
     * @param comments - possible comments
     * @throws IOException
     */
    public void testAndSet(SprockellRegister address, String... comments) throws IOException {
        emit("TestAndTest", comments, "(Deref " + address + ")");
    }

    /**
     * Emits raw Haskell
     * @param instruction - Haskell code to be emitted
     * @throws IOException
     */
    public void emitRaw(String instruction) throws IOException {
        emit(instruction, new String[] { "Raw Haskell" });
    }

    /**
     * Emits a given instruction with possible comments and its operands
     * @param instruction
     * @param comments
     * @param operands
     * @throws IOException
     */
    private void emit(String instruction, String[] comments, Object... operands) throws IOException {
        write("-- " + (loc++));
        write("\n    ");

        write(instruction);

        for(Object operand : operands) {
            write(" ");

            if(operand instanceof Integer) {
                write("(" + operand.toString() + ")");
            } else {
                write(operand.toString());
            }
        }

        write(",");

        if(comments.length > 0) {
            write(" --");

            for(String comment : comments) {
                write(" " + comment);
            }
        }

        write("\n    ");
    }

    /**
     * Returns the location
     * @return
     */
    public int getLoc() {
        return loc;
    }

    /**
     * Sets the number of cores to be used
     * @param cores
     */
    public void setCores(int cores) {
        this.cores = cores;
    }
}
