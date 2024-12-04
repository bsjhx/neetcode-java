package pl.bsjhx.katas.priorityqueue;

import java.util.*;

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (o2 > o1) {
                return 1;
            } else if (o2 < o1) {
                return -1;
            }
            return 0;
        });
        for (int val : stones) {
            queue.offer(val);
        }

        Integer stone1;
        while (queue.size() > 1) {
            stone1 = queue.poll();
            Integer stone2 = queue.poll();
            if (null == stone2) {
                return stone1;
            }

            if (!Objects.equals(stone1, stone2)) {
                queue.offer(stone1 - stone2);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }

    public int lastStoneWeightSmartest(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int stone : stones) maxHeap.add(-stone);
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();
            if (stone1 != stone2) maxHeap.add(stone1 - stone2);
        }
        return !maxHeap.isEmpty() ? (-maxHeap.remove()) : 0;
    }
}