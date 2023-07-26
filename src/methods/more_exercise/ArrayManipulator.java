package methods.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayManipulator {
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            switch (arguments[0]) {
                case "exchange":
                    exchange(Integer.parseInt(arguments[1]));
                    break;
                case "max":
                    max(arguments[1]);
                    break;
                case "min":
                    min(arguments[1]);
                    break;
                case "first":
                    getFirst(Integer.parseInt(arguments[1]), arguments[2]);
                    break;
                case "last":
                    getLast(Integer.parseInt(arguments[1]), arguments[2]);
                    break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static boolean isIndexValid(int index) {
        return index >= 0 && index < array.length;
    }

    private static void exchange(int index) {
        if (isIndexValid(index)) {
            int[] firstPart = Arrays.copyOfRange(array, index + 1, array.length);
            int[] secondPart = Arrays.copyOfRange(array, 0, index + 1);

            for (int i = 0; i < array.length; i++) {
                if (i < firstPart.length) {
                    array[i] = firstPart[i];
                } else {
                    array[i] = secondPart[i - firstPart.length];
                }
            }
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void min(String type) {
        int bestMatch = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if ("even".equals(type)) {
                if (array[i] % 2 == 0 && array[i] <= bestMatch) {
                    bestMatch = array[i];
                    index = i;
                }

            } else if ("odd".equals(type)) {
                if (array[i] % 2 == 1 && array[i] <= bestMatch) {
                    bestMatch = array[i];
                    index = i;
                }
            }
        }
        System.out.println(index == -1 ? "No matches" : index);
    }

    private static void max(String type) {
        int bestMatch = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if ("even".equals(type)) {
                if (array[i] % 2 == 0 && array[i] >= bestMatch) {
                    bestMatch = array[i];
                    index = i;
                }

            } else if ("odd".equals(type)) {
                if (array[i] % 2 == 1 && array[i] >= bestMatch) {
                    bestMatch = array[i];
                    index = i;
                }
            }
        }
        System.out.println(index == -1 ? "No matches" : index);
    }

    private static void getLast(int count, String type) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        String result = "";
        int counter = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            int element = array[i];

            String current = getElement(element, type);

            if (!"".equals(current)) {
                result = current + result;
                counter++;
            }

            if (counter == count) {
                break;
            }
        }
        System.out.println(Arrays.toString(result.split("\\s+")));
    }

    private static String getElement(int element, String type) {
        if ("even".equals(type)) {
            if (element % 2 == 0) {
                return element + " ";
            }
        } else if ("odd".equals(type)) {
            if (element % 2 == 1) {
                return element + " ";
            }
        }
        return "";
    }

    private static void getFirst(int count, String type) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        String result = "";
        int counter = 0;

        for (int element : array) {
            String current = getElement(element, type);

            if (!"".equals(current)) {
                result += current;
                counter++;
            }

            if (counter == count) {
                break;
            }
        }
        System.out.println(Arrays.toString(result.split("\\s+")));
    }
}