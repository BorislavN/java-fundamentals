package methods.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String type = reader.readLine();
        String output = "";

        switch (type) {
            case "int":
                output += returnOutput(Integer.parseInt(reader.readLine()));
                break;
            case "real":
                output += returnOutput(Double.parseDouble(reader.readLine()));
                break;
            case "string":
                output += returnOutput(reader.readLine());
                break;
        }

        System.out.println(output);
    }

    private static int returnOutput(int input) {
        return input * 2;
    }

    private static String returnOutput(String input) {
        return String.format("$%s$", input);
    }

    private static String returnOutput(double input) {
        return String.format("%.2f", input * 1.5);
    }
}