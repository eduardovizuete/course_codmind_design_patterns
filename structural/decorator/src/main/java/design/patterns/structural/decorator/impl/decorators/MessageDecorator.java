package design.patterns.structural.decorator.impl.decorators;

import design.patterns.structural.decorator.impl.message.IMessage;

public abstract class MessageDecorator implements IMessage {
    
    protected IMessage message;

    public MessageDecorator(IMessage message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent();
    }

    @Override
    public void setContent(String content) {
        message.setContent(content);
    }
    
}
