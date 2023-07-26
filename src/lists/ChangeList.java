package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = Arrays.stream(reader.readLine()
                .split("\\s+")).collect(Collectors.toList());
        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            if ("Delete".equals(arguments[0])) {
                for (int i = 0; i < list.size(); i++) {
                    if (arguments[1].equals(list.get(i))) {
                        list.remove(i);
                        i--;
                    }
                }

            } else if ("Insert".equals(arguments[0])) {
                int positions = Integer.parseInt(arguments[2]);

                list.add(positions, arguments[1]);
            }
        }
        System.out.println(String.join(" ", list));
    }
}