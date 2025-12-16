package pl.bsjhx.katas.adventofcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MultiRange <T extends Number & Comparable<T>> {

    private final PriorityQueue<Range<T>> queue;

    public MultiRange() {
        this.queue = new PriorityQueue<>();
    }

    public boolean add(Range<T> newRange) {
        boolean merged = false;
        Range<T> temp = null;
        List<Range<T>> toRemove = new ArrayList<>();

        for (var range : queue) {
            if (merged) {
                if (temp.isMergable(range)) {
                    temp.mergeWith(range);
                    toRemove.add(range);
                }
            }
            if (range.isMergable(newRange)) {
                range.mergeWith(newRange);
                temp = range;
                merged = true;
            }
        }

        queue.removeAll(toRemove);

        if (!merged) {
            queue.add(newRange);
        }
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
