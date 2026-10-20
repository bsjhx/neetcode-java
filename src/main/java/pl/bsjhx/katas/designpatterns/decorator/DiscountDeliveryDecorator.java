package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

public class DiscountDeliveryDecorator extends BaseDeliveryDecorator {

    public DiscountDeliveryDecorator(PriceCalculatorComponent priceCalculator) {
        super(priceCalculator);
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return calculateDiscountPrice(this.priceCalculator.calculatePrice(weight));
    }

    private BigDecimal calculateDiscountPrice(BigDecimal price) {
        var calculated = price.multiply(BigDecimal.valueOf(0.1));
        var discount =  calculated.compareTo(BigDecimal.valueOf(20)) > 0 ? BigDecimal.valueOf(20) : calculated;
        return price.subtract(discount);
    }
}
