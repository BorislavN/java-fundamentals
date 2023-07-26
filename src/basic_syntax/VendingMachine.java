package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        double money = 0;

        while (!"Start".equals(line = reader.readLine())) {
            double coin = Double.parseDouble(line);

            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                money += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
        }

        while (!"End".equals(line = reader.readLine())) {
            double cost = 0;

            switch (line) {
                case "Nuts":
                    cost = 2;
                    break;
                case "Water":
                    cost = 0.7;
                    break;
                case "Crisps":
                    cost = 1.5;
                    break;
                case "Soda":
                    cost = 0.8;
                    break;
                case "Coke":
                    cost = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            if (cost > money) {
                System.out.println("Sorry, not enough money");
            } else if (cost > 0) {
                System.out.printf("Purchased %s%n", line);
                money -= cost;
            }
        }
        System.out.printf("Change: %.2f%n", money);
    }
}