package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrongNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int initialNumber=number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            int currentSum = 1;

            for (int current = digit; current >= 2; current--) {
                currentSum *= current;
            }

            sum += currentSum;
            number /= 10;
        }
        System.out.printf("%s%n", sum == initialNumber ? "yes" : "no");
    }
}