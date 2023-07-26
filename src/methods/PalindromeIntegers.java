package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"END".equals(input = reader.readLine())) {
            System.out.println(isPalindrome(input));
        }
    }

    private static boolean isPalindrome(String input) {
        StringBuilder output = new StringBuilder(input);
        output.reverse();

        return input.equals(output.toString());
    }
}