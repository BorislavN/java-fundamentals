package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NxNMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        printMatrix(Integer.parseInt(reader.readLine()));
    }

    private static void printMatrix(int size) {
        StringBuilder output = new StringBuilder();

        for (int row = 0; row < size; row++) {
            output.append(String.format("%d ", size).repeat(size).trim())
                    .append(System.lineSeparator());
        }
        System.out.println(output);
    }
}