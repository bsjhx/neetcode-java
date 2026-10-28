package pl.bsjhx.katas.designpatterns.bridge.abstraction;

import pl.bsjhx.katas.designpatterns.bridge.implementation.Formatter;
import pl.bsjhx.katas.designpatterns.bridge.model.Content;

public abstract class Report {

    private final Formatter formatter;

    public Report(Formatter formatter) {
        if (formatter == null) {
            throw new IllegalArgumentException("Format cannot be null");
        }
        this.formatter = formatter;
    }

    public abstract String generate(int data);

    protected String format(Content content) {
        return formatter.format(content);
    }
}
