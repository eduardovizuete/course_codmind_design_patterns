package design.patterns.structural.decorator.impl.decorators;

import design.patterns.structural.decorator.impl.message.IMessage;

public class SOAPEnvelopeMessage extends MessageDecorator {

    public SOAPEnvelopeMessage(IMessage message) {
        super(message);
    }

    @Override
    public IMessage processMessage() {
        message.processMessage();
        message = envelopMessage(); 
        return message;
    }

    private IMessage envelopMessage() {
        String soap = "<soapenv:Envelope xmlns:soapenv="
                + "\n\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "\nxmlns:ser=\"http://service.dishweb.cl.com/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + message.getContent()
                + "\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        message.setContent(soap);
        return message;
    }
    
}
