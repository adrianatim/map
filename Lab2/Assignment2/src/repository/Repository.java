package repository;

import domain.ProgramState;
import domain.adt.MyList;


public class Repository implements InterfaceRepository{

    private final MyList<ProgramState> prgStates;

    public Repository() {
        this.prgStates = new MyList<ProgramState>();
    }

    public MyList<ProgramState> getPrgStates() {
        return prgStates;
    }

    @Override
    public ProgramState getCrtPrg() {
        return this.prgStates.pop();
    }

    @Override
    public void add(ProgramState prg) {
        this.prgStates.push(prg);
    }
}
