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
        int currentOffset = 0;

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
        emitter.emitConst(size, SprockellRegister.a);
        emitter.compute(SprockellCompute.Sub, SprockellRegister.sp, SprockellRegister.a, SprockellRegister.sp, ">>> ENTER SCOPE");

        for(Statement stat : statements) {
            stat.compile(emitter, this);

            if(stat instanceof Expression) {
                emitter.pop(SprockellRegister.zero);
            }
        }

        emitter.emitConst(size, SprockellRegister.a);
        emitter.compute(SprockellCompute.Add, SprockellRegister.sp, SprockellRegister.a, SprockellRegister.sp, "<<< EXIT SCOPE");
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;

        int current = offset + 2;

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

        return size + 4;
    }

    public int getVarStackSize() {
        return size;
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
