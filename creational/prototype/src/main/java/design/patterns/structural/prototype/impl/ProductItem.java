package design.patterns.structural.prototype.impl;

public class ProductItem implements IPrototype<ProductItem> {
    
    private String name;
    
    private double price;
    
    public ProductItem(){
    }

    public ProductItem(String name, double price) {
        this();
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

    @Override
    public ProductItem clone() {
        return new ProductItem(this.name, this.price);
    }

    @Override
    public ProductItem deepClone() {
        return clone();
    }

    @Override
    public String toString() {
        return "ProductItem{" + "name=" + name + ", price=" + price + '}';
    }
    
}
