package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnonymousThreat {
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        list = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String line;

        while (!"3:1".equals(line = reader.readLine())) {
            String[] data = line.split("\\s+");

            if ("merge".equals(data[0])) {
                merge(Integer.parseInt(data[1]), Integer.parseInt(data[2]));

            } else if ("divide".equals(data[0])) {
                divide(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
        }
        System.out.println(String.join(" ", list));
    }

    private static void divide(int index, int parts) {
        if (isInRange(index)) {
            List<String> output = new ArrayList<>();

            String current = list.get(index);
            int length = current.length() / parts;

            while (output.size() < parts) {
                output.add(current.substring(0, length));

                current = (length < current.length()) ? current.substring(length) : "";
            }

            if (!"".equals(current)) {
                output.set(parts - 1, output.get(parts - 1) + current);
            }

            list.addAll(index + 1, output);
            list.remove(index);
        }
    }

    private static void merge(int start, int end) {
        int statIndex = isInRange(start) ? start : 0;
        int endIndex = isInRange(end + 1) ? end + 1 : list.size();

        String temp = String.join("", list.subList(statIndex, endIndex));
        list.subList(statIndex, endIndex).clear();
        list.add(statIndex, temp);
    }

    private static boolean isInRange(int index) {
        return index >= 0 && index < list.size();
    }
}