package domain.expressions;

import domain.adt.MyInterfaceDictionary;
import domain.type.BoolType;
import domain.values.BoolValue;
import domain.values.Value;
import exceptions.MyException;

public class LogicExpression implements Expression {
    private Expression e1, e2;
    private int op;

    public LogicExpression(Expression e1, Expression e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op; // 1-&&, 2-||
    }

    public Expression getE1() {
        return e1;
    }

    public Expression getE2() {
        return e2;
    }

    public int getOp() {
        return op;
    }

    @Override
    public Value eval(MyInterfaceDictionary<String, Value> tbl) throws MyException {
        Value v1, v2;
        v1 = this.e1.eval(tbl);
        if (v1.getType().equals(new BoolType())) {
            v2 = this.e2.eval(tbl);
            if (v2.getType().equals(new BoolType())) {
                BoolValue b1 = (BoolValue) v1;
                BoolValue b2 = (BoolValue) v2;
                boolean n1, n2;
                n1 = b1.getBool();
                n2 = b2.getBool();
                if (op == 1)
                    return new BoolValue(n1 && n2);
                if (op == 2)
                    return new BoolValue(n1 || n2);
                else throw new MyException("Invalid bool final operand!");
            } else throw new MyException("Second operand is not a boolean!");
        } else throw new MyException("First operand bool is not a boolean!");
    }

    @Override
    public String toString() {
        String s = "";
        s += this.e1.toString() + " ";
        if (op == 1)
            s += "&&";
        else if (op == 2)
            s += "||";
        s += " " + this.e2.toString();
        return s;
    }
}

