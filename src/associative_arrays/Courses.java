package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Courses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> courses = new LinkedHashMap<>();
        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] data = line.split(" : ");

            courses.putIfAbsent(data[0], new ArrayList<>());
            courses.get(data[0]).add(data[1]);
        }

        courses.forEach((key, val) -> {
            System.out.printf("%s: %d%n", key, val.size());

            val.forEach(student -> System.out.printf("-- %s%n", student));
        });
    }
}