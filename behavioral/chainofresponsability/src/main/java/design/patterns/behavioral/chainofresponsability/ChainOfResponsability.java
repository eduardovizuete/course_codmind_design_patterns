package design.patterns.behavioral.chainofresponsability;

import design.patterns.behavioral.chainofresponsability.domain.Address;
import design.patterns.behavioral.chainofresponsability.domain.CreditData;
import design.patterns.behavioral.chainofresponsability.domain.Customer;
import design.patterns.behavioral.chainofresponsability.domain.Product;
import design.patterns.behavioral.chainofresponsability.domain.Status;
import design.patterns.behavioral.chainofresponsability.domain.Telephone;
import design.patterns.behavioral.chainofresponsability.domain.order.OrderItem;
import design.patterns.behavioral.chainofresponsability.domain.order.SalesOrder;
import design.patterns.behavioral.chainofresponsability.validator.AbstractOrderValidator;
import design.patterns.behavioral.chainofresponsability.validator.OrderValidatorBuilder;
import design.patterns.behavioral.chainofresponsability.validator.ValidationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChainOfResponsability {

    public static void main(String[] args) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDeliveryDate(Calendar.getInstance());
        Customer customer = new Customer();
        customer.setName("Oscar Blancarte");
        customer.setRfc("XXX0000000X0");
        customer.setStatus(Status.ACTIVO);

        Telephone phone = new Telephone();
        phone.setExt("123");
        phone.setLada("999");
        phone.setNumber("1234567");
        customer.setTelephone(phone);

        Address address = new Address();
        address.setAddress1("Address 1");
        address.setAddress2("Address 2");
        address.setCP("1234");
        address.setCountry("Mexico");
        customer.setAddress(address);

        CreditData creditData = new CreditData();
        creditData.setBalance(1000);
        creditData.setCreditLimit(13000);
        customer.setCreditData(creditData);

        salesOrder.setContributor(customer);

        List<OrderItem> orderItems = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            OrderItem item = new OrderItem();
            item.setPrice((c + 1) * 30);
            Product product = new Product();
            product.setListPrice((c + 1) * 32);
            product.setName("Product " + (c + 1));
            item.setProduct(product);
            item.setQuantity(c + 1);
            orderItems.add(item);
        }
        
        salesOrder.setOrderItems(orderItems);
        System.out.println("Total orden > " + salesOrder.getTotal());
        
        try {
            AbstractOrderValidator validator
                    = OrderValidatorBuilder.buildSalesOrderValidator();
            validator.validate(salesOrder);
            System.out.println("Successful validation");
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
