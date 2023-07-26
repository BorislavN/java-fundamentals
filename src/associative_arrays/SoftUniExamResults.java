package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SoftUniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, List<Integer>>> submissions = new LinkedHashMap<>();
        List<String> bannedUsers = new ArrayList<>();
        String line;

        while (!"exam finished".equals(line = reader.readLine())) {
            String[] data = line.split("-");

            if ("banned".equals(data[1])) {
                bannedUsers.add(data[0]);

            } else {
                submissions
                        .putIfAbsent(data[1], new LinkedHashMap<>());

                submissions
                        .get(data[1])
                        .putIfAbsent(data[0], new ArrayList<>());

                submissions
                        .get(data[1])
                        .get(data[0])
                        .add(Integer.parseInt(data[2]));
            }
        }

        StringBuilder firstOutput = new StringBuilder("Results:\n");
        StringBuilder secondOutput = new StringBuilder("Submissions:\n");

        submissions.forEach((language, users) -> {
            secondOutput.append(String.format("%s - %d%n"
                    , language
                    , users.values().stream().mapToInt(List::size).sum()));

            users.forEach((user, grades) -> {
                if (!bannedUsers.contains(user)) {
                    firstOutput.append(String.format("%s | %s%n"
                            , user
                            , grades.stream().max(Integer::compare).orElse(0)));
                }
            });
        });

        System.out.print(firstOutput);
        System.out.print(secondOutput);
    }
}