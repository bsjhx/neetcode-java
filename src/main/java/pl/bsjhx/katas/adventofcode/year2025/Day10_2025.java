package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;
import pl.bsjhx.katas.adventofcode.common.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day10_2025 implements Advent {

    private boolean found = false;

    @Override
    public long calculatePartOne() throws IOException {
        long sumRes = 0L;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day10.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                List<Boolean> expected = Arrays.stream(split[0].split(""))
                        .filter(s -> !"[".equals(s) && !"]".equals(s))
                        .map("#"::equals).toList();

                List<Button> buttons = new ArrayList<>();
                for (int i = 1; i < split.length - 1; i++) {
                    buttons.add(new Button(Arrays.stream(split[i].split(""))
                            .filter(s -> !"(".equals(s) && !")".equals(s) && !",".equals(s))
                            .map(Integer::parseInt)
                            .toList()));
                }

                Queue<Pair<Integer, List<Boolean>>> q = new LinkedList<>();
                List<Boolean> initialState = Collections.nCopies(expected.size(), false);
                q.add(Pair.of(1, initialState));
                long c = 0;
                boolean f = true;

                while (f) {
                    c++;
                    Pair<Integer, List<Boolean>> currentState = q.poll();
                    for (var button : buttons) {
                        List<Boolean> newState = new ArrayList<>(currentState.second());
                        for (int change : button.changes()) {
                            newState.set(change, !newState.get(change));
                        }

                        if (newState.equals(expected)) {
                            sumRes += currentState.first();
                            f = false;
                            break;
                        }

                        q.add(Pair.of(currentState.first() + 1, newState));
                    }
                }
            }

            return sumRes;
        }
    }

    private Long bfs(List<Button> buttons, Long currStep, List<Boolean> current, List<Boolean> expected, int buttonId) {
        if (found) {
            return Long.MAX_VALUE;
        }

        Button button = buttons.get(buttonId);

        for (int change : button.changes()) {
            current.set(change, !current.get(change));
        }

        if (current.equals(expected)) {
            found = true;
            return currStep;
        }

        for (int i = 0; i < buttons.size(); i++) {
            currStep = Math.min(currStep, bfs(buttons, 0L, current, expected, i));
        }

        return currStep;
    }

    private record Button(List<Integer> changes) {
        Integer getChange(int i) {
            return changes.get(i);
        }
    }

    @Override
    public long calculatePartTwo() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day10.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
            }

            return 0L;
        }
    }
}
