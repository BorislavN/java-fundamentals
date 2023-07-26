package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> companies = new LinkedHashMap<>();
        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] data = line.split("\\s*->\\s*");

            companies.putIfAbsent(data[0], new LinkedHashSet<>());
            companies.get(data[0]).add(data[1]);
        }

        companies.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(element -> System.out.printf("-- %s%n", element));
        });
    }
}