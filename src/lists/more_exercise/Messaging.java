package lists.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] indexes = reader.readLine().split("\\s+");

        List<String> text = reader.readLine().chars()
                .mapToObj(Character::toString)
                .collect(Collectors.toList());

        for (String element : indexes) {
            int index = Arrays.stream(element.split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();

            System.out.print(text.remove(index % text.size()));
        }
    }
}