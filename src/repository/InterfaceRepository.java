package repository;

import domain.ProgramState;
import exceptions.MyException;

import java.io.IOException;

public interface InterfaceRepository {
    ProgramState getCrtPrg();
    void add(ProgramState prg);
    void loginProgramStateExecution(ProgramState prg) throws MyException, IOException;
}
