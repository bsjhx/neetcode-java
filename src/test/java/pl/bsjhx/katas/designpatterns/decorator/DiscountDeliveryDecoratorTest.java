package pl.bsjhx.katas.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountDeliveryDecoratorTest {


    @Test
    void name() {
        var calculator = new DiscountDeliveryDecorator(PriceCalculatorConcrete.withDefault());
        assertEquals(0, BigDecimal.valueOf(7.2).compareTo(calculator.calculatePrice(BigDecimal.ONE)));
        assertEquals(0, BigDecimal.valueOf(180).compareTo(calculator.calculatePrice(BigDecimal.valueOf(25))));
        assertEquals(0, BigDecimal.valueOf(220).compareTo(calculator.calculatePrice(BigDecimal.valueOf(30))));

    }
}