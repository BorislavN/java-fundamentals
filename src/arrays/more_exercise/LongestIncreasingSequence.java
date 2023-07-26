package arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] sequences = new int[numbers.length];

        int[] previousIndexes = new int[numbers.length];
        Arrays.fill(previousIndexes, -1);

        int winningIndex = 0;

        for (int current = 0; current < numbers.length; current++) {
            int currentElement = numbers[current];

            for (int previous = 0; previous < current; previous++) {
                int previousElement = numbers[previous];
                int previousLIS = sequences[previous];

                if (currentElement > previousElement && sequences[current] < previousLIS + 1) {
                    sequences[current] = previousLIS + 1;
                    previousIndexes[current] = previous;

                    if (sequences[winningIndex] < sequences[current]) {
                        winningIndex = current;
                    }
                }
            }
            if (sequences[current] == 0) {
                sequences[current] = 1;
            }
        }
        System.out.println(getOutput(numbers, previousIndexes, winningIndex).trim());
    }

    private static String getOutput(int[] num, int[] prevIndexes, int end) {
        StringBuilder output = new StringBuilder();

        while (end != -1) {
            output.insert(0, num[end] + " ");
            end = prevIndexes[end];
        }
        return output.toString();
    }
}