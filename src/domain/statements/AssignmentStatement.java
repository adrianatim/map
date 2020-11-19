package domain.statements;

import domain.ProgramState;
import domain.adt.MyInterfaceDictionary;
import domain.adt.MyInterfaceStack;
import domain.expressions.Expression;
import domain.type.Type;
import domain.values.Value;
import exceptions.MyException;

public class AssignmentStatement implements InterfaceStatement {

    private final String id;
    private final Expression exp;

    public AssignmentStatement(String id, Expression e) {
        this.exp = e;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id + "=" + this.exp.toString();
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        MyInterfaceDictionary<String, Value> symTable = state.getSymTable();
        MyInterfaceStack<InterfaceStatement> stack = state.getExeStack();

        if (symTable.isDefined(id)) {
            Value val = this.exp.eval(symTable);
            Type typeId = symTable.lookup(id).getType();
            if (val.getType().equals(typeId))
                symTable.update(id, val);
            else
                throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");
        } else throw new MyException("the used variable" + id + " was not declared before");
        return state;
    }
}
