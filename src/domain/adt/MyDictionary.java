package domain.adt;

import exceptions.MyException;

import java.util.Hashtable;
import java.util.Map;

public class MyDictionary<TKey, TValue> implements MyInterfaceDictionary<TKey, TValue> {

    private final Hashtable<TKey, TValue> dictionary;

    public MyDictionary() {
        this.dictionary = new Hashtable<TKey, TValue>();
    }

    @Override
    public void put(TKey k, TValue val) {
        this.dictionary.put(k, val);
    }

    @Override
    public void remove(TKey k) {
        this.dictionary.remove(k);
    }

    @Override
    public TValue lookup(TKey t) throws MyException {
        if (this.dictionary.get(t) != null)
            return this.dictionary.get(t);
        else throw new MyException("Doesn't exist!");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<TKey, TValue> h : this.dictionary.entrySet()) {
            s.append(h.getKey()).append(" -> ").append(h.getValue().toString()).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean isDefined(TKey t) {
        return this.dictionary.containsKey(t);
    }

    @Override
    public void update(TKey t, TValue v) {
        this.dictionary.put(t, v);
    }

}
