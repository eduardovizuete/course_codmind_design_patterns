package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.AbstractSQLExpression;
import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;

public class WhereExpression implements AbstractSQLExpression {

    private StatementExpression statement;

    public WhereExpression(StatementExpression statement) {
        this.statement = statement;
    }

    @Override
    public Void interpret(Context context) throws InterpreterException {
        context.createRowIterator();
        while (context.nextRow()) {
            if (statement == null) {
                context.addCurrentRowToResults();
            } else {
                Boolean result = (Boolean) statement.interpret(context);
                if (result) {
                    context.addCurrentRowToResults();
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (statement != null) {
            return "\nWHERE " + statement.toString();
        } else {
            return "";
        }
    }
}