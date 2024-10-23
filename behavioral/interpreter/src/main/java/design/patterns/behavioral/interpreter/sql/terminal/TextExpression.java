package design.patterns.behavioral.interpreter.sql.terminal;

import design.patterns.behavioral.interpreter.sql.Context;

public class TextExpression extends LiteralExpression {

    public TextExpression(String literal) {
        super(literal);
    }

    @Override
    public String interpret(Context context) {
        return literal;
    }

    @Override
    public String toString() {
        return "'" + literal + "'";
    }

}
