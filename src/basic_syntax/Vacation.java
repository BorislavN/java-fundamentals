package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vacation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(reader.readLine());
        String type = reader.readLine();
        String day = reader.readLine();
        double price = 0;

        switch (type) {
            case "Students" -> {
                switch (day) {
                    case "Friday" -> price = 8.45;
                    case "Saturday" -> price = 9.8;
                    case "Sunday" -> price = 10.46;
                }

                if (people >= 30) {
                    price *= 0.85;
                }
            }
            case "Business" -> {
                switch (day) {
                    case "Friday" -> price = 10.9;
                    case "Saturday" -> price = 15.6;
                    case "Sunday" -> price = 16;
                }

                if (people >= 100) {
                    people -= 10;
                }
            }
            case "Regular" -> {
                switch (day) {
                    case "Friday" -> price = 15;
                    case "Saturday" -> price = 20;
                    case "Sunday" -> price = 22.5;
                }

                if (people >= 10 && people <= 20) {
                    price *= 0.95;
                }
            }
        }
        System.out.printf("Total price: %.2f%n", price * people);
    }
}