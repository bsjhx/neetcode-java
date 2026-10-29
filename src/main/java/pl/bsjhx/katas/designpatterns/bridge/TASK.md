# Design Pattern Exercise: Bridge — Report Generation System

## Goal

Implement a report generation system using the **Bridge** design pattern.

The exercise focuses on separating two independent dimensions of change:
- Report types — define what data a report contains and how it is presented.
- Output formats — define how the report is rendered into a specific formatter.

The solution must allow new report types and output formats to be added independently, without modifying existing implementations.

## Business Context

A company needs to generate different reports for its internal systems.

Initially, the system supports:
- Sales reports
- Audit reports

Reports must be exportable in multiple formats:
- PDF
- HTML

The company expects to introduce additional report types and output formats in the future.

## Functional Requirements

### 1. Report Types

Implement the following reports:

**Sales Report**
- Title: `Sales Report`
- Content: `Total sales: $125000`

**Audit Report**
- Title: `Audit Report`
- Content: `Failed login attempts: 12`

Each report must be able to generate its content independently of the output formatter.

### 2. Output Formats

Implement the following output formats:

**PDF**
- Render the report using the following structure:

  ```text
  [PDF DOCUMENT]
  Title: Sales Report
  Content: Total sales: $125000
  ```

**HTML**
- Render the report using the following structure:

  ```html
  <html>
    <body>
      <h1>Sales Report</h1>
      <p>Total sales: $125000</p>
    </body>
  </html>
  ```

The examples above illustrate the expected output for a sales report. The audit report must follow the same formatter-specific structure.

For this exercise, rendering to a string is sufficient. No actual PDF files or HTML files need to be created.

### 3. Report Generation

The application must support generating any report using any supported output formatter.

Examples:
- Sales report as PDF
- Sales report as HTML
- Audit report as PDF
- Audit report as HTML

The client code must be able to select the report type and output formatter independently.

## Design Requirements

1. Use the **Bridge** design pattern.
2. Model report types and output formats as two separate hierarchies.
3. Define an abstraction for reports and an implementation interface for output formats.
4. Concrete report types must delegate formatter-specific rendering to the output formatter abstraction.
5. Do not create a separate class for every report-formatter combination.
6. Do not use conditional logic such as `if`, `switch`, or pattern matching to select the output formatter inside report classes.
7. Do not use `instanceof` to determine the concrete report or output formatter.
8. Use constructor injection to provide the output formatter implementation.
9. Follow SOLID principles, particularly the Open/Closed Principle and Dependency Inversion Principle.

## Technical Requirements

- Java 17 or later
- No external dependencies
- No frameworks required
- Use interfaces and abstract classes where appropriate
- Keep the implementation focused on the design pattern rather than infrastructure

## Expected Client Usage

The following is an example of the intended usage, not a prescribed implementation:

```java
Report report = new SalesReport(new PdfFormat());

String output = report.generate();

System.out.println(output);
```
The client must also be able to generate the same report using HTML without changing the report implementation.

## Acceptance Criteria

- [ ] Sales reports can be generated in PDF and HTML.
- [ ] Audit reports can be generated in PDF and HTML.
- [ ] Report-specific content is separated from formatter-specific rendering.
- [ ] Report classes do not depend on concrete output formatter classes.
- [ ] Output formatter implementations do not depend on concrete report classes.
- [ ] Adding a new report type does not require modifying existing output formats.
- [ ] Adding a new output formatter does not require modifying existing report types.
- [ ] No class exists solely to represent a specific report-formatter combination.
- [ ] The client can combine report types and output formats through composition.

## Testing Requirements

Write unit tests covering:
- Sales report rendered as PDF.
- Sales report rendered as HTML.
- Audit report rendered as PDF.
- Audit report rendered as HTML.
- A new report type working with existing output formats without modifying them.

Use JUnit only if you choose to add a testing dependency. Otherwise, a simple executable test class is sufficient.

## Stretch Goals

1. Add a `JSON` output formatter without modifying any existing report classes.
2. Add an `Inventory Report` without modifying any existing output formatter classes.
3. Add a new output formatter and a new report type simultaneously.
4. Explain why this solution is an example of Bridge rather than merely a class delegating work to an injected dependency.

## Definition of Done

The implementation is complete when all acceptance criteria are satisfied and the two hierarchies can evolve independently.