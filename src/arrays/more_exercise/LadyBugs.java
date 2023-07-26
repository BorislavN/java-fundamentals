package arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LadyBugs {
    private static String[] field;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        field = new String[size];
        Arrays.fill(field, "0");
        String line;

        Arrays.stream(reader.readLine().split("\\s+")).forEach(element -> {
            int index = Integer.parseInt(element);

            if (isInRange(index)) {
                field[index] = "1";
            }
        });


        while (!"end".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");
            int start = Integer.parseInt(arguments[0]);
            int length = Integer.parseInt(arguments[2]);

            length = "left".equals(arguments[1]) ? -(length) : length;

            if (fly(start, length)) {
                field[start] = "0";
            }
        }
        System.out.println(String.join(" ", field));
    }

    private static boolean isInRange(int index) {
        return index >= 0 && index < field.length;
    }

    private static boolean fly(int startIndex, int length) {
        if (!isInRange(startIndex)) {
            return false;//start not in field
        }
        if (!"1".equals(field[startIndex])) {
            return false;//given index is empty
        }
        if (length == 0) {
            return false;//the bug stayed on the same spot
        }

        int destinationIndex = startIndex + length;

        if (isInRange(destinationIndex)) {
            if ("1".equals(field[destinationIndex])) {
                fly(destinationIndex, length);
            } else {
                field[destinationIndex] = "1";
            }
        }
        return true;
    }
}