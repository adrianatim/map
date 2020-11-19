package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceList;
import domain.expressions.Expression;
import domain.values.Value;
import exceptions.MyException;

public class PrintStatement implements InterfaceStatement{
    private final Expression exp;

    public PrintStatement(Expression exp)
    {
        this.exp=exp;
    }

    public Expression getExp() {
        return exp;
    }

    @Override
    public String toString()
    {
        return "print("+this.exp.toString()+")";
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceList<Value> list = state.getOut();
        MyInterfaceDictionary<String, Value> symbolTable = state.getSymTable();
        list.push(this.exp.eval(symbolTable));
        return state;
    }
}
