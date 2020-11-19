package domain.adt;

import domain.ProgramState;

public interface MyInterfaceList<Template> {
    void push(Template element);

    ProgramState pop();
}
