package domain.statements;

import domain.ProgramState;
import exceptions.MyException;

public interface InterfaceStatement {
    ProgramState execute(ProgramState state) throws MyException;
}
