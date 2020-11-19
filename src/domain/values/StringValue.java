package domain.values;

import domain.type.StringType;
import domain.type.Type;

public class StringValue implements Value {

    private final String str;

    public StringValue(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return " " + this.str;
    }

    @Override
    public Type getType() {
        return new StringType();
    }

    @Override
    public boolean equals(Object another) {
        return another instanceof StringValue;
    }
}
