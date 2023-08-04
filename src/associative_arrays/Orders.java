package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double[]> map = new LinkedHashMap<>();
        String line;

        while (!"buy".equals(line = reader.readLine())) {
            String[] data = line.split("\\s+");

            double price = Double.parseDouble(data[1]);
            int amount = Integer.parseInt(data[2]);

            map.putIfAbsent(data[0], new Double[]{0.0, 0.0});

            Double[] temp = map.get(data[0]);

            temp[0] = price;
            temp[1] = temp[1] + amount;
        }

        map.forEach((key, val) -> {
            System.out.printf("%s -> %.2f%n", key, val[0] * val[1]);
        });
    }
}