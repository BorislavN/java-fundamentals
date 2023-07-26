package methods.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TribonacciSequence {
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numbers = Integer.parseInt(reader.readLine());
        memo = new int[numbers];
        memo[0] = 1;

        for (int num = 1; num <= numbers; num++) {
            System.out.print(getTribonacci(num) + " ");
        }
    }

    private static int getTribonacci(int num) {
        if (num <= 0) {
            return 0;
        }

        if (memo[num - 1] == 0) {
            memo[num - 1] = getTribonacci(num - 1)
                    + getTribonacci(num - 2)
                    + getTribonacci(num - 3);
        }

        return memo[num - 1];
    }
}