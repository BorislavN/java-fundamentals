package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < input.length; index++) {
            int sumOne = 0;
            int sumTwo = 0;

            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                sumOne += input[leftIndex];
            }

            for (int rightIndex = index + 1; rightIndex < input.length; rightIndex++) {
                sumTwo += input[rightIndex];
            }

            if (sumOne == sumTwo) {
                System.out.println(index);
                return;
            }
        }
        System.out.println("no");
    }
}