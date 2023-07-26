package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelsCount {
    private static final String VOWELS = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(getVowelsCount(reader.readLine()));
    }

    private static long getVowelsCount(String input) {
        return input
                .toLowerCase()
                .chars()
                .filter(vowel -> VOWELS.contains(Character.toString(vowel)))
                .count();
    }
}