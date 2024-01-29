package pl.bsjhx.arraysandhashing;

import java.util.*;

class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] anagrams) {
        Map<List<Integer>, List<String>> result = new HashMap<>();

        for (String anagram : anagrams) {
            char[] chars = anagram.toCharArray();
            // List<Integer> a = new ArrayList<>(26);
            int[] t = new int[32];
            for (char aChar : chars) {
                int index = aChar - 95;
                t[index]++;
            }
            List<Integer> a = Arrays.stream(t).boxed().toList();

            if (result.containsKey(a)) {
                result.get(a).add(anagram);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(anagram);
                result.put(a, value);
            }
        }

        return new ArrayList<>(result.values());
    }
}