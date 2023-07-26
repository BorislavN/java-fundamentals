package associative_arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ranking {
    private static Map<String, Map<String, Integer>> candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> contests = new HashMap<>();
        candidates = new TreeMap<>();
        String line;

        while (!"end of contests".equals(line = reader.readLine())) {
            String[] data = line.split(":");

            contests.putIfAbsent(data[0], data[1]);
        }

        while (!"end of submissions".equals(line = reader.readLine())) {
            String[] data = line.split("=>");

            String contest = data[0];
            String password = data[1];
            String user = data[2];
            int score = Integer.parseInt(data[3]);

            String actualPassword = contests.get(contest);

            if (actualPassword != null && actualPassword.equals(password)) {
                candidates.putIfAbsent(user, new LinkedHashMap<>());

                candidates.get(user).putIfAbsent(contest, 0);

                candidates.get(user).put(contest, Math.max(candidates.get(user).get(contest), score));
            }
        }

        printBestCandidate();
        System.out.println("Ranking:");

        candidates.forEach((user, scores) -> {
            System.out.println(user);

            scores.entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach((entry) -> System.out.printf("#  %s -> %d%n"
                            , entry.getKey()
                            , entry.getValue()));
        });
    }

    private static void printBestCandidate() {
        String bestName = "";
        int bestScore = Integer.MIN_VALUE;

        for (Map.Entry<String, Map<String, Integer>> entry : candidates.entrySet()) {
            String currentName = entry.getKey();
            int score = calculateScore(entry.getValue());

            if (score > bestScore) {
                bestScore = score;
                bestName = currentName;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n"
                , bestName
                , bestScore);
    }

    private static int calculateScore(Map<String, Integer> courses) {
        return courses.values().stream().mapToInt(Integer::intValue).sum();
    }
}