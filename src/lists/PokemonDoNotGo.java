package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    private static List<Integer> field;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        field = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int total = 0;
        int current;

        while (field.size() > 0) {
            int index = Integer.parseInt(reader.readLine());

            if (index < 0) {
                current = field.get(0);
                field.set(0, field.get(field.size() - 1));

            } else if (index >= field.size()) {
                current = field.get(field.size() - 1);
                field.set(field.size() - 1, field.get(0));

            } else {
                current = field.remove(index);
            }

            modifyField(current);
            total+=current;
        }
        System.out.println(total);
    }

    private static void modifyField(int current) {
        field = field.stream()
                .map(element -> element <= current
                        ? element + current
                        : element - current)
                .collect(Collectors.toList());
    }
}