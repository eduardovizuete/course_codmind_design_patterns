package design.patterns.behavioral.interpreter.sql;

public interface AbstractSQLExpression {

    public Object interpret(Context context) throws InterpreterException;

}
