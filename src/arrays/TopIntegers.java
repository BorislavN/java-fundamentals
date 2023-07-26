package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TopIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int biggestNumber = Integer.MIN_VALUE;
        StringBuilder output = new StringBuilder();

        for (int index = numbers.length - 1; index >= 0; index--) {
            int current = numbers[index];

            if (current > biggestNumber) {
                biggestNumber = current;
                output.insert(0, current + " ");
            }
        }
        System.out.println(output);
    }
}