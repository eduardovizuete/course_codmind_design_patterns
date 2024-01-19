package design.patterns.creational.abstractfactory.services.impl.ws;

import design.patterns.creational.abstractfactory.services.IEmployeeService;

public class EmployeeServiceWSImpl implements IEmployeeService{

    @Override
    public String[] getEmployee() {
        System.out.println("EmployeeServiceWSImpl.getEmployee => ");
        String[] results = new String[]{"Employee1 ", "Employee 2"};
        return results;
    }

}
