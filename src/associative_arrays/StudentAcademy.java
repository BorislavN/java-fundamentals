package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Double>> students = new LinkedHashMap<>();
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String name = reader.readLine();
            double grade = Double.parseDouble(reader.readLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.forEach((key, value) -> {
            double average = value.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);

            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n"
                        , key
                        , average);
            }
        });
    }
}