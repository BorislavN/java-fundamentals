package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiddleCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(getMiddleChar(reader.readLine()));
    }

    private static String getMiddleChar(String input) {
        int index = input.length() / 2;

        return input.substring(
                input.length() % 2 == 0 ? index - 1 : index
                , index + 1
        );
    }
}