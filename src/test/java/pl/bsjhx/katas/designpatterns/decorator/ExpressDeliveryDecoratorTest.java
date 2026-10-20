package pl.bsjhx.katas.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ExpressDeliveryDecoratorTest {

    @Test
    void name() {
        var calculator = new ExpressDeliveryDecorator(PriceCalculatorConcrete.withDefault());

        assertEquals(BigDecimal.valueOf(23).stripTrailingZeros(), calculator.calculatePrice(BigDecimal.ONE));
        assertEquals(BigDecimal.valueOf(95).stripTrailingZeros(), calculator.calculatePrice(BigDecimal.valueOf(10).stripTrailingZeros()));
    }
}