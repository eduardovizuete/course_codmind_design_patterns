package design.patterns.creational.abstractfactory.services.impl.ws;

import design.patterns.creational.abstractfactory.impl.IServiceStackAbstractFactory;
import design.patterns.creational.abstractfactory.services.IEmployeeService;
import design.patterns.creational.abstractfactory.services.IProductService;

public class WSServiceStackImpl implements IServiceStackAbstractFactory {

    @Override
    public IEmployeeService getEmployeeService() {
        return new EmployeeServiceWSImpl();
    }

    @Override
    public IProductService getProductService() {
        return new ProductServiceWSImpl();
    }
    
}
