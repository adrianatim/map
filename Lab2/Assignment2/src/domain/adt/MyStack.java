package domain.adt;

import java.util.Stack;

public class MyStack<Template> implements MyInterfaceStack<Template>{

    private final Stack<Template> stack;

    public MyStack()
    {
        this.stack = new Stack<Template>();
    }

    @Override
    public Template pop() {
        return stack.pop();
    }

    @Override
    public void push(Template element) {
        this.stack.push(element);
    }

    public Stack<Template> getStack() {
        return stack;
    }

    @Override
    public boolean isEmpty()
    {
        return(this.stack.isEmpty());
    }

    @Override
    public String toString()
    {
        String s="";
        for(Template t: this.stack)
            s+= t.toString()+"\n";
        return s;
    }
}