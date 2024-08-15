package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.CreditData;
import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;

public class CreditValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        double total = order.getTotal();
        CreditData creditData = order.getContributor().getCreditData();
        double newBalance = creditData.getBalance() + total;
        if (newBalance > creditData.getCreditLimit()) {
            throw new ValidationException("The amount of the order  "
                    + "exceeds the available credit limit");
        }
    }

}
