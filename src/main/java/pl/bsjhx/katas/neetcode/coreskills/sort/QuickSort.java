package pl.bsjhx.katas.neetcode.coreskills.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public List<Pair> quickSort(List<Pair> pairs) {
        ArrayList<Pair> pairs1 = new ArrayList<>(pairs);
        helper(pairs1, 0, pairs.size() - 1);
        return pairs1;
    }

    public void helper(List<Pair> pairs, int l, int r) {
        if (l >= r) {
            return;
        }

        Pair med = pairs.get(r);
        int pos = l;
        for (int i = l; i <= r; i++) {
            if (pairs.get(i).key < med.key) {
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(pos));
                pairs.set(pos, temp);
                pos++;
            }
        }
        pairs.set(r, pairs.get(pos));
        pairs.set(pos, med);

        helper(pairs, l, pos  - 1);
        helper(pairs, pos + 1, r);
    }
}
