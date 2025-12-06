package pl.bsjhx.katas.adventofcode.common;

public class Range<T extends Number & Comparable<T>> {

    private T start;
    private T end;

    public Range(T start, T end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("Start of range must be less or equal than end");
        }

        this.start = start;
        this.end = end;
    }

    public boolean isInRange(T value) {
        return value.compareTo(start) >= 0 && value.compareTo(end) < 0;
    }

    public void mergeWith(Range<T> second) {
        if (second.getStart().compareTo(this.start) < 0) {
            this.start = second.start;
        }

        if (second.getEnd().compareTo(this.end) > 0) {
            this.end = second.getEnd();
        }
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }
}
