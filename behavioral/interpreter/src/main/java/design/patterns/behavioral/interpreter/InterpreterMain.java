package design.patterns.behavioral.interpreter;

import design.patterns.behavioral.interpreter.sql.Context;
import design.patterns.behavioral.interpreter.sql.InterpreterException;
import design.patterns.behavioral.interpreter.sql.nonterminal.*;
import design.patterns.behavioral.interpreter.sql.terminal.DateExpression;
import design.patterns.behavioral.interpreter.sql.terminal.LiteralExpression;
import design.patterns.behavioral.interpreter.sql.terminal.NumericExpression;
import design.patterns.behavioral.interpreter.sql.terminal.TextExpression;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class InterpreterMain {

    public static void main(String[] args) {
        //Abstract Syntactic Tree
        //SelectExpression select = getById();
        //SelectExpression select = findByDate();
        //SelectExpression select = findByTwoID();
        SelectExpression select = complexQuery();
        System.out.println(select);
        Context context = new Context("META-INF/Employee.xls");
        context.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        try {
            List<Object[]> output = select.interpret(context);
            for (Object[] object : output) {
                System.out.println(Arrays.toString(object));
            }
        } catch (InterpreterException e) {
            e.printStackTrace();
        } finally {
            context.destroy();
        }
    }

    public static SelectExpression getById() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new BooleanExpression(
                                new LiteralExpression("ID"),
                                new LiteralExpression("="),
                                new NumericExpression(10)
                        )
                )
        );
        return select;
    }

    public static SelectExpression findByDate() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("ID"),
                        new LiteralExpression("BORN_DATE"),
                        new LiteralExpression("DEPARTMENT"),
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new BooleanExpression(
                                new LiteralExpression("BORN_DATE"),
                                new LiteralExpression(">"),
                                new DateExpression("01/01/1990")
                        )
                )
        );
        return select;
    }

    public static SelectExpression findByTwoID() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(

                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("DEPARTMENT"),
                        new LiteralExpression("ID")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new OrExpression(
                                new BooleanExpression(
                                        new LiteralExpression("ID"),
                                        new LiteralExpression("="),
                                        new NumericExpression(5)
                                ),
                                new BooleanExpression(
                                        new LiteralExpression("ID"),
                                        new LiteralExpression("="),
                                        new NumericExpression(14)
                                )
                        )
                )
        );
        return select;
    }

    public static SelectExpression complexQuery() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new AndExpression(
                                new BooleanExpression(
                                        new LiteralExpression("STATUS"),
                                        new LiteralExpression("="),
                                        new TextExpression("Active")
                                ),
                                new AndExpression(
                                        new BooleanExpression(
                                                new LiteralExpression("BORN_DATE"),
                                                new LiteralExpression("<="),
                                                new DateExpression("01/01/1981")
                                        ),
                                        new OrExpression(
                                                new BooleanExpression(
                                                        new LiteralExpression("DEPARTMENT"),
                                                        new LiteralExpression("="),
                                                        new TextExpression("IT")
                                                ),
                                                new BooleanExpression(
                                                        new LiteralExpression("DEPARTMENT"),
                                                        new LiteralExpression("="),
                                                        new TextExpression("Accounting")
                                                )
                                        )
                                )
                        )
                )
        );
        return select;
    }

}