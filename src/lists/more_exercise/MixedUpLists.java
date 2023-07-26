package lists.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> listOne = toIntList(reader.readLine());
        List<Integer> listTwo = toIntList(reader.readLine());

        List<Integer> result = new ArrayList<>();

        while (listOne.size() > 0 && listTwo.size() > 0) {
            result.add(listOne.remove(0));
            result.add(listTwo.remove(listTwo.size() - 1));
        }

        listOne.addAll(listTwo);
        int start = Math.min(listOne.get(0), listOne.get(1));
        int end = Math.max(listOne.get(0), listOne.get(1));

        result.stream()
                .filter(element -> element > start && element < end)
                .sorted()
                .forEach(e -> System.out.print(e + " "));
    }

    private static List<Integer> toIntList(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}