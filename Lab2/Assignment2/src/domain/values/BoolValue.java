package domain.values;

import domain.type.BoolType;
import domain.type.Type;

public class BoolValue implements Value {

    private final boolean bool;

    public BoolValue(boolean b) {
        this.bool = b;
    }

    public boolean getBool() {
        return bool;
    }

    @Override
    public String toString() {
        return " "+ this.bool;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }


}
