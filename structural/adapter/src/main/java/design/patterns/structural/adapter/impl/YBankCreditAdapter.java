package design.patterns.structural.adapter.impl;

import design.patterns.structural.adapter.creditapi.banky.YBankCreditApprove;
import design.patterns.structural.adapter.creditapi.banky.YBankCreditApproveResult;
import design.patterns.structural.adapter.creditapi.banky.YBankCreditSender;
import design.patterns.structural.adapter.creditapi.banky.YBankCreditSenderListener;

public class YBankCreditAdapter implements IBankAdapter, YBankCreditSenderListener {

    private YBankCreditApproveResult yresult;
    
    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        YBankCreditSender api = new YBankCreditSender();
        
        YBankCreditApprove yrequest = new YBankCreditApprove();
        yrequest.setCredit((float)request.getAmount());
        yrequest.setName(request.getCustomer());
        
        api.sendCreditForValidate(yrequest, this);
        
        do{
            try {
                Thread.sleep(10000);
                System.out.println("yBank wait for response");
            } catch (Exception e) {}
        }while(yresult == null);
        
        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(yresult.getApproved().equalsIgnoreCase("Y"));
        return response;
    }

    @Override
    public void notifyCreditResult(YBankCreditApproveResult result) {
        this.yresult = result;
    }
    
    
    
}
