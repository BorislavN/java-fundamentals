package associative_arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
        int line = Integer.parseInt(reader.readLine());

        while (line-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            int[] stats = {
                    "null".equals(data[2]) ? 45 : Integer.parseInt(data[2]),
                    "null".equals(data[3]) ? 250 : Integer.parseInt(data[3]),
                    "null".equals(data[4]) ? 10 : Integer.parseInt(data[4])
            };

            dragons.putIfAbsent(data[0], new TreeMap<>());
            dragons.get(data[0]).put(data[1], stats);
        }

        dragons.forEach((type, list) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n"
                    , type
                    , getAverage(0, list.values())
                    , getAverage(1, list.values())
                    , getAverage(2, list.values()));

            list.forEach((name, stats) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                    , name
                    , stats[0]
                    , stats[1]
                    , stats[2]));
        });
    }

    private static double getAverage(int index, Collection<int[]> stats) {
        return stats.stream().mapToDouble(dragon -> dragon[index]).sum() / stats.size();
    }
}