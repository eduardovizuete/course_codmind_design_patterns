package mediator.module.impl.dto;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    protected List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

}
