package domain.expressions;

import domain.adt.MyInterfaceDictionary;
import domain.type.IntType;
import domain.values.BoolValue;
import domain.values.IntValue;
import domain.values.Value;
import exceptions.MyException;

public class RelationalExpressions implements Expression {

    private final Expression exp1, exp2;
    private String op;

    public RelationalExpressions(Expression exp1, Expression exp2, String op) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.op = op;
    }

    public Expression getExp1() {
        return exp1;
    }

    public Expression getExp2() {
        return exp2;
    }

    public String getOp() {
        return op;
    }

    @Override
    public Value eval(MyInterfaceDictionary<String, Value> tbl) throws MyException {
        Value v1, v2;
        v1 = exp1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = exp2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (op.equals("<"))
                    return new BoolValue(n1 < n2);
                if (op.equals("<="))
                    return new BoolValue(n1 <= n2);
                if (op.equals("=="))
                    return new BoolValue(n1 == n2);
                if (op.equals("!="))
                    return new BoolValue(n1 != n2);
                if (op.equals(">"))
                    return new BoolValue(n1 > n2);
                if (op.equals(">="))
                    return new BoolValue(n1 >= n2);

            } else
                throw new MyException("Second expression is not an Int type!");
        } else
            throw new MyException("First expression is not an Int type!");
        return new BoolValue(false);
    }
}
