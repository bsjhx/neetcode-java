# Exercise 2: Adapter Pattern — Currency Exchange Rates

## Goal

Implement the **Adapter design pattern** to integrate an external currency exchange API with an application-specific interface.

The exercise focuses on isolating external dependencies, translating incompatible data structures, and handling integration errors.

## Context

Your application needs to retrieve currency exchange rates. To keep the application independent of the external API, it defines its own interface:

```java
public interface ExchangeRateProvider {
    BigDecimal getRate(String from, String to);
}
```

However, the third-party library exposes a different API that cannot be modified:

```java
public class ExternalCurrencyApi {

    public Map<String, Object> fetchExchangeData(String baseCurrency) {
        // External library implementation.
    }
}
```

The external API returns data in the following formatter:

```java
Map.of(
    "base", "EUR",
    "rates", Map.of(
        "PLN", new BigDecimal("4.32"),
        "USD", new BigDecimal("1.08")
    )
);
```

Your task is to integrate this API without exposing its implementation details to the rest of the application.

## Requirements

### 1. Implement the adapter

Create a class named `ExternalCurrencyAdapter` that implements `ExchangeRateProvider`.

The adapter must:

- Accept an instance of `ExternalCurrencyApi` through its constructor.
- Implement `getRate(String from, String to)`.
- Use `ExternalCurrencyApi` to retrieve exchange rate data.
- Return the requested exchange rate as a `BigDecimal`.
- Hide the external API's data structures from application clients.

Example usage:

```java
ExternalCurrencyApi externalApi = new ExternalCurrencyApi();
ExchangeRateProvider provider = new ExternalCurrencyAdapter(externalApi);

BigDecimal rate = provider.getRate("EUR", "PLN");
```

The client must depend only on `ExchangeRateProvider`, not on `ExternalCurrencyApi` or its response formatter.

### 2. Handle invalid responses

The external API returns loosely typed data. Your adapter must handle the following situations:

- The response is `null`.
- The `rates` entry is missing.
- The `rates` entry has an unexpected type.
- The requested target currency is missing.
- The requested rate has an unexpected type.
- The response contains malformed or incomplete data.

Define a clear error-handling policy. Do not silently return `null` or an arbitrary default rate when the requested rate cannot be retrieved.

### 3. Define error semantics

Choose and document how the adapter reports failures.

Consider whether to:

- Throw an application-specific unchecked exception.
- Translate exceptions thrown by the external API.
- Preserve the original exception as the cause.

The application should not need to understand third-party-specific exception types.

### 4. Write unit tests

Write unit tests for `ExternalCurrencyAdapter`.

At minimum, test:

- Retrieving a valid exchange rate.
- Requesting a different target currency.
- Handling a missing target currency.
- Handling a `null` response.
- Handling malformed response data.
- Translating an exception thrown by the external API, if applicable.

Tests must not depend on a real external service. Design the solution so that the external API can be replaced or controlled in tests.

## Constraints

- Do not modify `ExternalCurrencyApi`.
- Do not change the `ExchangeRateProvider` interface.
- Do not expose `Map<String, Object>` to application clients.
- Do not add unrelated abstractions or frameworks.
- Keep the implementation focused on the integration boundary.

## Definition of Done

- [ ] `ExternalCurrencyAdapter` implements `ExchangeRateProvider`.
- [ ] The adapter translates the external response into the application's expected return type.
- [ ] Invalid responses are handled explicitly.
- [ ] External API failures are handled according to a documented policy.
- [ ] Unit tests cover the main success and failure scenarios.
- [ ] Application clients depend only on `ExchangeRateProvider`.

## Senior-Level Discussion

After completing the implementation, be prepared to explain:

1. Why is Adapter appropriate here? What problem does it solve?
2. Why should the application depend on `ExchangeRateProvider` instead of `ExternalCurrencyApi`?
3. Would you use composition or inheritance to implement the adapter? Why?
4. Where should external exceptions be translated into application-specific exceptions?
5. Should the adapter validate all response data or only the data it needs?
6. How would you handle timeouts, retries, and rate limits?
7. How would you evolve the design if a second currency API were introduced?

## Suggested Approach

Start with the smallest implementation that satisfies the requirements.

Avoid introducing additional patterns unless you can explain the concrete problem they solve. The goal is not to use as many abstractions as possible, but to create a clear and reliable integration boundary.
