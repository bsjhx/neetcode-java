package pl.bsjhx.katas.arraysandhashing;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Pair {
    Integer value;
    Integer freq;
}

class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> ac : map.entrySet()) {
            q.add(ac);
            if (q.size() > k) q.poll();
        }

        int i = k;
        int[] arr = new int[k];
        while (!q.isEmpty()) {
            arr[--i] = q.poll().getKey();
        }
        return arr;
    }
}