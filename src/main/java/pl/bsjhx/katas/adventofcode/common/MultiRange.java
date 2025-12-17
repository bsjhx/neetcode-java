package pl.bsjhx.katas.adventofcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MultiRange<T extends Number & Comparable<T>> {

    private final PriorityQueue<Range<T>> queue;

    public MultiRange() {
        this.queue = new PriorityQueue<>();
    }

    public boolean add(Range<T> newRange) {
        boolean merged = false;
        List<Range<T>> toMerge = new ArrayList<>();

        for (var range : queue) {
            if (newRange.isMergable(range)) {
                toMerge.add(range);
                merged = true;
            }
        }

        for (var range : toMerge) {
            newRange.mergeWith(range);
        }

        queue.removeAll(toMerge);
        queue.add(newRange);

        return merged;
    }

    public Range<T> next() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
