package design.patterns.behavioral.iterator;

import design.patterns.behavioral.iterator.impl.Employee;
import design.patterns.behavioral.iterator.impl.IIterator;

public class Iterator {

    public static void main(String[] args) {
        Employee employee = new Employee("Juan", "CEO",
                new Employee("Pedro", "President",
                        new Employee("Liliana", "VP",
                                new Employee("Oscar", "Manager",
                                        new Employee("Mario", "Developer"),
                                        new Employee("Rodolfo", "Developer")),
                                new Employee("Sofia", "Manager",
                                        new Employee("Adrian", "Sr Developer"),
                                        new Employee("Rebeca", "Developer")
                                )
                        )
                )
        );

        IIterator<Employee> empIterator = employee.createIterator();
        while (empIterator.hasNext()) {
            Employee emp = empIterator.next();
            System.out.println("emp > " + emp.toString());
        }
    }
    
}
