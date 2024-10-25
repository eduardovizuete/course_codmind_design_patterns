package mediator.module.impl;

import mediator.module.AbstractModule;
import mediator.module.ModuleMessage;

public class PurchaseModule extends AbstractModule {

    public static final String MODULE_NAME = "Shopping";
    public static final String OPERATION_PURCHASE_REQUEST = "PurchaseRequest";

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_PURCHASE_REQUEST:
                return purchaseRequest(message);
            default:
                throw new RuntimeException(
                        new StringBuilder()
                                .append("Operation not supported '")
                                .append(message.getMessageType())
                                .append("'").toString());
        }
    }

    private Void purchaseRequest(ModuleMessage message){
        return null;
    }

}