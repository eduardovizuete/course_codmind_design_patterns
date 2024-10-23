package design.patterns.behavioral.interpreter.sql.terminal;

import design.patterns.behavioral.interpreter.sql.AbstractSQLExpression;
import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;

public class LiteralExpression implements AbstractSQLExpression {

    protected String literal;

    public LiteralExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public Object interpret(Context context) throws InterpreterException {
        return literal;
    }

    @Override
    public String toString() {
        return literal;
    }

}
