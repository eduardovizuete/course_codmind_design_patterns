package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.AbstractSQLExpression;
import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;
import design.patterns.behavioral.interpreter.sql.terminal.LiteralExpression;

import java.util.List;

public class FromExpression implements AbstractSQLExpression {

    private LiteralExpression table;

    public FromExpression(LiteralExpression from) {
        this.table = from;
    }

    @Override
    public Object interpret(Context context) throws InterpreterException {
        String tableName = table.interpret(context).toString();
        if (!context.tableExist(tableName)) {
            throw new InterpreterException("The table '" + tableName + "' not exist");
        }
        return null;
    }

    @Override
    public String toString() {
        return "FROM " + table.toString();
    }
}