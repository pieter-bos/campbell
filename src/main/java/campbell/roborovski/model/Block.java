package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Block extends Statement {
    protected List<Variable> variables = new LinkedList<>();
    private List<Statement> statements = new LinkedList<>();
    private int size = 0;
    protected Block superBlock = null;

    public void addVariable(Variable var) {
        variables.add(var);
        var.setBlock(this);
    }

    public void addStatement(Statement stat) {
        statements.add(stat);

        if(stat instanceof Block) {
            ((Block) stat).superBlock = this;
        } else if(stat instanceof If) {
            ((If) stat).getThenBlock().superBlock = this;
            ((If) stat).getElseBlock().superBlock = this;
        }
    }

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

    @Override
    public int calcSpill() {
        int max = 0;

        for(Statement stat : statements) {
            max = Math.max(max, stat.calcSpill());
        }

        return Math.max(max, 1);
    }

    public int getVarStackSize() {
        return size + 1;
    }

    public Block getSuperBlock() {
        return superBlock;
    }

    public void compile(SprockellEmitter emitter) throws IOException {
        compile(emitter, this);
        emitter.close();
    }

    public Variable requireVariable(String name) {
        for(Variable var : variables) {
            if(var.getName().equals(name)) {
                return var;
            }
        }

        throw new RuntimeException("Internal error: required variable " + name);
    }
}
