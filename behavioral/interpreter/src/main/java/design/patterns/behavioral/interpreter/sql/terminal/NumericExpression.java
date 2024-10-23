package design.patterns.behavioral.interpreter.sql.terminal;

import design.patterns.behavioral.interpreter.sql.Context;

public class NumericExpression extends LiteralExpression {

    private final Number number;

    public NumericExpression(Number num){
        super(null);
        this.number = num;
    }

    @Override
    public Object interpret(Context context) {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

}
