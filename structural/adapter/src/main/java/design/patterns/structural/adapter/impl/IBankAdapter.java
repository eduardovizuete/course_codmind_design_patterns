package design.patterns.structural.adapter.impl;

public interface IBankAdapter {

    public BankCreditResponse sendCreditRequest(BankCreditRequest request);
    
}
