package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOrderValidator {

    protected List<AbstractOrderValidator> validators = new ArrayList<>();

    public abstract void validate(AbstractOrder order) throws ValidationException;

    public void addValidator(AbstractOrderValidator validator) {
        validators.add(validator);
    }

}
