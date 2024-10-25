package mediator.module.impl;

import mediator.module.AbstractModule;
import mediator.module.ModuleMessage;

public class NotifyModule extends AbstractModule {

    public static final String MODULE_NAME = "Notification";
    public static final String OPERATION_NOTIFY = "Notify";

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public Void notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_NOTIFY:
                return notify(message);
            default:
                throw new RuntimeException(
                        new StringBuilder()
                                .append("Operation not supported '")
                                .append(message.getMessageType())
                                .append("'").toString());
        }
    }

    private Void notify(ModuleMessage message) {
        System.out.println("Notification sent");
        return null;
    }

}
