package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        list = Arrays.stream(reader.readLine()
                .split("\\s+")).collect(Collectors.toList());

        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            switch (arguments[0]) {
                case "Add":
                    list.add(arguments[1]);
                    break;
                case "Remove":
                    int index = Integer.parseInt(arguments[1]);

                    if (isInRange(index)) {
                        list.remove(index);
                    }
                    break;
                case "Insert":
                    int currentIndex = Integer.parseInt(arguments[2]);

                    if (isInRange(currentIndex)) {
                        list.add(currentIndex, arguments[1]);
                    }
                    break;
                case "Shift":
                    shiftElement(arguments[1], Integer.parseInt(arguments[2]));
                    break;
            }
        }
        System.out.println(String.join(" ", list));
    }

    private static boolean isInRange(int index) {
        boolean flag = index >= 0 && index < list.size();

        if (!flag) {
            System.out.println("Invalid index");
        }
        return flag;
    }

    private static void shiftElement(String direction, int count) {
        for (int times = 0; times < count % list.size(); times++) {
            if ("left".equals(direction)) {
                list.add(list.remove(0));

            } else if ("right".equals(direction)) {
                list.add(0, list.remove(list.size() - 1));
            }
        }
    }
}