package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharsInString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        Map<String, Integer> map = new LinkedHashMap<>();
//
//        Arrays.stream(reader.readLine().split(""))
//                .filter(e -> !e.equals(" "))
//                .forEach(current -> {
//                    map.putIfAbsent(current, 0);
//                    map.put(current, map.get(current) + 1);
//                });
//
//        map.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));

        Arrays.stream(reader.readLine().split(""))
                .filter(e -> !e.isBlank())
                .collect(Collectors.toMap(Function.identity(), value -> 1, (old, current) -> old + 1, LinkedHashMap::new))
                .forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}