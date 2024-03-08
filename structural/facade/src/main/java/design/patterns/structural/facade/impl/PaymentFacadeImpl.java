package design.patterns.structural.facade.impl;

import design.patterns.structural.facade.subsystems.bank.BankSystem;
import design.patterns.structural.facade.subsystems.bank.TransferRequest;
import design.patterns.structural.facade.subsystems.biller.BillingPayRequest;
import design.patterns.structural.facade.subsystems.biller.BillingSystem;
import design.patterns.structural.facade.subsystems.crm.CRMSystem;
import design.patterns.structural.facade.subsystems.email.EmailSystem;
import design.patterns.structural.facade.util.Customer;
import design.patterns.structural.facade.util.OnMemoryDataBase;
import java.util.HashMap;
import java.util.Map;

public class PaymentFacadeImpl implements IPaymentFacade {

    private final BankSystem bankSystem = new BankSystem();
    private final BillingSystem billingSystem = new BillingSystem();
    private final CRMSystem crmSystem = new CRMSystem();
    private final EmailSystem emailSystem = new EmailSystem();
    
    @Override
    public PaymentResponse pay(PaymentRequest request) throws PaymentException {
        try {
            Customer customer = crmSystem.findCustomer(request.getCustomerId());
            if(customer == null){
                throw new PaymentException("Cliente no existe");
            }else if(customer.getStatus().equals("Baja")){
                throw new PaymentException("El cliente esta dado de baja");
            }
            
            TransferRequest bankRequest = new TransferRequest(
                request.getAmount(), 
                request.getCardNumber(), 
                request.getCardName(), 
                request.getCardExpDate(), 
                request.getCardSecureNumber());
            String payRefence = bankSystem.transfer(bankRequest);
            
            BillingPayRequest billingRequest = new BillingPayRequest(request.getCustomerId(), request.getAmount());
            double newBalance = billingSystem.pay(billingRequest);
            
            String newStatus = customer.getStatus();
            if(newBalance <= 50){
                newStatus = "Activo";
                OnMemoryDataBase.changeCustomerStatus(request.getCustomerId(), newStatus);
            }
            
            Map<String, String> params = new HashMap<>();
            params.put("$name", customer.getName());
            params.put("$amount", request.getAmount()+"");
            params.put("$newBalance", newBalance+"");
            String number = request.getCardNumber();
            String sufix = number.substring(number.length()-4, number.length());
            params.put("$cardNumber", sufix);
            params.put("$reference", payRefence);
            params.put("$newStatus", newStatus);
            emailSystem.sendEmail(params);
            
            PaymentResponse response = new PaymentResponse(
                    payRefence,
                    newBalance,
                    newStatus);
            
            return response;
        } catch (Exception e) {
            throw new PaymentException(e.getMessage());
        }
    }
    
}
