package design.patterns.structural.facade.subsystems.crm;

import design.patterns.structural.facade.util.Customer;
import design.patterns.structural.facade.util.OnMemoryDataBase;

public class CRMSystem {

    public Customer findCustomer(Long customerId){
        return OnMemoryDataBase.findCustomerById(customerId);
    }
    
}
