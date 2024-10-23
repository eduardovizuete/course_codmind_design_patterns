package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;

public class OrExpression implements StatementExpression {

    private StatementExpression leftStatement;
    private StatementExpression rightStatement;

    public OrExpression(StatementExpression leftStatement,
                        StatementExpression rightStatement) {
        this.leftStatement = leftStatement;
        this.rightStatement = rightStatement;
    }

    @Override
    public Object interpret(Context context) throws InterpreterException {
        Boolean leftResult = (Boolean) leftStatement.interpret(context);
        Boolean rightResult = (Boolean) rightStatement.interpret(context);
        return leftResult || rightResult;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("( ")
                .append(leftStatement.toString())
                .append(" OR ")
                .append(rightStatement.toString())
                .append(" )").toString();
    }

}