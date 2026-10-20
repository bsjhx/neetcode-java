package pl.bsjhx.katas.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceDeliveryDecoratorTest {

    @Test
    void calculatePrice() {
        var calculator = new InsuranceDeliveryDecorator(PriceCalculatorConcrete.withDefault());
        assertEquals(BigDecimal.valueOf(13), calculator.calculatePrice(BigDecimal.ONE)); // 5
        assertEquals(BigDecimal.valueOf(85).stripTrailingZeros(), calculator.calculatePrice(BigDecimal.valueOf(10).stripTrailingZeros())); // 5
        assertEquals(BigDecimal.valueOf(816).stripTrailingZeros(), calculator.calculatePrice(BigDecimal.valueOf(100).stripTrailingZeros())); // 16
        assertEquals(BigDecimal.valueOf(840.48).stripTrailingZeros(), calculator.calculatePrice(BigDecimal.valueOf(103).stripTrailingZeros())); // 824

    }
}