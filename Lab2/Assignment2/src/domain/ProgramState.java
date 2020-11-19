package domain;

import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceList;
import domain.adt.MyInterfaceStack;
import domain.statements.InterfaceStatement;
import domain.values.Value;

import java.util.Stack;

public class ProgramState {
    MyInterfaceStack<InterfaceStatement> exeStack;
    MyInterfaceDictionary<String, Value> symTable;
    MyInterfaceList<Value> out;
    InterfaceStatement originalProgram;

    public ProgramState(MyInterfaceStack<InterfaceStatement> stack, MyInterfaceDictionary<String, Value> dictionary, MyInterfaceList<Value> list, InterfaceStatement prg) {
        this.exeStack = stack;
        this.symTable = dictionary;
        this.out = list;
        this.originalProgram = prg;
        this.exeStack.push(prg);
    }

    public MyInterfaceStack<InterfaceStatement> getExeStack() {
        return exeStack;
    }

    public MyInterfaceDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public MyInterfaceList<Value> getOut() {
        return out;
    }

    public InterfaceStatement getOriginalProgram() {
        return originalProgram;
    }

    public void setExeStack(MyInterfaceStack<InterfaceStatement> exeStack) {
        this.exeStack = exeStack;
    }

    public void setSymTable(MyInterfaceDictionary<String, Value> symTable) {
        this.symTable = symTable;
    }

    public void setOut(MyInterfaceList<Value> out) {
        this.out = out;
    }

    public void setOriginalProgram(InterfaceStatement originalProgram) {
        this.originalProgram = originalProgram;
    }

    @Override
    public String toString() {
        return "ExeStack: \n"+this.exeStack.toString() + "SymTable: \n"+ this.symTable.toString() + "Out: \n" + this.out.toString()
                ;
    }
}
