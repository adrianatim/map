import controller.Service;
import domain.ProgramState;
import domain.adt.*;
import domain.expressions.ValueExpression;
import domain.expressions.VariableExpression;
import domain.statements.*;
import domain.type.IntType;
import domain.type.StringType;
import domain.values.StringValue;
import domain.values.Value;
import repository.InterfaceRepository;
import repository.Repository;

import java.io.BufferedReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        InterfaceStatement testEx = new CompoundStatement(
                new VariableDeclarationStatement("vertex", new StringType()),
                new CompoundStatement(
                        new AssignmentStatement("vertex", new ValueExpression(new StringValue("resources/test.in"))),
                        new CompoundStatement(new OpenRFile(new VariableExpression("vertex")),
                                new CompoundStatement(new VariableDeclarationStatement("const", new IntType()),
                                        new CompoundStatement(new ReadRFile(new VariableExpression("vertex"), new VariableExpression("const").toString()),
                                                new CompoundStatement(new PrintStatement(new VariableExpression("const")),
                                                        new CompoundStatement(new ReadRFile(new VariableExpression("vertex"), new VariableExpression("const").toString()),
                                                                new PrintStatement(new VariableExpression("const")))))))));
        MyInterfaceStack<InterfaceStatement> exeStackTest = new MyStack<>();
        MyInterfaceDictionary<String, Value> symTableTest = new MyDictionary<>();
        MyInterfaceList<Value> outTest = new MyList<>();
        MyInterfaceTable<String, BufferedReader> fileTableTest = new MyTable<>();
        ProgramState prg = new ProgramState(exeStackTest, symTableTest, outTest, fileTableTest, testEx);
        InterfaceRepository repo = new Repository("log.txt");
        Service srv = new Service(repo, 1);
        srv.addService(prg);
        srv.allStep();
    }
}
