package pl.bsjhx.katas.designpatterns.bridge.abstraction;

import pl.bsjhx.katas.designpatterns.bridge.implementation.Formatter;
import pl.bsjhx.katas.designpatterns.bridge.model.Content;

public class AuditReport extends Report {

    public AuditReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public String generate(int data) {
        var content = new Content(
                "Audit Report",
                "Failed login attempts: %s".formatted(data)
        );

        return format(content);
    }

}
