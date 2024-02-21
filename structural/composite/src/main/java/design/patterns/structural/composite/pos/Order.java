package design.patterns.structural.composite.pos;

import design.patterns.structural.composite.product.AbstractProduct;
import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private long orderId;
    private String customer;
    private List<AbstractProduct> products;

    public Order(long orderId, String customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }
    
    public void addProduct(AbstractProduct product){
        this.products.add(product);
    }
    
    public double getTotal(){
        double total = 0;
        total = products.stream()
                .map(prod -> prod.getPrice())
                .reduce(total, (accumulator, priceProd) -> accumulator + priceProd);
        return total;
    }
    
    public void printOrder(){
        System.out.println("OrderID => " + this.orderId);
        System.out.println("Customer => " + this.customer);
        System.out.println("Products => ");
        
        products.stream().forEach(prod -> {
            System.out.println("\t");
            prod.printOrder();
        });
        
        System.out.println("Total ==> " + this.getTotal());
    }
    
}
