package pl.bsjhx.katas.designpatterns.bridge.implementation;

import pl.bsjhx.katas.designpatterns.bridge.model.Content;

public class PdfFormatter implements Formatter {

    @Override
    public String format(Content content) {
        return """
                [PDF DOCUMENT]
                Title: %s
                Content: %s
                """.formatted(
                content.title(),
                content.content()
        );
    }
}
