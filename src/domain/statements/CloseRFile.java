package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceTable;
import domain.expressions.Expression;
import domain.values.StringValue;
import domain.values.Value;
import exceptions.MyException;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFile implements InterfaceStatement{

    private final Expression exp;

    public CloseRFile(Expression exp) {
        this.exp = exp;
    }

    public Expression getExp() {
        return exp;
    }

    //closing the file
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceTable<String, BufferedReader> fileTable = state.getFileTable();
        MyInterfaceDictionary<String, Value> symTable = state.getSymTable();
        try{
            StringValue stringValue = (StringValue) this.exp.eval(symTable);
            String key = stringValue.getStr();
            if(fileTable.getBufferedReader(key) != null) {
                BufferedReader bufferedReader = fileTable.getBufferedReader(key);
                bufferedReader.close();
                fileTable.remove(key);
            }
            else throw new MyException("Can't close something that doesn't exists!");
        } catch (MyException | IOException e) {
            throw new MyException(e.getMessage());
        }
        return state;
    }
}
