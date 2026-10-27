package pl.bsjhx.katas.designpatterns.adapter;

import java.math.BigDecimal;
import java.util.Map;

public class ExternalCurrencyAdapter implements ExchangeRateProvider {

    private final ExternalCurrencyApi externalCurrencyApi;

    public ExternalCurrencyAdapter(ExternalCurrencyApi externalCurrencyApi) {
        if (externalCurrencyApi == null) {
            throw new IllegalArgumentException("ExternalCurrencyApi cannot be null");
        }
        this.externalCurrencyApi = externalCurrencyApi;
    }

    @Override
    public BigDecimal getRate(String from, String to) {
        Map<String, Object> apiResponse = fetchFromApiService(from);

        if (apiResponse == null) {
            throw new ExternalCurrencyApiException("ExternalCurrencyApi returned null for base currency: " + from);
        }

        if (!apiResponse.containsKey("rates")) {
            throw new ExternalCurrencyApiException("ExternalCurrencyApi returned data with missing rates for base currency: " + from);
        }

        var rate = readRate(to, apiResponse);

        if (rate == null) {
            throw new ExternalCurrencyApiException("ExternalCurrencyApi returned data with missing rates for base currency: " + from);
        } else {
            return rate;
        }
    }

    private Map<String, Object> fetchFromApiService(String from) {
        try {
            return externalCurrencyApi.fetchExchangeData(from);
        } catch (Exception e) {
            throw new ExternalCurrencyApiException("Error fetching exchange rate from %s".formatted(from), e);
        }
    }

    private BigDecimal readRate(String to, Map<String, Object> stringObjectMap) {
        try {
            return ((Map<String, BigDecimal>) stringObjectMap.get("rates")).get(to);
        } catch (ClassCastException e) {
            throw new ExternalCurrencyApiException("ExternalCurrencyApi returned unexpected data for rates", e);
        }
    }
}
