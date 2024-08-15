package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.Contributor;
import design.patterns.behavioral.chainofresponsability.domain.Status;
import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;

public class ContributorValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        for (AbstractOrderValidator validator : validators) {
            validator.validate(order);
        }

        Contributor contributor = order.getContributor();
        if (Status.ACTIVO != contributor.getStatus()) {
            throw new ValidationException("The taxpayer is not active");
        }
    }

}
