package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

public class InsuranceDeliveryDecorator extends BaseDeliveryDecorator {

    public InsuranceDeliveryDecorator(PriceCalculatorComponent priceCalculator) {
        super(priceCalculator);
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        return calculateInsurancePrice(this.priceCalculator.calculatePrice(weight));
    }

    private BigDecimal calculateInsurancePrice(BigDecimal price) {
        var calculated = price.multiply(BigDecimal.valueOf(0.02));
        var insurance =  calculated.compareTo(BigDecimal.valueOf(5)) < 0 ? BigDecimal.valueOf(5) : calculated;
        return insurance.add(price);
    }
}
