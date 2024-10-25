package mediator;

import mediator.module.impl.*;
import mediator.module.impl.dto.Product;
import mediator.module.impl.dto.Sale;

public class MediatorMain {

    public static void main(String[] args) {
        new CRMModule().activate();
        new NotifyModule().activate();
        new StockModule().activate();
        new PurchaseModule().activate();

        ECommerceModule client = new ECommerceModule();
        client.activate();

        Sale sale = new Sale();
        for (int c = 0; c < 5; c++) {
            sale.addProduct(new Product("Product" + (c + 1)));
        }

        client.createSale(sale);
    }

}