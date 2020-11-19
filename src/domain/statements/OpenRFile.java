package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceTable;
import domain.expressions.Expression;
import domain.values.StringValue;
import domain.values.Value;
import exceptions.MyException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenRFile implements InterfaceStatement {

    private final Expression exp;

    public OpenRFile(Expression exp) {
        this.exp = exp;
    }

    public Expression getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return "OpenRFile(" + this.exp.toString() + ")";
    }

    //opening the file
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceTable<String, BufferedReader> fileTable = state.getFileTable();
        MyInterfaceDictionary<String, Value> symTable = state.getSymTable();
        Value val;
        val = this.exp.eval(symTable);
        if (!val.getType().toString().equals("string")) {
            throw new MyException("The expression is not a string type!");
        } else {
            String str = ((StringValue) val).getStr();
            if (fileTable.isDefined(str)) {
                throw new MyException("The filename is already used!");
            }
            try {
                BufferedReader reader = new BufferedReader(new FileReader(str));
                fileTable.put(str, reader);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return state;
    }
}
