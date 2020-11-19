package domain.statements;

import domain.ProgramState;
import exceptions.MyException;

public class NoOperationStatement implements InterfaceStatement{
    public NoOperationStatement() {
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        return state;
    }

    @Override
    public String toString() {
        return "No operation statement!";
    }
}
