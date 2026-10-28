package pl.bsjhx.katas.designpatterns.bridge.abstraction;

import pl.bsjhx.katas.designpatterns.bridge.implementation.Formatter;
import pl.bsjhx.katas.designpatterns.bridge.model.Content;

public class SalesReport extends Report {

    public SalesReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public String generate(int data) {
        return format(new Content(
                "Sales Report",
                "Total sales: $%s".formatted(data)
        ));
    }
}
