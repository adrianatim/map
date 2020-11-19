package domain.expressions;

import domain.adt.MyInterfaceDictionary;
import domain.values.Value;
import exceptions.MyException;

public interface Expression {
    Value eval(MyInterfaceDictionary<String, Value> tbl) throws MyException;
}
