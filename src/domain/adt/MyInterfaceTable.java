package domain.adt;

import exceptions.MyException;

public interface MyInterfaceTable<TKey, TBufferedReader> {
    void put(TKey key, TBufferedReader buff) throws MyException;

    boolean isDefined(TKey key);

    TBufferedReader getBufferedReader(TKey key);

    void remove(TKey key);
}
