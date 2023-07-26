package associative_arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MOBAChallenger {
    public static Map<String, Map<String, Integer>> players;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        players = new TreeMap<>();
        String line;

        while (!"Season end".equals(line = reader.readLine())) {
            if (line.contains("->")) {
                String[] data = line.split(" -> ");
                int skill = Integer.parseInt(data[2]);

                players.putIfAbsent(data[0], new TreeMap<>());
                players.get(data[0]).putIfAbsent(data[1], 0);
                players.get(data[0])
                        .put(data[1], Math.max(players.get(data[0]).get(data[1]), skill));
            } else {
                String[] data = line.split(" vs ");

                if (hasCommonPosition(data[0], data[1])) {
                    int playerOneSkill = getTotalSkill(data[0]);
                    int playerTwoSkill = getTotalSkill(data[1]);

                    if (playerOneSkill > playerTwoSkill) {
                        players.remove(data[1]);
                    } else if (playerTwoSkill > playerOneSkill) {
                        players.remove(data[0]);
                    }
                }
            }
        }
        StringBuilder output = new StringBuilder();

        players.entrySet()
                .stream()
                .sorted((p1, p2) -> Integer.compare(getTotalSkill(p2.getKey()), getTotalSkill(p1.getKey())))
                .forEach(entry -> {
                    output.append(String.format("%s: %d skill%n"
                            , entry.getKey()
                            , getTotalSkill(entry.getKey())));

                    entry.getValue().entrySet()
                            .stream()
                            .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                            .forEach(position -> output.append(String.format("- %s <::> %d%n"
                                    , position.getKey()
                                    , position.getValue())));
                });

        System.out.println(output);
    }

    private static boolean hasCommonPosition(String player1, String player2) {
        if (players.get(player1) == null || players.get(player2) == null) {
            return false;
        }

        Set<String> player1Positions = players.get(player1).keySet();

        for (String positionOfPlayer2 : players.get(player2).keySet()) {
            if (player1Positions.contains(positionOfPlayer2)) {
                return true;
            }
        }
        return false;
    }

    private static int getTotalSkill(String name) {
        return players.get(name).values().stream().mapToInt(Integer::intValue).sum();
    }
}