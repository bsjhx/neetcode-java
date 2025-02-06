package pl.bsjhx.katas.arraysandhashing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecodeStrings {

    public String encode(List<String> strs) {
        return strs.stream()
                .map(s -> String.format("%s#%s", s.length(), s))
                .collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        var split = str.split("");
        StringBuilder len = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (var i = 0; i < str.length(); i++) {
            var c = split[i];
            if ("#".equals(c)) {
                int lenInt = Integer.parseInt(len.toString());
                res.add(str.substring(i + 1, i + lenInt + 1));
                i += lenInt;
                len = new StringBuilder();
            } else {
                len.append(c);
            }
        }

        return res;
    }
}

