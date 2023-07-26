package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("%.2f%n", Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(LettersChangeNumbers::getScore)
                .sum());
    }

    private static double getScore(String input) {
        double number = Double.parseDouble(input.substring(1, input.length() - 1));
        int positionOfFirst = getPositionInAlphabet(input.charAt(0));
        int positionOfSecond = getPositionInAlphabet(input.charAt(input.length() - 1));

        if (Character.isUpperCase(input.charAt(0))) {
            number /= positionOfFirst;
        } else {
            number *= positionOfFirst;
        }

        if (Character.isUpperCase(input.charAt(input.length() - 1))) {
            number -= positionOfSecond;
        } else {
            number += positionOfSecond;
        }

        return number;
    }

    private static int getPositionInAlphabet(char symbol) {
        return 1 + (Character.toLowerCase(symbol) - 'a');
    }
}