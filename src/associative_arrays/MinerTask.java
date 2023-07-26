package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> map = new LinkedHashMap<>();
        String line;

        while (!"stop".equals(line = reader.readLine())) {
            map.putIfAbsent(line, 0L);
            map.put(line, map.get(line) + Long.parseLong(reader.readLine()));
        }

        map.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}