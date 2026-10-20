package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

class PriceCalculatorConcrete implements  PriceCalculatorComponent {

    private final BigDecimal pricePerWeight;

    public PriceCalculatorConcrete(BigDecimal pricePerWeight) {
        if (pricePerWeight == null || pricePerWeight.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price per weight must be greater than zero");
        }

        this.pricePerWeight = pricePerWeight;
    }

    static PriceCalculatorConcrete withDefault() {
        return new PriceCalculatorConcrete(BigDecimal.valueOf(8));
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal weight) {
        if (weight == null || weight.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
        return weight.multiply(pricePerWeight);
    }
}
