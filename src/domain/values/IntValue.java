package domain.values;

import domain.type.IntType;
import domain.type.Type;

public class IntValue implements Value {

    private final int val;

    public IntValue(int v) {
        this.val = v;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return " " + this.val;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public boolean equals(Object another) {
        return  another instanceof IntValue;
    }
}
