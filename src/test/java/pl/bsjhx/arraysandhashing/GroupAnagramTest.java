package pl.bsjhx.arraysandhashing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramTest {

    @Test
    void groupAnagrams() {
        GroupAnagram ga = new GroupAnagram();
        List<List<String>> lists = ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}