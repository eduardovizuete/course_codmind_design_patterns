package design.patterns.creational.abstractfactory.services.impl.rest;

import design.patterns.creational.abstractfactory.services.IEmployeeService;

public class EmployeeServiceRestImpl implements IEmployeeService {
    
    @Override
    public String[] getEmployee() {
        System.out.println("EmployeeServiceRestImpl.getEmployee => ");
        String[] results = new String[]{"Employee1 ", "Employee 2"};
        return results;
    }
    
}
