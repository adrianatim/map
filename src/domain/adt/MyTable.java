package domain.adt;

import domain.values.StringValue;
import exceptions.MyException;

import java.io.BufferedReader;
import java.util.Hashtable;
import java.util.Map;

public class MyTable<TKey, TBufferedReader> implements MyInterfaceTable<TKey, TBufferedReader> {

    private final Hashtable<TKey, TBufferedReader> table;

    public MyTable() {
        this.table = new Hashtable<TKey, TBufferedReader>();
    }

    public Hashtable<TKey, TBufferedReader> getTable() {
        return table;
    }

    @Override
    public void put(TKey key, TBufferedReader buff) throws MyException {
        if (isDefined(key))
            throw new MyException("Filename already used!");
        else {
            this.table.put(key, buff);
        }
    }

    @Override
    public boolean isDefined(TKey key) {
        return this.table.containsKey(key);
    }

    @Override
    public TBufferedReader getBufferedReader(TKey key) {
        return this.table.get(key);
    }

    @Override
    public void remove(TKey key) {
        this.table.remove(key);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<TKey, TBufferedReader> h : this.table.entrySet()) {
            s.append("Filename ").append(h.getKey()).append("\n");
        }
        return s.toString();
    }
}

