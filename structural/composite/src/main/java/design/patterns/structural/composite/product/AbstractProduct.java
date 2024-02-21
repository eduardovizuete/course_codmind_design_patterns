package design.patterns.structural.composite.product;

public abstract class AbstractProduct {
    
    private String name;
    private double price;

    public AbstractProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void printOrder(){
        System.out.println(this.name + ", " + this.price);
    }
    
}
