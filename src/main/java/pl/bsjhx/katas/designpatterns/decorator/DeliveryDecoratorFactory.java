package pl.bsjhx.katas.designpatterns.decorator;

public class DeliveryDecoratorFactory {

    PriceCalculatorComponent build(
            boolean insurance,
            boolean express,
            boolean priority,
            boolean discount
    ) {
        PriceCalculatorComponent priceCalculator = PriceCalculatorConcrete.withDefault();

        if (insurance) {
            priceCalculator = new InsuranceDeliveryDecorator(priceCalculator);
        }

        if (express) {
            priceCalculator = new ExpressDeliveryDecorator(priceCalculator);
        }

        if (priority) {
            priceCalculator = new PriorityDeliveryDecorator(priceCalculator);
        }

        if (discount) {
            priceCalculator = new DiscountDeliveryDecorator(priceCalculator);
        }

        return priceCalculator;
    }

}
