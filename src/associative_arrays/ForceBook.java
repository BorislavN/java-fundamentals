package associative_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForceBook {
    private static Map<String, List<String>> forceBook;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        forceBook = new LinkedHashMap<>();
        String line;

        while (!"Lumpawaroo".equals(line = reader.readLine())) {
            String side = "";
            String user = "";
            if (line.contains("|")) {
                String[] data = line.split(" \\| ");

                if ("".equals(forceUserHasChosenASide(data[1]))) {
                    forceBook.putIfAbsent(data[0], new ArrayList<>());
                    forceBook.get(data[0]).add(data[1]);
                }
            }

            if (line.contains("->")) {
                String[] data = line.split(" -> ");

                String sideKey = forceUserHasChosenASide(data[0]);

                if (!"".equals(sideKey)) {
                    forceBook.get(sideKey).remove(data[0]);
                }

                forceBook.putIfAbsent(data[1], new ArrayList<>());
                forceBook.get(data[1]).add(data[0]);

                System.out.printf("%s joins the %s side!%n"
                        , data[0]
                        , data[1]);
            }
        }

        forceBook.forEach((side, users) -> {
            if (users.size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", side, users.size());

                users.forEach(user -> System.out.printf("! %s%n", user));
            }
        });
    }

    private static String forceUserHasChosenASide(String name) {
        for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
            if (entry.getValue().contains(name)) {
                return entry.getKey();
            }
        }
        return "";
    }
}