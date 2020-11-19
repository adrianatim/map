import controller.Service;
import domain.ProgramState;
import domain.adt.*;
import domain.expressions.ArithmeticExpression;
import domain.expressions.ValueExpression;
import domain.expressions.VariableExpression;
import domain.statements.*;
import domain.type.BoolType;
import domain.type.IntType;
import domain.values.BoolValue;
import domain.values.IntValue;
import domain.values.Value;
import repository.InterfaceRepository;
import repository.Repository;
import view.ExitCommand;
import view.RunExample;
import view.TextMenu;

import java.io.BufferedReader;


public class Interpreter {

    public static ProgramState initializeProgramState(InterfaceStatement ex)
    {
        MyInterfaceStack<InterfaceStatement> exeStack = new MyStack<>();
        MyInterfaceDictionary<String, Value> symTable = new MyDictionary<>();
        MyInterfaceList<Value> out = new MyList<>();
        MyInterfaceTable<String, BufferedReader> fileTable = new MyTable<>();
        return new ProgramState(exeStack, symTable, out, fileTable, ex);
    }

    public static void main(String[] args) {
        InterfaceStatement ex1 = new CompoundStatement(new VariableDeclarationStatement("v", new IntType()), new CompoundStatement(new AssignmentStatement("v", new ValueExpression(new IntValue(2))), new PrintStatement(new VariableExpression("v"))));
        ProgramState prg1 = initializeProgramState(ex1);
        InterfaceRepository repo1 = new Repository("log1.txt");
        Service srv1 = new Service(repo1, 1);
        srv1.addService(prg1);

        InterfaceStatement ex2 = new CompoundStatement(new VariableDeclarationStatement("a", new IntType()), new CompoundStatement(new VariableDeclarationStatement("b", new IntType()), new CompoundStatement(new AssignmentStatement("a", new ArithmeticExpression(1, new ValueExpression(new IntValue(2)), new ArithmeticExpression(3, new ValueExpression(new IntValue(3)), new ValueExpression(new IntValue(5))))), new CompoundStatement(new AssignmentStatement("b", new ArithmeticExpression(1, new VariableExpression("a"), new ValueExpression(new IntValue(1)))), new PrintStatement(new VariableExpression("b"))))));
        ProgramState prg2 = initializeProgramState(ex2);
        InterfaceRepository repo2 = new Repository("log2.txt");
        Service srv2 = new Service(repo2, 1);
        srv2.addService(prg2);

        InterfaceStatement ex3 = new CompoundStatement(new VariableDeclarationStatement("a", new BoolType()), new CompoundStatement(new VariableDeclarationStatement("v", new IntType()), new CompoundStatement(new AssignmentStatement("a", new ValueExpression(new BoolValue(true))), new CompoundStatement(new IfStatement(new VariableExpression("a"), new AssignmentStatement("v", new ValueExpression(new IntValue(2))), new AssignmentStatement("v", new ValueExpression(new IntValue(3)))), new PrintStatement(new VariableExpression("v"))))));
        ProgramState prg3 = initializeProgramState(ex3);
        InterfaceRepository repo3 = new Repository("log3.txt");
        Service srv3 = new Service(repo3, 1);
        srv3.addService(prg3);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), srv1));
        menu.addCommand(new RunExample("2", ex2.toString(), srv2));
        menu.addCommand(new RunExample("3", ex3.toString(), srv3));
        menu.show();
    }

}
