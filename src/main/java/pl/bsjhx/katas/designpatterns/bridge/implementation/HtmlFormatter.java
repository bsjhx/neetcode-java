package pl.bsjhx.katas.designpatterns.bridge.implementation;

import pl.bsjhx.katas.designpatterns.bridge.model.Content;

public class HtmlFormatter implements Formatter {

    @Override
    public String format(Content content) {
        return """
                <html>
                  <body>
                    <h1>%s</h1>
                    <p>%s</p>
                  </body>
                </html>
                """.formatted(
                content.title(),
                content.content()
        );
    }
}
