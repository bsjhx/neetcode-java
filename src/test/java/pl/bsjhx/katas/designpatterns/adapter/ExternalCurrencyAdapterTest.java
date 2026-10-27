package pl.bsjhx.katas.designpatterns.adapter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExternalCurrencyAdapterTest {

    private ExternalCurrencyAdapter externalCurrencyAdapter;

    @Mock
    private ExternalCurrencyApi externalCurrencyApi;

    @BeforeEach
    void setUp() {
        externalCurrencyAdapter = new ExternalCurrencyAdapter(externalCurrencyApi);
    }

    @Test
    void happy_path() {
        when(externalCurrencyApi.fetchExchangeData("EUR")).thenReturn(Map.of(
                "base", "EUR",
                "rates", Map.of(
                        "PLN", new BigDecimal("4.32"),
                        "USD", new BigDecimal("1.08")
                )
        ));

        var rate = externalCurrencyAdapter.getRate("EUR", "PLN");
        assertEquals(new BigDecimal("4.32"), rate);
    }

    @ParameterizedTest
    @MethodSource("errorCases")
    void api_returns_error(Map<String, Object> apiResult, String message) {
        when(externalCurrencyApi.fetchExchangeData("EUR")).thenReturn(apiResult);

        assertThatThrownBy(() -> externalCurrencyAdapter.getRate("EUR", "PLN"))
                .hasMessage(message)
                .isInstanceOf(ExternalCurrencyApiException.class);
    }

    @Test
    void should_fail_when_api_service_returns_wrong_type() {
        when(externalCurrencyApi.fetchExchangeData("EUR")).thenReturn(Map.of(
                "base", 15845L,
                "rates", List.of(new BigDecimal("1.08"))
        ));

        assertThatThrownBy(() -> externalCurrencyAdapter.getRate("EUR", "PLN"))
                .hasMessage("ExternalCurrencyApi returned unexpected data for rates")
                .isInstanceOf(ExternalCurrencyApiException.class);
    }

    @Test
    void should_fail_when_api_service_returns_wrong_numeric_type() {
        when(externalCurrencyApi.fetchExchangeData("EUR")).thenReturn(Map.of(
                "base", 15845L,
                "rates", Map.of(
                        "PLN", 5
                )));

        assertThatThrownBy(() -> externalCurrencyAdapter.getRate("EUR", "PLN"))
                .hasMessage("ExternalCurrencyApi returned unexpected data for rates")
                .isInstanceOf(ExternalCurrencyApiException.class);
    }

    @Test
    void should_fail_when_api_service_returns_null() {
        when(externalCurrencyApi.fetchExchangeData("EUR")).thenReturn(null);

        assertThatThrownBy(() -> externalCurrencyAdapter.getRate("EUR", "PLN"))
                .hasMessage("ExternalCurrencyApi returned null for base currency: EUR")
                .isInstanceOf(ExternalCurrencyApiException.class);
    }

    @Test
    void should_fail_if_api_service_is_null() {
        assertThatThrownBy(() -> new ExternalCurrencyAdapter(null))
                .hasMessage("ExternalCurrencyApi cannot be null")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void should_fail_if_api_service_returns_exception() {
        when(externalCurrencyApi.fetchExchangeData("EUR")).thenThrow(new RuntimeException("API service is down"));

        assertThatThrownBy(() -> externalCurrencyAdapter.getRate("EUR", "PLN"))
                .hasMessage("Error fetching exchange rate from EUR")
                .isInstanceOf(ExternalCurrencyApiException.class);
    }

    public static Stream<Arguments> errorCases() {
        return Stream.of(
                Arguments.of(Map.of(), "ExternalCurrencyApi returned data with missing rates for base currency: EUR"),
                Arguments.of(Map.of("base", "EUR"), "ExternalCurrencyApi returned data with missing rates for base currency: EUR"),
                Arguments.of(Map.of("base", "EUR", "rates", Map.of("USD", new BigDecimal("1.08"))), "ExternalCurrencyApi returned data with missing rates for base currency: EUR")
        );
    }

}