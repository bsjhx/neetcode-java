# Senior Java Interview Assignment: Shipping Cost Calculator

## Goal

Design and implement a shipping cost calculation module in Java. The assignment evaluates your ability to apply the **Decorator** pattern, design object-oriented code, test business logic, and make sound design decisions at Senior Java Developer level.

## Business Context

The system calculates a shipment's price from a base cost and optional additional services. A customer can combine multiple services in a single quote.

Do not create a separate class for every possible combination of services. Use object composition and the Decorator pattern where appropriate.

## Functional Requirements

### 1. Base Price

- The base price is `PLN 8.00` per kilogram of shipment weight.
- Shipment weight must be greater than zero.
- The final price must not be negative.
- Represent monetary values using `BigDecimal` or a dedicated `Money` type. Do not use `double` or `float` for monetary calculations.

### 2. Additional Services

Implement the following optional elements:

- **Insurance** — 2% of the shipment's declared value, with a minimum charge of `PLN 5.00`.
- **Express delivery** — an additional charge of `PLN 15.00`.
- **Priority handling** — an additional charge equal to 10% of the service price calculated before applying any discount.
- **Discount code** — a 10% reduction of the price after all other services have been applied, capped at `PLN 20.00`.

Insurance requires the shipment's declared value. Assume the declared value cannot be negative.

### 3. Combining Services

- A customer can select any combination of the available additional services.
- The system must support quotes with no additional services.
- Do not create a class for every possible combination of services.
- Use a common interface and the Decorator pattern to extend the quote calculation.
- Build the decorator chain in one clearly defined place, such as a factory or builder.

### 4. Calculation Order

The order of operations is a business rule and must be explicit:

1. Calculate the base price.
2. Add the insurance charge, if selected.
3. Add the express delivery charge, if selected.
4. Add the priority handling charge, calculated as 10% of the price after the preceding operations.
5. Apply the discount code last: reduce the pre-discount price by 10%, up to a maximum discount of `PLN 20.00`.

The discount must always be applied last, regardless of the order in which the customer provides the selected options. Do not rely on the accidental order of input elements.

### 5. Validation and Rounding

- Validate input data and reject invalid values.
- Define and document how monetary amounts are rounded to two decimal places.
- Apply one consistent rounding policy throughout the module.
- Avoid hidden dependencies on object construction order.

## Technical Requirements

- Java 21 or newer.
- Maven or Gradle may be used.
- Spring Boot and a REST API are not required.
- Business logic must be runnable and testable without external infrastructure.
- Add unit tests, for example using JUnit 5.
- Keep responsibilities clear and avoid unnecessary complexity.

## Design Deliverables

The solution should include:

- An interface representing a shipping cost quote.
- A base-price implementation.
- A base decorator abstraction, if appropriate.
- Concrete decorators for the additional services.
- A composition mechanism that guarantees the required calculation order.
- Unit tests.
- Brief instructions for running the tests.

Do not introduce extra layers, patterns, or frameworks without a clear need. Choose an appropriate level of abstraction for the problem and explain important design decisions.

## Acceptance Criteria

The solution is acceptable if it:

- Calculates the base price correctly.
- Calculates each additional service correctly.
- Supports different combinations of services.
- Always applies the discount last.
- Does not use floating-point types for monetary calculations.
- Includes tests for individual services, combinations, validation, and edge cases.
- Allows new services to be added without creating a class for every possible combination.
- Has a clear and justified design.

## Required Test Cases

Include at least the following:

1. Base quote with no additional services.
2. Each additional service applied individually.
3. Insurance charge below the minimum threshold and above it.
4. A discount below the cap and a discount capped at `PLN 20.00`.
5. A quote with all services enabled.
6. Different input orders for selected options produce the same final price.
7. Zero or negative shipment weight.
8. Negative declared shipment value.
9. Correct rounding of monetary values.

## Senior-Level Discussion Extension

After completing the implementation, prepare brief answers to these questions:

- Why is Decorator an appropriate or inappropriate pattern for this problem?
- How does your design guarantee that the discount is always applied last?
- Is a factory sufficient to enforce the order, or would a pricing-rule pipeline be a better fit?
- What would you change if the system had 30 additional services, some of which depended on each other, and the order had to be configurable?
- What trade-offs does your proposed design introduce?

There is no single required architecture. Correctness, simplicity, testability, and the ability to explain design trade-offs matter most.
