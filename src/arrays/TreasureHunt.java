package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreasureHunt {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] chest = reader.readLine().split("\\|");
        String line;

        while (!"Yohoho!".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            switch (arguments[0]) {
                case "Loot":
                    String chestAsString = String.join("|", chest);
                    StringBuilder newAdditions = new StringBuilder();
                    for (int index = 1; index < arguments.length; index++) {
                        if (!chestAsString.contains(arguments[index])) {
                            newAdditions.insert(0, arguments[index] + "|");
                        }
                    }
                    chest = newAdditions.append(chestAsString).toString().split("\\|");
                    break;
                case "Drop":
                    int index = Integer.parseInt(arguments[1]);
                    if (index >= 0 && index <= chest.length) {
                        String temp = chest[index];

                        for (int i = index; i < chest.length - 1; i++) {
                            chest[i] = chest[i + 1];
                        }
                        chest[chest.length - 1] = temp;
                    }
                    break;
                case "Steal":
                    int count = Math.min(chest.length, Integer.parseInt(arguments[1]));
                    StringBuilder output = new StringBuilder();

                    for (int i = chest.length - count; i < chest.length; i++) {
                        output.append(chest[i])
                                .append(((i < chest.length - 1) ? ", " : ""));
                    }
                    System.out.println(output);
                    chest = Arrays.copyOf(chest, chest.length - count);
                    break;
            }
        }
        if (chest.length == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n"
                    , String.join("", chest).length() * 1.0 / chest.length);
        }
    }
}