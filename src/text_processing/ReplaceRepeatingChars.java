package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceRepeatingChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        for (int index = 0; index < input.length(); index++) {
            String current=String.valueOf(input.charAt(index));
            input=  input.replaceAll(String.format("[%s]+",current),current);
        }

        System.out.println(input);
    }
}