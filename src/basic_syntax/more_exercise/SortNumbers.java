package basic_syntax.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int middle = 0;


        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(reader.readLine());

            middle = number;

            if (number < min) {
                middle = min;
                min = number;
            }
            if (number > max) {
                middle = max;
                max = number;
            }
        }
        System.out.printf("%d%n%d%n%d%n", max, middle, min);
    }
}