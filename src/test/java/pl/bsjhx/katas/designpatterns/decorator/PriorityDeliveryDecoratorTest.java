package pl.bsjhx.katas.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriorityDeliveryDecoratorTest {

    @Test
    void name() {
        var calculator = new PriorityDeliveryDecorator(PriceCalculatorConcrete.withDefault());
        assertEquals(BigDecimal.valueOf(8.8), calculator.calculatePrice(BigDecimal.ONE));
        assertEquals(BigDecimal.valueOf(88).stripTrailingZeros(), calculator.calculatePrice(BigDecimal.valueOf(10).stripTrailingZeros()));
        assertEquals(0, BigDecimal.valueOf(660).compareTo(calculator.calculatePrice(BigDecimal.valueOf(75))));
    }
}