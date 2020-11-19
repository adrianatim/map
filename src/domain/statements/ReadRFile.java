package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceTable;
import domain.expressions.Expression;
import domain.type.StringType;
import domain.values.IntValue;
import domain.values.StringValue;
import domain.values.Value;
import exceptions.MyException;
import exceptions.VariableNotDefined;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadRFile implements InterfaceStatement {

    private final Expression exp;
    private final String varName;

    public ReadRFile(Expression exp, String varName) {
        this.exp = exp;
        this.varName = varName;
    }

    public Expression getExp() {
        return exp;
    }

    public String getVarName() {
        return varName;
    }

    //reading from file
    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceTable<String, BufferedReader> fileTable = state.getFileTable();
        MyInterfaceDictionary<String, Value> symTable = state.getSymTable();

        if (!symTable.isDefined(this.varName)) {
            throw new VariableNotDefined("The variable wasn't defined!");
        } else {
            StringValue stringValue = (StringValue) this.exp.eval(symTable);
            StringType strType = (StringType) stringValue.getType();
            if (!strType.toString().equals("string")) {
                throw new MyException("The expression must be a string!");
            } else {
                String filename = stringValue.getStr();
                try {
                    BufferedReader fileReader = fileTable.getBufferedReader(filename);
                    String line = fileReader.readLine();
                    if (line == null) {
                        symTable.update(varName, new IntValue(0));
                    } else {
                        String newStr = line.replace("<NL>", "");
                        symTable.update(varName, new IntValue(Integer.parseInt(newStr)));
                    }
                } catch (Exception e) {
                    throw new MyException("The file doesn't exists!");
                }
            }
        }
        return state;
    }


    @Override
    public String
    toString() {
        return "ReadRFile(" + exp + ", " + varName + ")";
    }
}
