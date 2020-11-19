package domain.expressions;

import domain.adt.MyInterfaceDictionary;
import domain.type.IntType;
import domain.values.IntValue;
import domain.values.Value;
import exceptions.DivisionByZero;
import exceptions.MyException;

public class ArithmeticExpression implements Expression {
    private Expression e1, e2;
    private int op;

    public ArithmeticExpression(int op, Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op; //1-plus, 2-minus, 3-multiply, 4-division
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
    public Value eval(MyInterfaceDictionary<String, Value> tbl) throws MyException, DivisionByZero {
        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (op == 1)
                    return new IntValue(n1 + n2);
                if (op == 2)
                    return new IntValue(n1 - n2);
                if (op == 3)
                    return new IntValue(n1 * n2);
                if (op == 4)
                    if (n2 == 0) throw new DivisionByZero("Division by zero!");
                    else
                        return new IntValue(n1 / n2);
                throw new MyException("Invalid int final operand!");
            } else
                throw new MyException("Second operand is not an integer!");
        } else
            throw new MyException("First operand is not an integer!");
    }

    @Override
    public String toString() {
        String s = "";
        s += this.e1.toString() + " ";
        if (this.op == 1)
            s += "+";
        else if (this.op == 2)
            s += "-";
        else if (this.op == 3)
            s += "*";
        else if (this.op == 4)
            s += "/";
        s += " " + this.e2.toString();
        return s;
    }
}

