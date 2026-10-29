package pl.bsjhx.katas.designpatterns.composite;

public class File extends SystemElement {

    public File(String name, int size) {
        super(name, size);
    }

    public static File file(String name, int size) {
        return new File(name, size);
    }

    public String print(String indentation) {
        return "%s%s (%d bytes)".formatted(indentation, getName(), getSize());
    }
}
