package design.patterns.structural.adapter.impl;

import design.patterns.structural.adapter.creditapi.bankx.XBankCreditAPI;
import design.patterns.structural.adapter.creditapi.bankx.XBankCreditRequest;
import design.patterns.structural.adapter.creditapi.bankx.XBankCreditResponse;

public class XBankCreditAdapter implements IBankAdapter {

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        XBankCreditAPI api = new XBankCreditAPI();

        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());

        XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);

        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(xresponse.isAproval());

        return response;
    }

}
