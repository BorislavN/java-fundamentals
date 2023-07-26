package lists.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> field = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int middle = field.size() / 2;

        double playerOne = getScore(field.subList(0, middle), "left");
        double playerTwo = getScore(field.subList(middle + 1, field.size()), "right");

        System.out.printf("The winner is %s with total time: %.1f%n"
                , playerOne < playerTwo ? "left" : "right"
                , Math.min(playerOne, playerTwo));
    }

    private static double getScore(List<Integer> times, String direction) {
        if ("right".equals(direction)) {
            Collections.reverse(times);
        }

        double score = 0;

        for (Integer current : times) {
            if (current == 0) {
                score *= 0.8;
            } else {
                score += current;
            }
        }
        return score;
    }
}