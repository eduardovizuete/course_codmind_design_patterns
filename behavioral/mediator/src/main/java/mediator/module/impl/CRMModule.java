package mediator.module.impl;

import mediator.module.AbstractModule;
import mediator.module.ModuleMessage;
import mediator.module.impl.dto.Sale;
import mediator.module.impl.dto.SaleOrder;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRMModule extends AbstractModule {

    public static final String MODULE_NAME = "CRM";

    public static final String OPERATION_CREATE_ORDER = "CreateOrder";

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_CREATE_ORDER:
                return createSaleOrder(message);
            default:
                throw new RuntimeException(
                        new StringBuilder()
                                .append("Operation not supported '")
                                .append(message.getMessageType())
                                .append("'").toString());
        }
    }

    private String createSaleOrder(ModuleMessage event) {
        Sale sale = (Sale) event.getPayload();
        String ID = UUID.randomUUID().toString();
        System.out.println("Sales order successfully created");
        final SaleOrder saleOrder = new SaleOrder(ID);
        saleOrder.setProducts(sale.getProducts());

        ModuleMessage stockEvent = new ModuleMessage(MODULE_NAME,
                StockModule.MODULE_NAME, StockModule.OPERATION_DECREMENT_STOCK,
                saleOrder);
        mediator.mediate(stockEvent);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 10);
                    ModuleMessage stockEvent = new ModuleMessage(MODULE_NAME,
                            ECommerceModule.MODULE_NAME,
                            ECommerceModule.OPERATION_COMPLETE_ORDER,
                            saleOrder);
                    mediator.mediate(stockEvent);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CRMModule.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }).start();

        return ID;
    }

}