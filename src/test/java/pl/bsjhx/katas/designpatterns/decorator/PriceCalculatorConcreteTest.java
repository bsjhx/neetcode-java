package pl.bsjhx.katas.designpatterns.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorConcreteTest {

    private PriceCalculatorComponent subject;

    @BeforeEach
    void setUp() {
        subject = PriceCalculatorConcrete.withDefault();
    }

    @Test
    void default_price_is_8() {
        assertEquals(BigDecimal.valueOf(8), subject.calculatePrice(BigDecimal.valueOf(1)));
        assertEquals(BigDecimal.valueOf(64), subject.calculatePrice(BigDecimal.valueOf(8)));
    }

    @Test
    void should_difer_price() {
        subject = new  PriceCalculatorConcrete(BigDecimal.valueOf(10));
        assertEquals(BigDecimal.valueOf(10), subject.calculatePrice(BigDecimal.valueOf(1)));
        assertEquals(BigDecimal.valueOf(80), subject.calculatePrice(BigDecimal.valueOf(8)));
    }
}