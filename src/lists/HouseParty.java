package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HouseParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] arguments = reader.readLine().split("\\s+");

            if (arguments.length == 3) {
                if (list.contains(arguments[0])) {
                    System.out.printf("%s is already in the list!%n", arguments[0]);
                    continue;
                }
                list.add(arguments[0]);

            } else if (arguments.length == 4) {
                if (!list.contains(arguments[0])) {
                    System.out.printf("%s is not in the list!%n", arguments[0]);
                    continue;
                }
                list.remove(arguments[0]);
            }
        }
        System.out.print(String.join(System.lineSeparator(), list));
    }
}