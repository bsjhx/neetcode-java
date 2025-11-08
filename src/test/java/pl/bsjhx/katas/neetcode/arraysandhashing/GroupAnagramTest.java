package pl.bsjhx.katas.neetcode.arraysandhashing;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.arraysandhashing.GroupAnagram;

import java.util.List;

class GroupAnagramTest {

    @Test
    void name() {
        int a = 25846;
        int b = 25846;
        while (a != 0) {
            System.out.print(a);
            System.out.print(" ");
            System.out.print(b);
            System.out.print(" ");
            System.out.print(Integer.toBinaryString(a));
            System.out.print(" ");
            System.out.println(Integer.toBinaryString(b));
            a >>= 1;
            b /= 2;
        }
    }

    @Test
    void groupAnagrams() {
        GroupAnagram ga = new GroupAnagram();
        List<List<String>> lists = ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}