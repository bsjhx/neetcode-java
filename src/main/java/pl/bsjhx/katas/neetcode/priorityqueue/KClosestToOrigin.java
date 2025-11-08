package pl.bsjhx.katas.neetcode.priorityqueue;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> a = new PriorityQueue<>((o1, o2) -> {
            double distance1 = Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
            double distance2 = Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2));
            if (distance1 > distance2) {
                return 1;
            } else if (distance2 > distance1) {
                return -1;
            }

            return 0;
        });

        a.addAll(Arrays.asList(points));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = a.poll();
        }

        return result;
    }
}
