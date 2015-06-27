package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Program extends Block {
    private List<Function> functions = new LinkedList<>();
    private List<Struct> structs = new LinkedList<>();
    private int internalNameNo = 0;

    public void addFunction(Function func) {
        functions.add(func);
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
        calcOffsets();
        setOffset(1);

        emitter.jumpAbsolute(getOffset());

        for(Function func : functions) {
            func.compile(emitter, this);
        }

        super.compile(emitter, this);

        System.out.println("Program size is " + getSize());
    }

    @Override
    public void setOffset(int offset) {
        int current = offset + 1;

        for(Function function : functions) {
            function.setOffset(current);
            current += function.getSize();
        }

        super.setOffset(current);
    }

    @Override
    public int getSize() {
        int size = 1;

        for(Function function : functions) {
            size += function.getSize();
        }

        return size + super.getSize();
    }
}