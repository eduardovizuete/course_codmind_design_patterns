package design.patterns.creational.abstractfactory;

import design.patterns.creational.abstractfactory.impl.IServiceStackAbstractFactory;
import design.patterns.creational.abstractfactory.impl.ServiceStackAbstractFactory;
import design.patterns.creational.abstractfactory.services.IEmployeeService;
import design.patterns.creational.abstractfactory.services.IProductService;
import java.util.Arrays;

public class AbstractFactory {

    public static void main(String[] args) {
        //IServiceStackAbstractFactory factory = 
        //        ServiceStackAbstractFactory.createServiceFactory(ServiceType.RESTFul);
        IServiceStackAbstractFactory factory = 
                ServiceStackAbstractFactory.createServiceFactory();
        
        IEmployeeService employeeService = factory.getEmployeeService();
        IProductService productService = factory.getProductService();
        
        String[] employee = employeeService.getEmployee();
        Arrays.stream(employee).forEach(System.out::println);
        
        String[] products = productService.getProducts();
        Arrays.stream(products).forEach(System.out::println);
    }
    
}
