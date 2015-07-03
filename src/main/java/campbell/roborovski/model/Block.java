package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Block represents a block of statements in Roborovski
 */
public class Block extends Statement {
    /**
     * List containing all variables in this block
     */
    protected List<Variable> variables = new LinkedList<>();

    /**
     * List containing all statements in this block
     */
    private List<Statement> statements = new LinkedList<>();

    /**
     * Size of the block, intial value is 0
     */
    private int size = 0;

    /**
     * super block is the scope which contains this block
     */
    protected Block superBlock = null;

    /**
     * Add a variable to this block
     * @param var
     */
    public void addVariable(Variable var) {
        variables.add(var);
        var.setBlock(this);
    }

    /**
     * Add a statement to this block
     * @param stat
     */
    public void addStatement(Statement stat) {
        statements.add(stat);

        if(stat instanceof Block) {
            ((Block) stat).superBlock = this;
        } else if(stat instanceof If) {
            ((If) stat).getThenBlock().superBlock = this;
            ((If) stat).getElseBlock().superBlock = this;
        }
    }

    /**
     * Calculates the offset of all variables and statements in this block
     */
    public void calcOffsets() {
        int currentOffset = 1;

        for(Variable var : variables) {
            var.setOffset(currentOffset);
            currentOffset += var.getSize();
        }

        size = currentOffset;

        for(Statement stat : statements) {
            if(stat instanceof Block) {
                ((Block) stat).calcOffsets();
            } else if(stat instanceof If) {
                ((If) stat).getThenBlock().calcOffsets();
                ((If) stat).getElseBlock().calcOffsets();
            }
        }
    }

    /**
     * Generates SprIl/Sprockell code for this block
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        emitter.load(Program.NEW, SprockellRegister.a);
        emitter.emitConst(size + 1 + calcSpill(), SprockellRegister.b);
        emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.b);
        emitter.store(SprockellRegister.b, Program.NEW);
        emitter.push(SprockellRegister.sp);
        emitter.pop(SprockellRegister.b);
        emitter.emitConst(calcSpill(), SprockellRegister.c);
        emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.c, SprockellRegister.sp, ">>> ENTER SCOPE");
        emitter.store(SprockellRegister.b, SprockellRegister.sp);

        for(Statement stat : statements) {
            stat.compile(emitter, this);

            if(stat instanceof Expression) {
                emitter.pop(SprockellRegister.zero);
            }
        }

        emitter.load(SprockellRegister.sp, SprockellRegister.sp);
    }

    /**
     * Sets the offset of this block and all its statements
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;

        int current = offset + 9;

        for(Statement stat : statements) {
            stat.setOffset(current);

            current += stat.getSize();

            if(stat instanceof Expression) {
                current += 1;
            }
        }
    }

    /**
     * Returns the number of instructions of this block
     * @return
     */
    @Override
    public int getSize() {
        int size = 0;

        for(Statement stat : statements) {
            size += stat.getSize();

            if(stat instanceof Expression) {
                size += 1;
            }
        }

        return size + 10;
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        int max = 0;

        for(Statement stat : statements) {
            max = Math.max(max, stat.calcSpill());
        }

        return Math.max(max, 1);
    }

    /**
     * Returns the variable stack size
     * @return
     */
    public int getVarStackSize() {
        return size + 1;
    }

    /**
     * Returns the super block of (/scope above) this block
     * @return
     */
    public Block getSuperBlock() {
        return superBlock;
    }

    /**
     * Generates SprIl/Sprockell code for this block
     * @param emitter
     * @throws IOException
     */
    public void compile(SprockellEmitter emitter) throws IOException {
        compile(emitter, this);
        emitter.close();
    }

    /**
     * Searches for a varialbe with a given name in this block
     * @param name - name of variable to find
     * @return Variable
     */
    public Variable requireVariable(String name) {
        for(Variable var : variables) {
            if(var.getName().equals(name)) {
                return var;
            }
        }

        throw new RuntimeException("Internal error: required variable " + name);
    }
}
