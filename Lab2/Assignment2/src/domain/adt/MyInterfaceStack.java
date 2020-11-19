package domain.adt;

public interface MyInterfaceStack<Template> {
    Template pop();
    void push(Template element);
    boolean isEmpty();
}