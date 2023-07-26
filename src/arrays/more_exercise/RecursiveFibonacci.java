package arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(getFibonacci(Integer.parseInt(reader.readLine())));
    }

    private static final long[] memory = new long[50];

    private static long getFibonacci(long number) {
        if (number <= 2) {
            return 1;
        } else {
            int index = (int) number-1;

            if (memory[index] != 0) {
                return memory[index];
            }
            memory[index] = getFibonacci(number - 1) + getFibonacci(number - 2);

            return memory[index];
        }
    }
}