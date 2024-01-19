package design.patterns.creational.abstractfactory.services.impl.rest;

import design.patterns.creational.abstractfactory.impl.IServiceStackAbstractFactory;
import design.patterns.creational.abstractfactory.services.IEmployeeService;
import design.patterns.creational.abstractfactory.services.IProductService;

public class RestServiceStackImpl implements IServiceStackAbstractFactory{

    @Override
    public IEmployeeService getEmployeeService() {
        return new EmployeeServiceRestImpl();
    }

    @Override
    public IProductService getProductService() {
        return new ProductServiceRestImpl();
    }
    
}
