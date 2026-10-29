package pl.bsjhx.katas.designpatterns.composite;

import java.util.Objects;

public abstract class SystemElement {

    private final String name;

    private final int size;

    public SystemElement(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public abstract String print(String indentation);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SystemElement that = (SystemElement) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
