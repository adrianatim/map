package domain.adt;

public interface MyInterfaceDictionary<TKey, TValue> {

    void put(TKey k, TValue val);

    void remove(TKey k);

    TValue lookup(TKey t);

    boolean isDefined(TKey t);

    void update(TKey id, TValue val);
}