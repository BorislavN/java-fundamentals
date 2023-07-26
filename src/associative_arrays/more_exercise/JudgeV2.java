package associative_arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class JudgeV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> userPoints = new TreeMap<>();
        String line;

        while (!"no more time".equals(line = reader.readLine())) {
            String[] data = line.split(" -> ");
            int points = Integer.parseInt(data[2]);

            contests.putIfAbsent(data[1], new TreeMap<>());

            contests.get(data[1]).putIfAbsent(data[0], 0);
            int currentPoints = contests.get(data[1]).get(data[0]);

            if (points > currentPoints) {
                contests.get(data[1]).put(data[0], points);

                userPoints.putIfAbsent(data[0], 0);
                userPoints.put(data[0], userPoints.get(data[0]) + Math.abs(currentPoints - points));
            }
        }

        AtomicInteger counter = new AtomicInteger(1);

        contests.forEach((contest, participants) -> {
            System.out.printf("%s: %d participants%n", contest, participants.size());
            counter.set(1);

            participants.entrySet().stream()
                    .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                    .forEach(user -> System.out.printf("%d. %s <::> %d%n"
                            , counter.getAndIncrement()
                            , user.getKey()
                            , user.getValue())
                    );
        });

        System.out.println("Individual standings:");
        counter.set(1);

        userPoints.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach((entry) -> System.out.printf("%d. %s -> %d%n"
                        , counter.getAndIncrement()
                        , entry.getKey()
                        , entry.getValue())
                );
    }
}