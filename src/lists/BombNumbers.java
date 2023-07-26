package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BombNumbers {
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        list = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String[] data = reader.readLine().split("\\s+");

        int power = Integer.parseInt(data[1]);
        String bomb = data[0];

        while (list.contains(bomb)) {
            int index = list.indexOf(bomb);

            explode(index, power);
        }
        System.out.println(list.stream().mapToInt(Integer::parseInt).sum());
    }

    private static void explode(int index, int power) {
        int startOfBlast = Math.max(0, index - power);
        int endOfBlast = Math.min(list.size() - 1, index + power);

        for (int i = endOfBlast; i >= startOfBlast; i--) {
            list.remove(i);
        }
    }
}