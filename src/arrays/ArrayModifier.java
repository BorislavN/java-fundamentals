package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayModifier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            switch (arguments[0]) {
                case "swap":
                    int firstIndex = Integer.parseInt(arguments[1]);
                    int secondIndex = Integer.parseInt(arguments[2]);
                    int temp = array[firstIndex];

                    array[firstIndex] = array[secondIndex];
                    array[secondIndex] = temp;
                    break;
                case "multiply":
                    int firstI = Integer.parseInt(arguments[1]);
                    int secondI = Integer.parseInt(arguments[2]);

                    array[firstI] *= array[secondI];
                    break;
                case "decrease":
                    array = Arrays.stream(array).map(a -> --a).toArray();
                    break;
            }
        }
        String output = Arrays.toString(array);
        System.out.println(output.substring(1, output.length() - 1));
    }
}