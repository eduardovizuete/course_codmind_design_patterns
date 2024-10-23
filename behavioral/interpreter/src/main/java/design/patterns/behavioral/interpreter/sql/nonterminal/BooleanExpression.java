package design.patterns.behavioral.interpreter.sql.nonterminal;

import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;
import design.patterns.behavioral.interpreter.sql.terminal.DateExpression;
import design.patterns.behavioral.interpreter.sql.terminal.LiteralExpression;
import design.patterns.behavioral.interpreter.sql.terminal.NumericExpression;
import design.patterns.behavioral.interpreter.sql.terminal.TextExpression;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;

public class BooleanExpression implements StatementExpression {

    private final LiteralExpression leftExpression;
    private final LiteralExpression booleanOperator;
    private final LiteralExpression rightExpression;

    public BooleanExpression(LiteralExpression leftExp,
                             LiteralExpression operator, LiteralExpression rightExp) {
        this.leftExpression = leftExp;
        this.booleanOperator = operator;
        this.rightExpression = rightExp;
    }

    @Override
    public Boolean interpret(Context context)
            throws InterpreterException {
        Row currentRow = context.getCurrentRow();

        String left = leftExpression.interpret(context).toString();
        String opr = booleanOperator.interpret(context).toString();
        Object right = rightExpression.interpret(context);

        int columnIndex = context.columnIndex(left);
        Cell cell = currentRow.getCell(columnIndex);

        if (rightExpression instanceof NumericExpression) {
            //cell.setCellType(CellType.NUMERIC);
            double cellValue = cell.getNumericCellValue();
            double rightVal = ((Number) right).doubleValue();
            return switch (opr) {
                case "=" -> cellValue == rightVal;
                case "<>", "!=" -> cellValue != rightVal;
                case ">" -> cellValue > rightVal;
                case ">=" -> cellValue >= rightVal;
                case "<" -> cellValue < rightVal;
                case "<=" -> cellValue <= rightVal;
                default -> throw new RuntimeException(
                        "Unexpected operator '" + opr + "'");
            };
        } else if (rightExpression instanceof DateExpression) {
            //cell.setCellType(CellType.STRING);
            String cellValue = cell.getStringCellValue();
            long cellDateLong;
            long expressionDateLong = ((Date) right).getTime();
            try {
                Date date = context.getDateFormat().parse(cellValue);
                cellDateLong = date.getTime();
            } catch (Exception e) {
                throw new InterpreterException(
                        "Invalid date > " + cellValue);
            }
            return switch (opr) {
                case "=" -> cellDateLong == expressionDateLong;
                case "<>", "!=" -> cellDateLong != expressionDateLong;
                case ">" -> cellDateLong > expressionDateLong;
                case ">=" -> cellDateLong >= expressionDateLong;
                case "<" -> cellDateLong < expressionDateLong;
                case "<=" -> cellDateLong <= expressionDateLong;
                default -> throw new RuntimeException(
                        "Unexpected operator '" + opr + "'");
            };
            // else ((rightExpression instanceof LiteralExpression) ||
            // (rightExpression instanceof TextExpression))
        } else {
            //cell.setCellType(CellType.STRING);
            String cellValue = cell.getStringCellValue();
            String rightVal = right.toString();
            switch (opr) {
                case "=" -> {
                    return cellValue.equals(rightVal);
                }
                case "<>", "!=" -> {
                    return !cellValue.equalsIgnoreCase(rightVal);
                }
                case ">" -> {
                    int result = cellValue.compareToIgnoreCase(rightVal);
                    return result > 0;
                }
                case ">=" -> {
                    int result = cellValue.compareToIgnoreCase(rightVal);
                    return result >= 0;
                }
                case "<" -> {
                    int result = cellValue.compareToIgnoreCase(rightVal);
                    return result < 0;
                }
                case "<=" -> {
                    int result = cellValue.compareToIgnoreCase(rightVal);
                    return result <= 0;
                }
                default -> throw new RuntimeException(
                        "Unexpected operator '" + opr + "'");
            }
        }
    }

    @Override
    public String toString() {
        return leftExpression.toString() + " "
                + booleanOperator.toString() + " "
                + rightExpression.toString();
    }

}