package design.patterns.structural.decorator;

import design.patterns.structural.decorator.impl.decorators.EncryptMessage;
import design.patterns.structural.decorator.impl.decorators.SOAPEnvelopeMessage;
import design.patterns.structural.decorator.impl.decorators.XMLFormatterDecorator;
import design.patterns.structural.decorator.impl.message.CustomerMessage;
import design.patterns.structural.decorator.impl.message.IMessage;


public class Decorator {

    public static void main(String[] args) {
        CustomerMessage customerMessage = new CustomerMessage(
                "Oscar Blancarte", "oscarblancarte3@gmail.com", "554433445566");
        System.out.println("Original Message ==> " + customerMessage);
        
        IMessage message1 = new EncryptMessage("user", "HG58YZ3CR9123456", 
                new SOAPEnvelopeMessage(
                    new XMLFormatterDecorator(customerMessage))).processMessage();
        System.out.println("message1 =====================================>\n" 
                + message1.getContent() + "\n\n");
        
        IMessage message2 = new SOAPEnvelopeMessage(
                new EncryptMessage("user", "HG58YZ3CR9123456",
                    new XMLFormatterDecorator(customerMessage))).processMessage();
        System.out.println("message2 =====================================>\n" 
                + message2.getContent());
    }
}
