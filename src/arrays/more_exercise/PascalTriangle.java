package arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class PascalTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        int[] previousRow = new int[lines];

        for (int line = 1; line <= lines; line++) {
            int[] row = new int[lines];

            for (int index = 0; index < line; index++) {
                int upperLeftValue = index - 1 < 0 ? 0 : previousRow[index - 1];

                row[index] = line == 1 ? 1 : upperLeftValue + previousRow[index];
            }
            previousRow = row;

            System.out.println(Arrays.stream(row)
                    .filter(e -> e != 0)
                    .mapToObj(Objects::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}