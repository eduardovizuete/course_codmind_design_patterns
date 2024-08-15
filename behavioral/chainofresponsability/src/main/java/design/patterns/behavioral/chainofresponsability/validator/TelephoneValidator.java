package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.Telephone;
import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;

public class TelephoneValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        Telephone tel = order.getContributor().getTelephone();
        if (null == tel) {
            throw new ValidationException(
                    "The taxpayer's phone is required");
        } else if (tel.getNumber().length() != 7) {
            throw new ValidationException("Invalid phone number");
        } else if (tel.getLada().length() != 3) {
            throw new ValidationException("Invalid lada");
        }
    }

}
