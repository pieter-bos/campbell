package campbell.roborovski.model;

import sprockell.SprockellCompute;
import sprockell.SprockellEmitter;
import sprockell.SprockellRegister;

import java.io.IOException;
import java.util.List;

/**
 * CallExpression represents the calling of expressions in Roborovski
 */
public class CallExpression extends Expression {
    /**
     * Tells whether the function is curried
     */
    private boolean curried;

    /**
     * Function to be called
     */
    private final Expression callee;

    /**
     * List containing all arguments to be given to the callee
     */
    private final List<Expression> arguments;

    public CallExpression(boolean curried, Expression callee, List<Expression> arguments) {
        this.curried = curried;
        this.callee = callee;
        this.arguments = arguments;
    }

    /**
     * Generates SprIl/Sprockell code for this call expression
     * @param emitter
     * @param block
     * @throws IOException
     */
    @Override
    public void compile(SprockellEmitter emitter, Block block) throws IOException {
        start(emitter);

        if(curried) {
            // NB: stackOffset in effect, since we are in an expression
            // 1: calculate new frame size: curried frame + arguments
            // 2: store curried frame in new frame
            // 3: store arguments in new frame
            // 4: push the new frame

            for(Expression arg : arguments) {
                arg.compile(emitter, block);
            }

            callee.compile(emitter, block);
            emitter.pop(SprockellRegister.a); // curried frame pointer
            emitter.load(SprockellRegister.a, SprockellRegister.b); // number of saved arguments
            emitter.emitConst(2 + arguments.size(), SprockellRegister.c);
            emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.c, SprockellRegister.b); // size of new curried frame

            emitter.load(Program.NEW, SprockellRegister.c); // new curried frame pointer
            emitter.compute(SprockellCompute.Add, SprockellRegister.c, SprockellRegister.b, SprockellRegister.b);
            emitter.store(SprockellRegister.b, Program.NEW);

            emitter.push(SprockellRegister.c);
            emitter.pop(SprockellRegister.d);

            emitter.store(SprockellRegister.b, SprockellRegister.d);

            emitter.emitConst(1, SprockellRegister.b);
            emitter.compute(SprockellCompute.Add, SprockellRegister.d, SprockellRegister.b, SprockellRegister.d);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.e);
            emitter.load(SprockellRegister.e, SprockellRegister.e);
            emitter.store(SprockellRegister.e, SprockellRegister.d);
            emitter.compute(SprockellCompute.Add, SprockellRegister.d, SprockellRegister.b, SprockellRegister.d);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.e);
            emitter.compute(SprockellCompute.Add, SprockellRegister.e, SprockellRegister.b, SprockellRegister.e);
            emitter.load(SprockellRegister.e, SprockellRegister.e);
            emitter.store(SprockellRegister.e, SprockellRegister.d);

            // A: curried frame pointer
            // B: temp
            // C: new curried frame pointer
            // D: current new curried frame pointer
            // E: temp

            // Load old arguments into new frame
            emitter.load(SprockellRegister.a, SprockellRegister.e);
            emitter.emitConst(3, SprockellRegister.b);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.a);
            emitter.emitConst(1, SprockellRegister.b);
            emitter.compute(SprockellCompute.Add, SprockellRegister.d, SprockellRegister.b, SprockellRegister.d);

            emitter.branchRelative(SprockellRegister.e, 2);
            emitter.jumpRelative(7);
            emitter.load(SprockellRegister.a, SprockellRegister.b);
            emitter.store(SprockellRegister.b, SprockellRegister.d);
            emitter.emitConst(1, SprockellRegister.b);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.b, SprockellRegister.a);
            emitter.compute(SprockellCompute.Add, SprockellRegister.d, SprockellRegister.b, SprockellRegister.d);
            emitter.jumpRelative(-7);

            // Load new arguments into new frame
            for(Expression arg : arguments) {
                emitter.pop(SprockellRegister.b);
                emitter.store(SprockellRegister.b, SprockellRegister.d);
                emitter.emitConst(1, SprockellRegister.b);
                emitter.compute(SprockellCompute.Add, SprockellRegister.d, SprockellRegister.b, SprockellRegister.d);
            }

            // Push pointer to new frame, done!
            emitter.push(SprockellRegister.c);
        } else {
            // NB: stackOffset in effect, since we are in an expression
            // 1: pop function pointer from curried frame
            // 2: calculate size of actual function frame: al + sp + pc + curried frame + additional arguments.
            //    function frame must not spill any values, hence the function immediately allocates a new scope.
            // 2.5: allocate actual function frame
            // 3: store al, sp, pc, curried frame and arguments in function frame
            // 4: point sp to al
            // 5: jump to function
            // 6: push function result

            for(Expression arg : arguments) {
                arg.compile(emitter, block);
            }

            callee.compile(emitter, block);
            emitter.pop(SprockellRegister.a); // curried frame pointer
            emitter.load(SprockellRegister.a, SprockellRegister.b); // number of saved arguments
            emitter.emitConst(3 + arguments.size(), SprockellRegister.c);
            emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.c, SprockellRegister.b); // size of function frame

            emitter.load(Program.NEW, SprockellRegister.c); // function frame pointer
            emitter.compute(SprockellCompute.Add, SprockellRegister.c, SprockellRegister.b, SprockellRegister.b);
            emitter.store(SprockellRegister.b, Program.NEW);

            emitter.push(SprockellRegister.c);
            emitter.pop(SprockellRegister.b);

            emitter.emitConst(2, SprockellRegister.d);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.d, SprockellRegister.d);
            emitter.load(SprockellRegister.d, SprockellRegister.d);
            emitter.store(SprockellRegister.d, SprockellRegister.b);

            emitter.emitConst(1, SprockellRegister.d);
            emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.d, SprockellRegister.b);

            emitter.emitConst(arguments.size(), SprockellRegister.d);
            emitter.compute(SprockellCompute.Sub, SprockellRegister.sp, SprockellRegister.d, SprockellRegister.d);
            emitter.store(SprockellRegister.d, SprockellRegister.b);

            emitter.emitConst(1, SprockellRegister.d);
            emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.d, SprockellRegister.b);

            // Return address
            emitter.emitConst(getOffset() + getSize() - 1, SprockellRegister.d);
            emitter.store(SprockellRegister.d, SprockellRegister.b);

            // A: curried frame pointer
            // B: current actual frame pointer
            // C: actual frame pointer
            // D: number of arguments left in curried frame pointer to store

            emitter.load(SprockellRegister.a, SprockellRegister.d);
            emitter.push(SprockellRegister.a); // Spill the value of a, iterates over curried function arguments.
            emitter.emitConst(3, SprockellRegister.e);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.e, SprockellRegister.a);
            emitter.branchRelative(SprockellRegister.d, 2);
            emitter.jumpRelative(8);
            emitter.load(SprockellRegister.a, SprockellRegister.e);
            emitter.store(SprockellRegister.e, SprockellRegister.b);
            emitter.emitConst(1, SprockellRegister.e);
            emitter.compute(SprockellCompute.Add, SprockellRegister.a, SprockellRegister.e, SprockellRegister.a);
            emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.e, SprockellRegister.b);
            emitter.compute(SprockellCompute.Sub, SprockellRegister.d, SprockellRegister.e, SprockellRegister.d);
            emitter.jumpRelative(-8);

            emitter.pop(SprockellRegister.d); // Restore curried frame pointer to d

            for(Expression arg : arguments) {
                emitter.pop(SprockellRegister.e);
                emitter.store(SprockellRegister.e, SprockellRegister.b);
                emitter.emitConst(1, SprockellRegister.e);
                emitter.compute(SprockellCompute.Add, SprockellRegister.b, SprockellRegister.e, SprockellRegister.b);
            }

            // Done creating function frame, call the function!

            emitter.push(SprockellRegister.c);
            emitter.pop(SprockellRegister.sp);
            emitter.emitConst(1, SprockellRegister.e);
            emitter.compute(SprockellCompute.Add, SprockellRegister.e, SprockellRegister.d, SprockellRegister.d);
            emitter.load(SprockellRegister.d, SprockellRegister.pc);

            // Push the result of the function, return location.
            emitter.push(SprockellRegister.a);
        }

        end(emitter);
    }

    /**
     * Sets the offset of this call expression and all its arguments
     * @param offset
     */
    @Override
    public void setOffset(int offset) {
        this.offset = offset;

        int current = offset + 3;

        for(Expression arg : arguments) {
            arg.setOffset(current);
            current += arg.getSize();
        }

        callee.setOffset(current);
    }

    /**
     * Returns the number of instructions of this call expression
     * @return
     */
    @Override
    public int getSize() {
        if(curried) {
            return 34 + arguments.size() * 4 + arguments.stream().mapToInt(Expression::getSize).sum() + callee.getSize();
        } else {
            return 42 + arguments.size() * 4 + arguments.stream().mapToInt(Expression::getSize).sum() + callee.getSize();
        }
    }

    /**
     * Calculates how many values are spilled on the stack
     * @return
     */
    @Override
    public int calcSpill() {
        int result = callee.calcSpill();
        int saved = 1;

        for(Expression arg : arguments) {
            result = Math.max(result, saved + arg.calcSpill());
            saved++;
        }

        return Math.max(1, result);
    }
}
