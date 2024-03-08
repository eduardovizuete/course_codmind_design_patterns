package design.patterns.structural.facade;

import design.patterns.structural.facade.impl.IPaymentFacade;
import design.patterns.structural.facade.impl.PaymentFacadeImpl;
import design.patterns.structural.facade.impl.PaymentRequest;
import design.patterns.structural.facade.impl.PaymentResponse;

public class Facade {

    public static void main(String[] args) {
        try {
            IPaymentFacade facade = new PaymentFacadeImpl();
            
            PaymentRequest request =new PaymentRequest();
            request.setAmount(500);
            request.setCardExpDate("10/2015");
            request.setCardName("Oscar Blancarte");
            request.setCardNumber("1234567890123456");
            request.setCardSecureNumber("345");
            request.setCustomerId(4L);
            
            PaymentResponse response = facade.pay(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
