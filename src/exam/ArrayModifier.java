package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input;

        while (!"end".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            int index1 = data.length == 1 ? -1 : Integer.parseInt(data[1]);
            int index2 = data.length == 1 ? -1 : Integer.parseInt(data[2]);

            switch (data[0]) {
                case "swap":
                    int tmp = array[index1];

                    array[index1] = array[index2];
                    array[index2] = tmp;

                    break;
                case "multiply":
                    array[index1] = array[index1] * array[index2];

                    break;
                case "decrease":
                    array = Arrays.stream(array).map(e -> e - 1).toArray();

                    break;
            }
        }
        System.out.println(Arrays.stream(array)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));
    }
}