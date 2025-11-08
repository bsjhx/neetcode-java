package pl.bsjhx.katas.neetcode.stack;

import java.util.*;
import java.util.stream.Collectors;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> maps = new HashMap<>(position.length);
        for (int i = 0; i < position.length; i++) {
            maps.put(position[i], speed[i]);
        }
        
        List<Map.Entry<Integer, Integer>> sorted = maps.entrySet().stream().sorted(
                (a, b) -> Integer.compare(b.getKey(), a.getKey())
        ).toList();

        Stack<Double> s = new Stack<>();
        for (Map.Entry<Integer, Integer> entry : sorted) {
            double time = (target - entry.getKey()) / (double) entry.getValue();
            if (s.isEmpty() || s.peek() < time) {
                s.push(time);
            }
        }
        
        return s.size();
    }
}
