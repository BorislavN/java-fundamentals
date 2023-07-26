package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int power = 0;
        StringBuilder input = new StringBuilder(reader.readLine());

        for (int index = 0; index < input.length(); index++) {
            char current = input.charAt(index);

            if (current == '>') {
                power += Character.getNumericValue(input.charAt(index + 1));
            } else if (power > 0) {
                input.deleteCharAt(index);
                power--;
                index--;
            }
        }

        System.out.println(input);
    }
}