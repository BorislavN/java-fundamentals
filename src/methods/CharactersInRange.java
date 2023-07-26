package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharactersInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int start = reader.readLine().charAt(0);
        int end = reader.readLine().charAt(0);

        System.out.println(getCharactersInRange(start, end));
    }

    private static String getCharactersInRange(int start, int end) {
        StringBuilder output = new StringBuilder();

        for (int code = Math.min(start, end) + 1; code < Math.max(start, end); code++) {
            output.append(Character.toString(code))
                    .append(" ");
        }
        return output.toString().trim();
    }
}