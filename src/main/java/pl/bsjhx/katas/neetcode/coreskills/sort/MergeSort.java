package pl.bsjhx.katas.neetcode.coreskills.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.size() < 2) {
            return pairs;
        }

        int divide = pairs.size() / 2;
        List<Pair> left = mergeSort(pairs.subList(0, divide));
        List<Pair> right = mergeSort(pairs.subList(divide, pairs.size()));

        int i = 0;
        int j = 0;

        List<Pair> res = new ArrayList<>(left.size() + right.size());
        while (true) {
            var leftVal = i < left.size() ? left.get(i) : null;
            var rightVal = j < right.size() ? right.get(j) : null;
            if (rightVal == null && leftVal == null) {
                return res;
            }
            if (rightVal == null && leftVal != null) {
                res.add(leftVal);
                i++;
                continue;
            }
            if (leftVal == null && rightVal != null) {
                res.add(rightVal);
                j++;
                continue;
            }

            if (leftVal.key <= rightVal.key) {
                res.add(leftVal);
                i++;
            } else {
                res.add(rightVal);
                j++;
            }


        }
    }
}
