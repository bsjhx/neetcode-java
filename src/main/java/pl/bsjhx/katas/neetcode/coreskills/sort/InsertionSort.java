package pl.bsjhx.katas.neetcode.coreskills.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> res = new ArrayList<>();

        for (int i = 0; i < pairs.size(); i++) {
            var j = i - 1;

            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                j--;
            }


            res.add(new ArrayList<>(pairs));
        }

        return res;
    }
}

