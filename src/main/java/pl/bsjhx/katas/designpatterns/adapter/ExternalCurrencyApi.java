package pl.bsjhx.katas.designpatterns.adapter;

import java.math.BigDecimal;
import java.util.Map;

public class ExternalCurrencyApi {

    public Map<String, Object> fetchExchangeData(String baseCurrency) {
        return Map.of(
                "base", "EUR",
                "rates", Map.of(
                        "PLN", new BigDecimal("4.32"),
                        "USD", new BigDecimal("1.08")
                )
        );
    }
}