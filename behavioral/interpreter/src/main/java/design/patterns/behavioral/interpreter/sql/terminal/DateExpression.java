package design.patterns.behavioral.interpreter.sql.terminal;

import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;

import java.text.SimpleDateFormat;

public class DateExpression extends LiteralExpression {

    public DateExpression(String literal) {
        super(literal);
    }

    @Override
    public Object interpret(Context context) throws InterpreterException {
        try {
            SimpleDateFormat dateFormat = context.getDateFormat();
            return dateFormat.parse(literal);
        } catch (Exception e) {
            throw new InterpreterException("Invalid date format '"+literal+"'");
        }
    }

    @Override
    public String toString() {
        return "'"+literal+"'";
    }
}
