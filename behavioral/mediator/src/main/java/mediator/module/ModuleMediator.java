package mediator.module;

import java.util.HashMap;
import java.util.Map;

public class ModuleMediator {

    private static ModuleMediator mediator;

    private static final Map<String, AbstractModule> modules = new HashMap<>();

    private ModuleMediator() {
    }

    public static synchronized ModuleMediator getInstance() {
        if (mediator == null) {
            mediator = new ModuleMediator();
        }

        return mediator;
    }

    public void registerModule(AbstractModule module) {
        modules.put(module.getModuleName(), module);
    }

    public Object mediate(ModuleMessage mediateEvent) {
        if (!modules.containsKey(mediateEvent.getTarget())) {
            throw new RuntimeException(
                    new StringBuilder()
                            .append("El modulo ")
                            .append(mediateEvent.getTarget())
                            .append(" no esta registrado").toString());
        }

        System.out.println(
                new StringBuilder()
                        .append("Mediate source > '").append(mediateEvent.getSource())
                        .append(", target > ").append(mediateEvent.getTarget())
                        .append(", messageType > ").append(mediateEvent.getMessageType())
                        .append("'"));

        AbstractModule module = modules.get(mediateEvent.getTarget());
        return module.notifyMessage(mediateEvent);
    }

}
