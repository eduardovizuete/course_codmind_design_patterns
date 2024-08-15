package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.Customer;
import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;

public class CustomerValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        for (AbstractOrderValidator validator : validators) {
            validator.validate(order);
        }

        if (!(order.getContributor() instanceof Customer)) {
            throw new ValidationException("The taxpayer is not a client");
        }
    }

}
