package sprockell;

import java.io.IOException;
import java.io.Writer;

public class SprockellEmitter {
    private static final String PRELUDE = "import Sprockell.System\n\nprog = [Nop,\n    ";
    private static final String EPILOGUE = "EndProg]\n\nmain = run 1 prog";
    private final Writer writer;
    private int loc = 1;

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

    public void compute(SprockellCompute op, SprockellRegister left, SprockellRegister right, SprockellRegister dest, String... comments) throws IOException {
        emit("Compute", comments, op, left, right, dest);
    }

    public void emitConst(int value, SprockellRegister reg, String... comments) throws IOException {
        emit("Const", comments, value, reg);
    }

    public void load(int address, SprockellRegister reg, String... comments) throws IOException {
        emit("Load", comments, "(Addr " + address + ")", reg);
    }

    public void load(SprockellRegister address, SprockellRegister reg, String... comments) throws IOException {
        emit("Load", comments, "(Deref " + address + ")", reg);
    }

    public void store(SprockellRegister reg, int address, String... comments) throws IOException {
        emit("Store", comments, reg, "(Addr " + address + ")");
    }

    public void store(SprockellRegister reg, SprockellRegister address, String... comments) throws IOException {
        emit("Store", comments, reg, "(Deref " + address + ")");
    }

    public void branchAbsolute(SprockellRegister cond, int address, String... comments) throws IOException {
        emit("Branch", comments, cond, "(Abs " + address + ")");
    }

    public void branchRelative(SprockellRegister cond, int jump, String... comments) throws IOException {
        emit("Branch", comments, cond, "(Rel " + jump + ")");
    }

    public void branch(SprockellRegister cond, SprockellRegister reg, String... comments) throws IOException {
        emit("Branch", comments, cond, "(Ind " + reg + ")");
    }

    public void jumpAbsolute(int address, String... comments) throws IOException {
        emit("Jump", comments, "(Abs " + address + ")");
    }

    public void jumpRelative(int jump, String... comments) throws IOException {
        emit("Jump", comments, "(Rel " + jump + ")");
    }

    public void jump(SprockellRegister reg, String... comments) throws IOException {
        emit("Jump", comments, "(Ind " + reg + ")");
    }

    public void push(SprockellRegister reg, String... comments) throws IOException {
        emit("Push", comments, reg);
    }

    public void pop(SprockellRegister reg, String... comments) throws IOException {
        emit("Pop", comments, reg);
    }

    public void nop(String... comments) throws IOException {
        emit("Nop", comments);
    }

    public void read(int address, String... comments) throws IOException {
        emit("Read", comments, "(Addr " + address + ")");
    }

    public void read(SprockellRegister address, String... comments) throws IOException {
        emit("Read", comments, "(Deref " + address + ")");
    }

    public void receive(SprockellRegister reg, String... comments) throws IOException {
        emit("Receive", comments, reg);
    }

    public void write(SprockellRegister reg, int address, String... comments) throws IOException {
        emit("Write", comments, reg, "(Addr " + address + ")");
    }

    public void write(SprockellRegister reg, SprockellRegister address, String... comments) throws IOException {
        emit("Write", comments, reg, "(Deref " + address + ")");
    }

    public void testAndSet(int address, String... comments) throws IOException {
        emit("TestAndSet", comments, "(Addr " + address + ")");
    }

    public void testAndSet(SprockellRegister address, String... comments) throws IOException {
        emit("TestAndTest", comments, "(Deref " + address + ")");
    }

    public void emitRaw(String instruction) throws IOException {
        emit(instruction, new String[] { "Raw Haskell" });
    }

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
}
