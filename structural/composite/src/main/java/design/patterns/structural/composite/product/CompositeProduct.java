package design.patterns.structural.composite.product;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends AbstractProduct {
    
    private List<AbstractProduct> products;
        
    public CompositeProduct(String name, double price) {
        super(name, price);
        products = new ArrayList<>();
    }

    public List<AbstractProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AbstractProduct> products) {
        this.products = products;
    }
    
    public void addProduct(AbstractProduct product){
        products.add(product);
    }
    
    public void removeProduct(AbstractProduct product){
        products.remove(product);
    }

    @Override
    public double getPrice() {
        double price = 0;
        price = products.stream()
                .map(prod -> prod.getPrice())
                .reduce(price, (accumulator, itemPrice) -> accumulator + itemPrice);
        return price;
    }

    @Override
    public void printOrder() {
        System.out.println("Package " + this.getName() + " =>");
        for(AbstractProduct current : products){
            current.printOrder();
        }
        System.out.println("End package " + this.getName() + " =>");
    }
    
}
