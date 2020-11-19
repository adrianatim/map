package controller;

import domain.ProgramState;
import domain.adt.MyInterfaceStack;
import domain.statements.InterfaceStatement;
import exceptions.EmptyADT;
import exceptions.MyException;
import repository.InterfaceRepository;

public class Service {
    private final InterfaceRepository repo;
    private final int displayFlag;

    public Service(InterfaceRepository repo, int displayFlag) {
        this.repo = repo;
        this.displayFlag = displayFlag;
    }

    public void addService(ProgramState prg)
    {
        this.repo.add(prg);
    }

    //one step execution of a program
    public ProgramState oneStep(ProgramState state) throws MyException, EmptyADT {
        MyInterfaceStack<InterfaceStatement> stk = state.getExeStack();
        if (stk.isEmpty())
            throw new EmptyADT("Program stack is empty!");
        InterfaceStatement crtStatement = stk.pop();
        return crtStatement.execute(state);
    }

    // complete execution of a program
    public void allStep() {
        ProgramState prg = this.repo.getCrtPrg();
        while (!prg.getExeStack().isEmpty()) {
            oneStep(prg);
            if(displayFlag == 1)
                System.out.println(prg);
        }
    }
}
