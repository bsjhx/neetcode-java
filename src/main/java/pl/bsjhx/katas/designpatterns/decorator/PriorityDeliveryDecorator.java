package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

public class PriorityDeliveryDecorator extends BaseDeliveryDecorator {

    public PriorityDeliveryDecorator(PriceCalculatorComponent priceCalculator) {
        super(priceCalculator);
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return calculatePriorityPrice(this.priceCalculator.calculatePrice(weight));
    }

    private BigDecimal calculatePriorityPrice(BigDecimal price) {
        var calculated = price.multiply(BigDecimal.valueOf(0.1));
        return calculated.add(price);
    }
}
