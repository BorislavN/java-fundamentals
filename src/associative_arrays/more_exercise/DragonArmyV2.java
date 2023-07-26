package associative_arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmyV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<Dragon>> dragons = new LinkedHashMap<>();
        int line = Integer.parseInt(reader.readLine());

        while (line-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            dragons.putIfAbsent(data[0], new TreeSet<>());

            dragons.get(data[0]).removeIf(e -> data[1].equals(e.name()));
            dragons.get((data[0])).add(Dragon.crateDragon(data));
        }

        dragons.forEach((type, list) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n"
                    , type
                    , list.stream().mapToDouble(Dragon::damage).sum() / list.size()
                    , list.stream().mapToDouble(Dragon::health).sum() / list.size()
                    , list.stream().mapToDouble(Dragon::armor).sum() / list.size()
            );

            list.forEach(System.out::println);
        });
    }
}

record Dragon(String name, int damage, int health, int armor) implements Comparable<Dragon> {

    @Override
    public int compareTo(Dragon o) {
        return this.name.compareTo(o.name());
    }

    public static Dragon crateDragon(String[] data) {
        int attack = "null".equals(data[2]) ? 45 : Integer.parseInt(data[2]);
        int health = "null".equals(data[3]) ? 250 : Integer.parseInt(data[3]);
        int armor = "null".equals(data[4]) ? 10 : Integer.parseInt(data[4]);

        return new Dragon(data[1], attack, health, armor);
    }

    @Override
    public String toString() {
        return String.format("-%s -> damage: %d, health: %d, armor: %d"
                , this.name
                , this.damage
                , this.health
                , this.armor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Dragon) obj;
        return Objects.equals(this.name, that.name) &&
                this.damage == that.damage &&
                this.health == that.health &&
                this.armor == that.armor;
    }
}