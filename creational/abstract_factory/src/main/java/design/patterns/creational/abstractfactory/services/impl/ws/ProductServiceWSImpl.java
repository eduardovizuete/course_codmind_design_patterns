package design.patterns.creational.abstractfactory.services.impl.ws;

import design.patterns.creational.abstractfactory.services.IProductService;

public class ProductServiceWSImpl implements IProductService {

    @Override
    public String[] getProducts() {
        System.out.println("ProductServiceWSImpl.getProducts => ");
        String[] results = new String[]{"Product 1", "Product 2"};
        return results;
    }
    
}
