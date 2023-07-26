package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int orders = Integer.parseInt(reader.readLine());
        double totalSpent = 0;

        for (int i = 0; i < orders; i++) {
            double price = Double.parseDouble(reader.readLine());
            int days = Integer.parseInt(reader.readLine());
            int capsules = Integer.parseInt(reader.readLine());

            double cost = (days * capsules) * price;
            totalSpent += cost;

            System.out.printf("The price for the coffee is: $%.2f%n", cost);
        }
        System.out.printf("Total: $%.2f%n", totalSpent);
    }
}