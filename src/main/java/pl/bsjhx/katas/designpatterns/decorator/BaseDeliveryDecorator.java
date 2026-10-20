package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

abstract class BaseDeliveryDecorator implements PriceCalculatorComponent {

    protected final PriceCalculatorComponent priceCalculator;

    public BaseDeliveryDecorator(PriceCalculatorComponent priceCalculator) {
        if (priceCalculator == null) {
            throw new IllegalArgumentException("Price calculator cannot be null");
        }
        this.priceCalculator = priceCalculator;
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return priceCalculator.calculatePrice(weight);
    }
}
