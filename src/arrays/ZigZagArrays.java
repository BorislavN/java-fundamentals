package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZagArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        String[] first = new String[lines];
        String[] second = new String[lines];

        for (int index = 0; index < lines; index++) {
            String[] line = reader.readLine().split("\\s+");

            first[index] = line[index % 2 == 0 ? 0 : 1];
            second[index] = line[index % 2 == 0 ? 1 : 0];
        }
        System.out.println(String.join(" ", first));
        System.out.println(String.join(" ", second));
    }
}