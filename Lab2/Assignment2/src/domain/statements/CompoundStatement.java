package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceStack;
import exceptions.MyException;

public class CompoundStatement implements InterfaceStatement {
    private InterfaceStatement first;
    private InterfaceStatement second;

    public CompoundStatement(InterfaceStatement i1, InterfaceStatement i2)
    {
        this.first = i1;
        this.second = i2;
    }

    public InterfaceStatement getFirst() {
        return first;
    }

    public InterfaceStatement getSecond() {
        return second;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceStack<InterfaceStatement> stk = state.getExeStack();
        stk.push(second);
        stk.push(first);
        return state;
    }

    @Override
    public String toString() {
        return "(" + this.first.toString() + ";" + this.second.toString() + ")";
    }

}
