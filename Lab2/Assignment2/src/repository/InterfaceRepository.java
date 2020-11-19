package repository;

import domain.ProgramState;

public interface InterfaceRepository {
    ProgramState getCrtPrg();
    void add(ProgramState prg);
}
