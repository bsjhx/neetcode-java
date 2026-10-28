package pl.bsjhx.katas.designpatterns.bridge.implementation;

import pl.bsjhx.katas.designpatterns.bridge.model.Content;

public interface Formatter {

    String format(Content content);
}
