package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.AbstractSQLExpression;
import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;
import design.patterns.behavioral.interpreter.sql.terminal.LiteralExpression;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.util.Arrays;
import java.util.List;

public class TargetExpression implements AbstractSQLExpression {

    private final List<LiteralExpression> targets;

    public TargetExpression(LiteralExpression... expressions) {
        this.targets = Arrays.asList(expressions);
    }

    @Override
    public Void interpret(Context context) throws InterpreterException {
        context.createResultArray(targets.size());

        List<Row> resultRow = context.getResultRow();
        for (Row row : resultRow) {
            Object[] result = context.createRow();
            int col = 0;

            for (LiteralExpression literalExpression : targets) {
                String column = literalExpression.interpret(context).toString();
                context.tableColumn(column);
                int columnIndex = context.columnIndex(column);
                Cell cell = row.getCell(columnIndex);
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                result[col++] = value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (LiteralExpression literalExpression : targets) {
            output.append(", ").append(literalExpression.toString());
        }
        return output.substring(2);
    }

}