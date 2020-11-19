package domain.adt;

import domain.ProgramState;

import java.util.LinkedList;
import java.util.Queue;

public class MyList<Template> implements MyInterfaceList<Template> {

    private final Queue<Template> list;

    public MyList() {
        this.list = new LinkedList<Template>();
    }

    @Override
    public void push(Template t) {
        this.list.add(t);
    }

    @Override
    public ProgramState pop() {
        return (ProgramState) this.list.poll();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Template t : this.list)
            s.append(t.toString()).append("\n");
        return s.toString();
    }
}
