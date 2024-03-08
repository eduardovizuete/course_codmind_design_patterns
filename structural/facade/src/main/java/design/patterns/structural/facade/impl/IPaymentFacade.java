package design.patterns.structural.facade.impl;

public interface IPaymentFacade {

    public PaymentResponse pay(PaymentRequest request) throws PaymentException;
    
}
