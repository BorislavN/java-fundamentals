package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Division {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        String output = "The number is divisible by ";

        if (number % 10 == 0) {
            output += 10;
        } else if (number % 7 == 0) {
            output += 7;
        } else if (number % 6 == 0) {
            output += 6;
        } else if (number % 3 == 0) {
            output += 3;
        } else if (number % 2 == 0) {
            output += 2;
        } else {
            output = "Not divisible";
        }
        System.out.println(output);
    }
}