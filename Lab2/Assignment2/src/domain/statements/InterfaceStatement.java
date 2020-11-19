package domain.statements;

import domain.ProgramState;
import exceptions.MyException;

public interface InterfaceStatement {
    public ProgramState execute(ProgramState state) throws MyException;
}
