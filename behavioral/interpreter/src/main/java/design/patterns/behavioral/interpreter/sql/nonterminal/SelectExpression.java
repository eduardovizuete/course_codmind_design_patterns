package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.AbstractSQLExpression;
import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;

import java.util.List;

public class SelectExpression implements AbstractSQLExpression {

    private final TargetExpression target;
    private final FromExpression from;
    private final WhereExpression where;

    public SelectExpression(TargetExpression columns,
                            FromExpression table,
                            WhereExpression where) {
        this.target = columns;
        this.from = table;
        this.where = where;
    }

    public SelectExpression(TargetExpression columns,
                            FromExpression table) {
        this.target = columns;
        this.from = table;
        this.where = new WhereExpression(null);
    }

    @Override
    public List<Object[]> interpret(Context context)
            throws InterpreterException {
        from.interpret(context);
        where.interpret(context);
        target.interpret(context);
        return context.getResultArray();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("SELECT ")
                .append(target.toString()).append(" ")
                .append(from.toString()).append(" ")
                .append(where.toString()).toString();
    }

}
