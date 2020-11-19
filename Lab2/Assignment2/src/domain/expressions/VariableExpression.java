package domain.expressions;

import domain.adt.MyInterfaceDictionary;
import domain.values.Value;
import exceptions.MyException;

public class VariableExpression implements Expression {
    private String id;

    public VariableExpression(String id) {
        this.id = id;
    }

    @Override
    public Value eval(MyInterfaceDictionary<String, Value> tbl) throws MyException {
        return tbl.lookup(id);
    }

    @Override
    public String toString()
    {
        return this.id.toString();
    }
}
