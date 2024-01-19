package design.patterns.creational.abstractfactory.services.impl.rest;

import design.patterns.creational.abstractfactory.services.IProductService;

public class ProductServiceRestImpl implements IProductService {

    @Override
    public String[] getProducts() {
        System.out.println("ProductServiceRestImpl.getProducts => ");
        String[] results = new String[]{"Product 1", "Product 2"};
        return results;
    }
    
}
