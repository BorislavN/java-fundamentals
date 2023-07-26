package data_types.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TypeFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        String type = "";

        while (!"END".equals(input= reader.readLine())) {
            try {
                int number = Integer.parseInt(input);
                type = "integer";
            } catch (NumberFormatException i) {

                try {
                    double number = Double.parseDouble(input);
                    type = "floating point";
                } catch (NumberFormatException d) {
                    if (input.length() == 1) {
                        type = "character";
                    } else if ("false".equalsIgnoreCase(input) || "true".equalsIgnoreCase(input)) {
                        type = "boolean";
                    } else {
                        type = "string";
                    }
                }
            }
            System.out.printf("%s is %s type%n", input, type);
        }
    }
}