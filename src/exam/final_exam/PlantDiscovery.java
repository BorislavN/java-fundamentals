package exam.final_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlantDiscovery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> rarityMap = new LinkedHashMap<>();
        Map<String, List<Integer>> ratingMap = new LinkedHashMap<>();

        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] data = reader.readLine().split("<->");

            rarityMap.put(data[0], Integer.parseInt(data[1]));
            ratingMap.putIfAbsent(data[0], new ArrayList<>());
        }

        String input;

        while (!"Exhibition".equals(input = reader.readLine())) {
            String[] data = input.split(":\\s+|\\s+-\\s+");

            if (!ratingMap.containsKey(data[1])) {
                System.out.println("error");
                continue;
            }

            int value = data.length != 3 ? -1 : Integer.parseInt(data[2]);

            switch (data[0]) {
                case "Rate":
                    ratingMap.get(data[1]).add(value);
                    break;
                case "Update":
                    rarityMap.put(data[1], value);
                    break;
                case "Reset":
                    ratingMap.get(data[1]).clear();
                    break;
            }
        }

        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, Integer> entry : rarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n"
                    , entry.getKey()
                    , entry.getValue()
                    , ratingMap.get(entry.getKey())
                            .stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0));
        }
    }
}