package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;
import design.patterns.behavioral.chainofresponsability.domain.order.SalesOrder;

public class SalesOrderValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        if (!(order instanceof SalesOrder)) {
            throw new ValidationException("A sales order was expected");
        }

        for (AbstractOrderValidator validator : validators) {
            validator.validate(order);
        }
    }

}
