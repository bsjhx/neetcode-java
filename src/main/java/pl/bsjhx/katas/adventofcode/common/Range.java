package pl.bsjhx.katas.adventofcode.common;

import java.util.Objects;

public class Range<T extends Number & Comparable<T>> implements Comparable<Range<T>> {

    private T start;
    private T end;
    private boolean startIncluded = true;
    private boolean endIncluded = false;

    private Range(T start, T end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("Start of range must be less or equal than end");
        }

        this.start = start;
        this.end = end;
    }

    public static <T extends Number & Comparable<T>> Range<T> of(T left, T right) {
        return new Range<>(left, right);
    }

    public boolean mergeWith(Range<T> second) {
        if (second.getStart().compareTo(this.start) > 0 && second.getEnd().compareTo(this.end) < 0) {
            return true;
        }
        boolean merged = false;

        if (second.getStart().compareTo(this.start) < 0) {
            this.start = second.start;
            merged = true;
        }

        if (second.getEnd().compareTo(this.end) > 0) {
            this.end = second.getEnd();
            merged = true;
        }

        return merged;
    }

    public boolean isInRange(T value) {
        return isInStart(value) && isInEnd(value);
    }

    public boolean isMergable(Range<T> newRange) {
        return isInRange(newRange.getStart()) || isInRange(newRange.getEnd());
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    public void setStartIncluded(boolean startIncluded) {
        this.startIncluded = startIncluded;
    }

    public void setEndIncluded(boolean endIncluded) {
        this.endIncluded = endIncluded;
    }

    private boolean isInStart(T value) {
        if (startIncluded) {
            return value.compareTo(start) >= 0;
        }
        return value.compareTo(start) > 0;
    }

    private boolean isInEnd(T value) {
        if (endIncluded) {
            return value.compareTo(end) <= 0;
        }
        return value.compareTo(end) < 0;
    }

    @Override
    public String toString() {
        return "Range=[%s, %s]".formatted(this.start, this.end);
    }

    @Override
    public int compareTo(Range<T> o) {
        return this.start.compareTo(o.start);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Range<?> range = (Range<?>) o;
        return startIncluded == range.startIncluded && endIncluded == range.endIncluded && Objects.equals(start, range.start) && Objects.equals(end, range.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, startIncluded, endIncluded);
    }
}
