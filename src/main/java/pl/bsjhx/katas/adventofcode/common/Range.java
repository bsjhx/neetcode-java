package pl.bsjhx.katas.adventofcode.common;

public class Range<T extends Number & Comparable<T>> {

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

    public void mergeWith(Range<T> second) {
        if (isSmaller(second)) {
            this.start = second.start;
        }

        if (second.getEnd().compareTo(this.end) > 0) {
            this.end = second.getEnd();
        }
    }

    private boolean isSmaller(Range<T> second) {
        if (startIncluded) {
            return second.getStart().compareTo(this.start) < 0;
        } else {

        }
        return second.getStart().compareTo(this.start) < 0;
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
}
