package design.patterns.behavioral.chainofresponsability.validator;

import design.patterns.behavioral.chainofresponsability.domain.Product;
import design.patterns.behavioral.chainofresponsability.domain.order.AbstractOrder;
import design.patterns.behavioral.chainofresponsability.domain.order.OrderItem;
import java.util.List;

public class OrderItemValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem item : orderItems) {
            Product product = item.getProduct();

            if (item.getQuantity() <= 0) {
                throw new ValidationException("The product '"
                        + product.getName() + "' has no amount");
            }

            double listPrice = item.getProduct().getListPrice();
            double price = item.getPrice();
            double priceLimit = listPrice - (listPrice * 0.20d);
            if (price < priceLimit) {
                throw new ValidationException("The price of the product '"
                        + product.getName() + "' exceeds the allowed limit");
            }
        }
    }

}
