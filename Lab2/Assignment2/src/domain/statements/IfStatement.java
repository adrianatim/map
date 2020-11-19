package domain.statements;

import domain.ProgramState;
import domain.adt.MyDictionary;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceStack;
import domain.expressions.Expression;
import domain.type.BoolType;
import domain.values.BoolValue;
import domain.values.Value;
import exceptions.MyException;

public class IfStatement implements InterfaceStatement {
    private Expression exp;
    private InterfaceStatement thenS, elseS;

    public IfStatement(Expression exp, InterfaceStatement i1, InterfaceStatement i2) {
        this.exp = exp;
        this.thenS = i1;
        this.elseS = i2;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceDictionary<String, Value> symTable = state.getSymTable();
        MyInterfaceStack<InterfaceStatement> exeStack = state.getExeStack();
        Value cond = this.exp.eval(symTable);
        if (!cond.getType().toString().equals("bool"))
            throw new MyException("Conditional expression is not a boolean!");
        else {
            BoolValue bv = (BoolValue) cond;
            if (bv.getBool())
                exeStack.push(thenS);
            else
                exeStack.push(elseS);
        }
        return state;
    }

    @Override
    public String toString() {
        return "(IF(" + this.exp.toString() + ") THEN(" + this.thenS.toString() + ") ELSE(" + this.elseS.toString() + "))";
    }
}
