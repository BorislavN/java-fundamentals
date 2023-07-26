package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int target = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int firstIndex = 0; firstIndex < input.length; firstIndex++) {
            int firstNumber = Integer.parseInt(input[firstIndex]);

            for (int secondIndex = firstIndex + 1; secondIndex < input.length; secondIndex++) {
                int secondNumber = Integer.parseInt(input[secondIndex]);

                if (firstNumber + secondNumber == target) {
                    output.append(firstNumber)
                            .append(" ")
                            .append(secondNumber)
                            .append(System.lineSeparator());
                }
            }
        }
        System.out.println(output);
    }
}