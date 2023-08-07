package exam.final_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PlantDiscoveryV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Plant> plants = new LinkedHashMap<>();

        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] data = reader.readLine().split("<->");

            plants.putIfAbsent(data[0], new Plant(data[0]));
            plants.get(data[0]).setRarity(Integer.parseInt(data[1]));
        }

        String input;

        while (!"Exhibition".equals(input = reader.readLine())) {
            String[] data = input.split(":\\s+|\\s+-\\s+");

            if (!plants.containsKey(data[1])) {
                System.out.println("error");
                continue;
            }

            int value = data.length != 3 ? -1 : Integer.parseInt(data[2]);

            switch (data[0]) {
                case "Rate":
                    plants.get(data[1]).addRating(value);
                    break;
                case "Update":
                    plants.get(data[1]).setRarity(value);
                    break;
                case "Reset":
                    plants.get(data[1]).clearRatings();
                    break;
            }
        }

        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, Plant> entry : plants.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n"
                    , entry.getKey()
                    , entry.getValue().getRarity()
                    , entry.getValue().getAverageRating());
        }
    }

    private static class Plant {
        private String name;
        private int rarity;
        private List<Integer> ratings;

        public Plant(String name) {
            this.name = name;
            this.rarity = 0;
            this.ratings = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return this.rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Integer> getRatings() {
            return Collections.unmodifiableList(this.ratings);
        }

        public void addRating(int rating) {
            this.ratings.add(rating);
        }

        public void clearRatings() {
            this.ratings.clear();
        }

        public double getAverageRating() {
            return this.ratings.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);
        }
    }
}