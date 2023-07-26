package lists.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double money = Double.parseDouble(reader.readLine());

        List<Integer> initialSet = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> drumSet = new ArrayList<>(initialSet);
        String line;

        while (!"Hit it again, Gabsy!".equals(line = reader.readLine())) {
            int power = Integer.parseInt(line);

            for (int index = 0; index < drumSet.size(); index++) {
                drumSet.set(index, drumSet.get(index) - power);

                if (drumSet.get(index) <= 0) {
                    double cost = initialSet.get(index) * 3;

                    if (cost <= money) {
                        drumSet.set(index, initialSet.get(index));
                        money -= cost;

                    } else {
                        drumSet.remove(index);
                        initialSet.remove(index);
                        index--;
                    }
                }
            }
        }
        System.out.println(drumSet.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.%n", money);
    }
}