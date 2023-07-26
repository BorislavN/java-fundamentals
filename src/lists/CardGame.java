package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> player1 = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> player2 = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        for (int index = 0; index < Math.min(player1.size(), player2.size()); index++) {
            int playerOneCard = player1.remove(index);
            int playerTwoCard = player2.remove(index);

            if (playerOneCard > playerTwoCard) {
                player1.add(playerOneCard);
                player1.add(playerTwoCard);

            } else if (playerTwoCard > playerOneCard) {
                player2.add(playerTwoCard);
                player2.add(playerOneCard);
            }
            index--;
        }
        if (player1.size() > 0) {
            System.out.printf("First player wins! Sum: %d%n"
                    , player1.stream().mapToInt(Integer::intValue).sum());

        } else if (player2.size() > 0) {
            System.out.printf("Second player wins! Sum: %d%n"
                    , player2.stream().mapToInt(Integer::intValue).sum());
        }
    }
}