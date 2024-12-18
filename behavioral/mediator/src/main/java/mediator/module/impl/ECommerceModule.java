package mediator.module.impl;

import mediator.module.AbstractModule;
import mediator.module.ModuleMessage;
import mediator.module.impl.dto.Sale;
import mediator.module.impl.dto.SaleOrder;

public class ECommerceModule extends AbstractModule {

    public static final String MODULE_NAME = "ECommerce";

    public static final String OPERATION_COMPLETE_ORDER = "CompleteOrder";

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_COMPLETE_ORDER:
                return completeOrder(message);
            default:
                throw new RuntimeException(
                        new StringBuilder()
                                .append("Operation not supported '")
                                .append(message.getMessageType())
                                .append("'").toString());
        }
    }

    private String completeOrder(ModuleMessage message) {
        SaleOrder saleOrder = (SaleOrder) message.getPayload();
        System.out.println("Order completed successfully > ");

        ModuleMessage crmMessage = new ModuleMessage(MODULE_NAME,
                NotifyModule.MODULE_NAME, NotifyModule.OPERATION_NOTIFY,
                saleOrder);

        mediator.mediate(crmMessage);
        return saleOrder.getId();
    }

    public String createSale(Sale sale) {
        ModuleMessage crmMessage = new ModuleMessage(MODULE_NAME,
                CRMModule.MODULE_NAME, CRMModule.OPERATION_CREATE_ORDER, sale);
        return mediator.mediate(crmMessage).toString();
    }

}