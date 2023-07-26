package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= lines; i++) {
            String pattern = i + " ";

            System.out.println(pattern.repeat(i).trim());
        }
    }
}