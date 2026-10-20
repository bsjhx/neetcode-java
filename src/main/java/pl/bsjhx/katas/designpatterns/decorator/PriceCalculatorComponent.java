package pl.bsjhx.katas.designpatterns.decorator;

import java.math.BigDecimal;

public interface PriceCalculatorComponent {

    BigDecimal calculatePrice(BigDecimal weight);
}
