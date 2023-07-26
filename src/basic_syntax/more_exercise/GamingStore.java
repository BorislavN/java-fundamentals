package basic_syntax.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GamingStore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double budget = Double.parseDouble(reader.readLine());
        double total = 0;
        String game;

        while (!"Game Time".equals(game = reader.readLine())) {
            double cost;

            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    cost = 39.99;
                    break;
                case "CS: OG":
                    cost = 15.99;
                    break;
                case "Zplinter Zell":
                    cost = 19.99;
                    break;
                case "Honored 2":
                    cost = 59.99;
                    break;
                case "RoverWatch":
                    cost = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    continue;
            }

            if (cost > budget) {
                System.out.println("Too Expensive");
            } else {
                total += cost;
                budget -= cost;
                System.out.printf("Bought %s%n", game);
            }

            if (budget <= 0) {
                System.out.println("Out of mo-ney!");
                return;
            }
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n", total, budget);
    }
}