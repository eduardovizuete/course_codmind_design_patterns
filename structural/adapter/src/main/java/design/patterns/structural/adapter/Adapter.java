package design.patterns.structural.adapter;

import design.patterns.structural.adapter.impl.BankCreditRequest;
import design.patterns.structural.adapter.impl.BankCreditResponse;
import design.patterns.structural.adapter.impl.XBankCreditAdapter;
import design.patterns.structural.adapter.impl.YBankCreditAdapter;

public class Adapter {

    public static void main(String[] args) {
        BankCreditRequest request = new BankCreditRequest();
        request.setAmount(2000);
        request.setCustomer("Cliente");
        
        XBankCreditAdapter xBank = new XBankCreditAdapter();
        BankCreditResponse xResponse = xBank.sendCreditRequest(request);
        System.out.println("XBank approval => " + xResponse.isApproved());
        
        YBankCreditAdapter yBank = new YBankCreditAdapter();
        BankCreditResponse yResponse = yBank.sendCreditRequest(request);
        System.out.println("YBank approval => " + yResponse.isApproved());
    }
}
