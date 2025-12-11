package pl.bsjhx.katas.adventofcode.common;

import java.util.PriorityQueue;

public class MultiRange <T extends Number & Comparable<T>> {

    private PriorityQueue<Range<T>> queue;

    public MultiRange() {
        this.queue = new PriorityQueue<>();
    }

    public void add(Range<T> newRange) {
        queue.add(newRange);
    }

    public Range<T> next() {
        return queue.poll();
    }
}
