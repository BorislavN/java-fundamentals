package associative_arrays.more_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmyOld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, int[]>> dragonArmy = new LinkedHashMap<>();
        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {
            String[] dragon = scanner.nextLine().split("\\s+");

            dragonArmy.putIfAbsent(dragon[0], new TreeMap<>());
            dragonArmy.get(dragon[0]).putIfAbsent(dragon[1], new int[3]);
            dragonArmy.get(dragon[0]).get(dragon[1])[0] = dragon[2].equals("null") ? 45 : Integer.parseInt(dragon[2]);
            dragonArmy.get(dragon[0]).get(dragon[1])[1] = dragon[3].equals("null") ? 250 : Integer.parseInt(dragon[3]);
            dragonArmy.get(dragon[0]).get(dragon[1])[2] = dragon[4].equals("null") ? 10 : Integer.parseInt(dragon[4]);
        }
        dragonArmy.forEach((type, dragon) -> {
            double damageAV = dragon.values().stream().mapToDouble(valueSet -> valueSet[0]).sum() / dragon.size();
            double healthAV = dragon.values().stream().mapToDouble(valueSet -> valueSet[1]).sum() / dragon.size();
            double armorAV = dragon.values().stream().mapToDouble(valueSet -> valueSet[2]).sum() / dragon.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, damageAV, healthAV, armorAV);
            dragon.forEach((key, value) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", key,
                    value[0], value[1], value[2]));
        });
    }
}