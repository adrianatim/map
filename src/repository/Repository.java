package repository;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceList;
import domain.adt.MyInterfaceStack;
import domain.adt.MyList;
import domain.statements.InterfaceStatement;
import domain.values.Value;
import exceptions.MyException;

import java.io.*;


public class Repository implements InterfaceRepository {

    private final MyList<ProgramState> prgStates;
    private final String filename;

    public Repository(String filename) {
        this.prgStates = new MyList<ProgramState>();
        this.filename = filename;
    }

    public MyList<ProgramState> getPrgStates() {
        return prgStates;
    }

    @Override
    public ProgramState getCrtPrg() {
        return this.prgStates.pop();
    }

    @Override
    public void add(ProgramState prg) {
        this.prgStates.push(prg);
    }

    @Override
    public void loginProgramStateExecution(ProgramState prg) throws MyException, IOException {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(this.filename, true)));
            MyInterfaceStack<InterfaceStatement> exeStack = prg.getExeStack();
            MyInterfaceDictionary<String,  Value> symTable = prg.getSymTable();
            MyInterfaceList<Value> out = prg.getOut();
            logFile.println("ExeStack");
            logFile.println(exeStack.toString());
            logFile.println("SymTable");
            logFile.println(symTable.toString());
            logFile.println("Out");
            logFile.println(out.toString());
            logFile.println("FileTable");
            logFile.println(this.filename.toString());
            logFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
