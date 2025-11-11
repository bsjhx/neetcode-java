package pl.bsjhx.katas.neetcode.twopointers;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

public class Drawer {

    public static void main(String[] args) {
        draw(new int[]{0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2});
    }

    public static void draw(int[] heights) {
        int max = Arrays.stream(heights).reduce(0, Math::max);
        boolean[][] map = new boolean[max][heights.length];

        for (int i = 0; i < heights.length; i++) {
            int x = heights[i];
            for (int j = 0; j < x; j++) {
                map[max - j - 1][i] = true;
            }
        }

        for (int j = 0; j < max; j++) {
            for (int i = 0; i < heights.length; i++) {
                boolean x = map[j][i];
                if (x) {
                    System.out.print(Character.toChars(	0x2588)[0]);
                } else {
                    System.out.print(Character.toChars(	0x2591)[0]);
                }
            }
            System.out.println();
        }
    }
}
