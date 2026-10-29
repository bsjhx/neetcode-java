package pl.bsjhx.katas.designpatterns.composite;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Directory extends SystemElement {

    private final Set<SystemElement> elements;

    public Directory(String name) {
        super(name, 0);
        elements = new HashSet<>();
    }

    public static Directory directory(String name) {
        return new Directory(name);
    }

    @Override
    public int getSize() {
        return elements.stream().mapToInt(SystemElement::getSize).sum();
    }

    @Override
    public String print(String indentation) {
        return "%s%s/\n%s".formatted(
                indentation,
                getName(),
                getElementsOrderedAlphabetically().stream()
                        .map(element -> element.print(indentation + "\t"))
                        .collect(Collectors.joining("\n"))
        );
    }

    public void add(SystemElement element) {
        elements.add(element);
    }

    public void remove(SystemElement element) {
        elements.remove(element);
    }

    private List<SystemElement> getElementsOrderedAlphabetically() {
        return elements.stream()
                .sorted(Comparator.comparing(SystemElement::getName))
                .toList();
    }
}
