package sprockell;

import java.io.IOException;
import java.io.Writer;

public class SprockellEmitter {
    private static final String PRELUDE = "import Sprockell.System\n\nprog = [Nop";
    private static final String EPILOGUE = ", EndProg]\n\nmain = run 1 prog";
    private final Writer writer;

    public SprockellEmitter(Writer writer) throws IOException {
        this.writer = writer;
        write(PRELUDE);
    }

    private void write(String s) throws IOException {
        writer.write(s.toCharArray());
    }

    public void close() throws IOException {
        write(EPILOGUE);
        writer.close();
    }

    public void compute(SprockellCompute op, SprockellRegister left, SprockellRegister right, SprockellRegister dest) throws IOException {
        emit("Compute", op, left, right, dest);
    }

    public void emitConst(int value, SprockellRegister reg) throws IOException {
        emit("Const", value, reg);
    }

    public void load(int address, SprockellRegister reg) throws IOException {
        emit("Load", "(Addr " + address + ")", reg);
    }

    public void load(SprockellRegister address, SprockellRegister reg) throws IOException {
        emit("Load", "(Deref " + address + ")", reg);
    }

    public void store(SprockellRegister reg, int address) throws IOException {
        emit("Store", reg, "(Addr " + address + ")");
    }

    public void store(SprockellRegister reg, SprockellRegister address) throws IOException {
        emit("Store", reg, "(Deref " + address + ")");
    }

    public void branchAbsolute(SprockellRegister cond, int address) throws IOException {
        emit("Branch", cond, "(Abs " + address + ")");
    }

    public void branchRelative(SprockellRegister cond, int jump) throws IOException {
        emit("Branch", cond, "(Rel " + jump + ")");
    }

    public void branch(SprockellRegister cond, SprockellRegister reg) throws IOException {
        emit("Branch", cond, "(Ind " + reg + ")");
    }

    public void jumpAbsolute(int address) throws IOException {
        emit("Jump", "(Abs " + address + ")");
    }

    public void jumpRelative(int jump) throws IOException {
        emit("Jump", "(Rel " + jump + ")");
    }

    public void jump(SprockellRegister reg) throws IOException {
        emit("Jump", "(Ind " + reg + ")");
    }

    public void push(SprockellRegister reg) throws IOException {
        emit("Push", reg);
    }

    public void pop(SprockellRegister reg) throws IOException {
        emit("Pop", reg);
    }

    public void nop() throws IOException {
        emit("Nop");
    }

    public void read(int address) throws IOException {
        emit("Read", "(Addr " + address + ")");
    }

    public void read(SprockellRegister address) throws IOException {
        emit("Read", "(Deref " + address + ")");
    }

    public void receive(SprockellRegister reg) throws IOException {
        emit("Receive", reg);
    }

    public void write(SprockellRegister reg, int address) throws IOException {
        emit("Write", reg, "(Addr " + address + ")");
    }

    public void write(SprockellRegister reg, SprockellRegister address) throws IOException {
        emit("Write", reg, "(Deref " + address + ")");
    }

    public void testAndSet(int address) throws IOException {
        emit("TestAndSet", "(Addr " + address + ")");
    }

    public void testAndSet(SprockellRegister address) throws IOException {
        emit("TestAndTest", "(Deref " + address + ")");
    }

    private void emit(String instruction, Object... operands) throws IOException {
        write(", \n    ");
        write(instruction);

        for(Object operand : operands) {
            write(" ");

            if(operand instanceof Integer) {
                write("(" + operand.toString() + ")");
            } else {
                write(operand.toString());
            }
        }
    }
}
