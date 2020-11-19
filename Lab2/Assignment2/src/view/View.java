package view;

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

import java.util.Scanner;

public class View {
    private final Service service;

    public View(Service service) {
        this.service = service;
    }

    public static void menu() {
        System.out.println("\nChoose one option:\n");
        System.out.println(" 1. int v;\n    v=2;\n    Print(v)\n");
        System.out.println(" 2. int a;\n    int b;\n    a=2+3*5;\n    b=a+1;\n    Print(b)\n");
        System.out.println(" 3. bool a;\n    int v;\n    a=true;\n    (If a Then v=2 Else v=3);\n    Print(v)\n");
        System.out.println(" 0. Exit\n");
    }

    public void initializeProgramState(InterfaceStatement originalPrg) {
        MyInterfaceStack<InterfaceStatement> exeStack = new MyStack<>();
        MyInterfaceDictionary<String, Value> symTable = new MyDictionary<>();
        MyInterfaceList<Value> out = new MyList<>();
        ProgramState prg = new ProgramState(exeStack, symTable, out, originalPrg );
        this.service.addService(prg);
        this.service.allStep();
    }

    public void run() {
        InterfaceStatement ex;
        label:
        while (true) {
            menu();
            Scanner myObj = new Scanner(System.in);
            System.out.println("Give the command: ");
            String option = myObj.nextLine(); //option =1-2-3
            switch (option) {
                case "1":
                    ex = new CompoundStatement(new VariableDeclarationStatement("v", new IntType()), new CompoundStatement(new AssignmentStatement("v", new ValueExpression(new IntValue(2))), new PrintStatement(new VariableExpression("v"))));
                    System.out.println(ex);
                    initializeProgramState(ex);
                    break;
                case "2":
                    //op=1 if we have '+'
                    //op=3 if we have '*'
                    ex = new CompoundStatement(new VariableDeclarationStatement("a", new IntType()), new CompoundStatement(new VariableDeclarationStatement("b", new IntType()), new CompoundStatement(new AssignmentStatement("a", new ArithmeticExpression(1, new ValueExpression(new IntValue(2)), new ArithmeticExpression(3, new ValueExpression(new IntValue(3)), new ValueExpression(new IntValue(5))))), new CompoundStatement(new AssignmentStatement("b", new ArithmeticExpression(1, new VariableExpression("a"), new ValueExpression(new IntValue(1)))), new PrintStatement(new VariableExpression("b"))))));
                    System.out.println(ex);
                    initializeProgramState(ex);
                    break;
                case "3":
                    ex = new CompoundStatement(new VariableDeclarationStatement("a", new BoolType()), new CompoundStatement(new VariableDeclarationStatement("v", new IntType()), new CompoundStatement(new AssignmentStatement("a", new ValueExpression(new BoolValue(false))), new CompoundStatement(new IfStatement(new VariableExpression("a"), new AssignmentStatement("v", new ValueExpression(new IntValue(2))), new AssignmentStatement("v", new ValueExpression(new IntValue(3)))), new PrintStatement(new VariableExpression("v"))))));
                    System.out.println(ex);
                    initializeProgramState(ex);
                    break;
                case "0":
                    break label;
            }

        }
    }
}
