package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.AbstractSQLExpression;
import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;

public interface StatementExpression extends AbstractSQLExpression {

    @Override
    public Object interpret(Context context)throws InterpreterException;

}