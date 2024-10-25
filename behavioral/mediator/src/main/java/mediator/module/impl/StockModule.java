package mediator.module.impl;

import mediator.module.AbstractModule;
import mediator.module.ModuleMessage;
import mediator.module.impl.dto.Product;
import mediator.module.impl.dto.ProductRequest;
import mediator.module.impl.dto.SaleOrder;

public class StockModule extends AbstractModule {

    public static final String MODULE_NAME = "Stock";
    public static final String OPERATION_DECREMENT_STOCK = "DecrementStock";

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_DECREMENT_STOCK:
                return decrementStock(message);
            default:
                throw new RuntimeException(
                        new StringBuilder()
                                .append("Operation not supported '")
                                .append(message.getMessageType())
                                .append("'").toString());
        }
    }

    private Void decrementStock(ModuleMessage message) {
        SaleOrder saleOrder = (SaleOrder) message.getPayload();
        for (Product product : saleOrder.getProducts()) {
            System.out.println("decrement product > " + product.getName());
        }

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProducts(saleOrder.getProducts());

        ModuleMessage purchaseMessage = new ModuleMessage(MODULE_NAME,
                PurchaseModule.MODULE_NAME,
                PurchaseModule.OPERATION_PURCHASE_REQUEST, productRequest);
        mediator.mediate(purchaseMessage);
        return null;
    }

}
