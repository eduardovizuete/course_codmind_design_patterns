package design.patterns.creational.abstractfactory.impl;

import design.patterns.creational.abstractfactory.services.IEmployeeService;
import design.patterns.creational.abstractfactory.services.IProductService;

public interface IServiceStackAbstractFactory {
    
    public IEmployeeService getEmployeeService();
    public IProductService getProductService();
    
}
