package associative_arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SnowWhite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> dwarves = new LinkedHashMap<>();
        Map<String, Integer> colors = new LinkedHashMap<>();
        String line;

        while (!"Once upon a time".equals(line = reader.readLine())) {
            String[] data = line.split(" <:> ");

            String name = data[0];
            String color = data[1];
            int physique = Integer.parseInt(data[2]);
            String uniqueID = String.format("%s %s", color, name);

            if (!dwarves.containsKey(uniqueID)) {
                colors.putIfAbsent(color, 0);
                colors.put(color, colors.get(color) + 1);

                dwarves.put(uniqueID, 0);
            }

            dwarves.put(uniqueID, Math.max(dwarves.get(uniqueID), physique));
        }

        dwarves.entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    String colorOne = d1.getKey().split("\\s+")[0];
                    String colorTwo = d2.getKey().split("\\s+")[0];

                    int result = Integer.compare(d2.getValue(), d1.getValue());

                    if (result == 0) {
                        result = Integer.compare(colors.get(colorTwo), colors.get(colorOne));
                    }

                    return result;
                })
                .forEach(element -> {
                    String[] data = element.getKey().split("\\s+");

                    System.out.printf("(%s) %s <-> %d%n"
                            , data[0]
                            , data[1]
                            , element.getValue());
                });
    }
}