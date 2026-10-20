package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

public class ExpressDeliveryDecorator extends BaseDeliveryDecorator{

    public ExpressDeliveryDecorator(PriceCalculatorComponent priceCalculator) {
        super(priceCalculator);
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return calculateExpressPrice(this.priceCalculator.calculatePrice(weight));
    }

    private BigDecimal calculateExpressPrice(BigDecimal price) {
        return BigDecimal.valueOf(15).add(price);
    }
}
