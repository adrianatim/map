package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.type.Type;
import domain.values.BoolValue;
import domain.values.IntValue;
import domain.values.Value;
import exceptions.MyException;

public class VariableDeclarationStatement implements InterfaceStatement{

    private String id;
    private Type typ;

    public VariableDeclarationStatement(String id, Type typ) {
        this.id = id;
        this.typ = typ;
    }

    public String getId() {
        return id;
    }

    public Type getTyp() {
        return typ;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceDictionary<String, Value> symTable= state.getSymTable();
        if(symTable.isDefined(id))
            throw new MyException("Variable is already declared");
        else {
            if(this.typ.toString().equals("int"))
                symTable.put(id, new IntValue(0));
            else
                symTable.put(id, new BoolValue(false));
        }
        return state;
    }

    @Override
    public String toString()
    {
        return "Type "+ this.typ.toString()+ " " + this.id;
    }
}
