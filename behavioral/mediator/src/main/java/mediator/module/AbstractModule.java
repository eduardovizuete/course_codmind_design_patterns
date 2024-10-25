package mediator.module;

public abstract class AbstractModule {

    protected ModuleMediator mediator;

    public abstract String getModuleName();

    public void activate() {
        mediator = ModuleMediator.getInstance();
        mediator.registerModule(this);
    }

    public abstract Object notifyMessage(ModuleMessage message);

}
