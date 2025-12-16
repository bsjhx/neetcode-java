package pl.bsjhx.katas.adventofcode.common;

import java.util.PriorityQueue;

public class MultiRange <T extends Number & Comparable<T>> {

    private final PriorityQueue<Range<T>> queue;

    public MultiRange() {
        this.queue = new PriorityQueue<>();
    }

    public boolean add(Range<T> newRange) {
        for (var range : queue) {
            if (range.isMergable(newRange)) {
                range.mergeWith(newRange);
                return true;
            }
        }

        queue.add(newRange);
        return false;
    }

    public Range<T> next() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
