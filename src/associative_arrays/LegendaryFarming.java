package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class LegendaryFarming {
    private static Map<String, Integer> inventory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        inventory = new LinkedHashMap<>();
        boolean doesNotHaveMaterials = true;

        inventory.put("shards", 0);
        inventory.put("fragments", 0);
        inventory.put("motes", 0);

        while (doesNotHaveMaterials) {
            String[] data = reader.readLine().split("\\s+");

            for (int index = 0; index < data.length; index += 2) {
                int amount = Integer.parseInt(data[index]);
                String item = data[index + 1].toLowerCase();

                inventory.putIfAbsent(item, 0);
                inventory.put(item, inventory.get(item) + amount);

                String legendaryItem = tryToBuildLegendary();

                if (!"".equals(legendaryItem)) {
                    System.out.printf("%s obtained!%n", legendaryItem);

                    doesNotHaveMaterials = false;
                    break;
                }
            }
        }

        inventory.forEach((key, value) -> {
            System.out.printf("%s: %s%n", key, value);
        });
    }

    private static String tryToBuildLegendary() {
        int currentShards = inventory.get("shards");
        int currentFragments = inventory.get("fragments");
        int currentMotes = inventory.get("motes");

        if (currentShards >= 250) {
            inventory.put("shards", currentShards - 250);

            return "Shadowmourne";
        }

        if (currentFragments >= 250) {
            inventory.put("fragments", currentFragments - 250);

            return "Valanyr";
        }

        if (currentMotes >= 250) {
            inventory.put("motes", currentMotes - 250);

            return "Dragonwrath";
        }

        return "";
    }
}