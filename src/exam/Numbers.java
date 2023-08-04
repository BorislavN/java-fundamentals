package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        double average = sequence.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        String output = sequence.stream()
                .filter(e -> e > average)
                .sorted((x, y) -> Integer.compare(y, x))
                .limit(5)
                .map(Objects::toString).collect(Collectors.joining(" "));

        System.out.println(output.isEmpty() ? "No" : output);
    }
}