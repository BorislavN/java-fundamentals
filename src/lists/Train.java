package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> train = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(reader.readLine());
        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            if ("Add".equals(arguments[0])) {
                int passengers = Integer.parseInt(arguments[1]);

                if (passengers <= capacity) {
                    train.add(passengers);
                }
            } else {
                int people = Integer.parseInt(arguments[0]);

                for (int i = 0; i < train.size(); i++) {
                    int sum = train.get(i) + people;

                    if (sum <= capacity) {
                        train.set(i, sum);
                        break;
                    }
                }
            }
        }
        System.out.println(train.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}