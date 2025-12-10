package pl.bsjhx.katas.adventofcode.common;

public class Range<T extends Number & Comparable<T>> implements Comparable<Range<T>> {

    private T start;
    private T end;
    private boolean startIncluded = true;
    private boolean endIncluded = false;

    public Range(T start, T end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("Start of range must be less or equal than end");
        }

        this.start = start;
        this.end = end;
    }

    public boolean mergeWith(Range<T> second) {
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

    @Override
    public int compareTo(Range<T> o) {
        return this.start.compareTo(o.start);
    }
}
