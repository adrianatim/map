package domain.expressions;

import domain.adt.MyInterfaceDictionary;
import domain.values.Value;
import exceptions.MyException;

public class ValueExpression implements Expression {
    private final Value e;

    public ValueExpression(Value e) {
        this.e = e;
    }

    @Override
    public Value eval(MyInterfaceDictionary<String, Value> tbl) throws MyException {
        return this.e;
    }

    @Override
    public String toString() {
        return this.e.toString();
    }
}
