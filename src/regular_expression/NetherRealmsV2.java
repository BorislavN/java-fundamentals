package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealmsV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern healthPattern = Pattern.compile("[^0-9+\\-*/.,\\s]");
        Pattern baseDamagePattern = Pattern.compile("[+-]?\\d+\\.\\d+|[+-]?\\d+");

        for (String demon : reader.readLine().split(",\\s*")) {
            Matcher matcher = healthPattern.matcher(demon);

            int health = matcher.results()
                    .mapToInt(e -> e.group().charAt(0))
                    .sum();

            matcher.usePattern(baseDamagePattern);
            matcher.reset();

            double damage = matcher.results()
                    .mapToDouble(e -> Double.parseDouble(e.group()))
                    .sum();

            damage *= Math.pow(2, demon.chars().filter(e -> e == '*').count());
            damage /= Math.pow(2, demon.chars().filter(e -> e == '/').count());

            if (!demon.isBlank()) {
                System.out.printf("%s - %d health, %.2f damage%n"
                        , demon.trim()
                        , health
                        , damage
                );
            }
        }
    }
}