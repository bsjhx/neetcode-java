package pl.bsjhx.katas.designpatterns.adapter;

import java.math.BigDecimal;

public interface ExchangeRateProvider {
    BigDecimal getRate(String from, String to);
}
