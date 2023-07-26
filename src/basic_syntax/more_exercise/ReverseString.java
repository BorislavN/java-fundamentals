package basic_syntax.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        for (int index = input.length()-1; index >= 0; index--) {
            System.out.print(input.charAt(index));
        }
        System.out.println("");
    }
}