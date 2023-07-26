package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern healthPattern = Pattern.compile("[^0-9+\\-*/.,\\s]");
        Pattern baseDamagePattern = Pattern.compile("[+-]?\\d+\\.\\d+|[+-]?\\d+");
        Pattern modifierPattern = Pattern.compile("[*/]");

        for (String demon : reader.readLine().split(",\\s*")) {
            Matcher matcher = healthPattern.matcher(demon);

            int health = matcher.results()
                    .mapToInt(e -> e.group().charAt(0))
                    .sum();

            resetMatcher(matcher, baseDamagePattern);
            double damage = matcher.results()
                    .mapToDouble(e -> Double.parseDouble(e.group()))
                    .sum();

            resetMatcher(matcher, modifierPattern);
            damage = getFinalDamage(damage, matcher.results().collect(Collectors.toList()));

            if (!demon.isBlank()) {
                System.out.printf("%s - %d health, %.2f damage%n"
                        , demon.trim()
                        , health
                        , damage
                );
            }
        }
    }

    private static void resetMatcher(Matcher matcher, Pattern pattern) {
        matcher.usePattern(pattern);
        matcher.reset();
    }

    private static double getFinalDamage(double baseDamage, List<MatchResult> modifiers) {
        for (MatchResult modifier : modifiers) {
            if ("*".equals(modifier.group())) {
                baseDamage *= 2;
            } else if ("/".equals(modifier.group())) {
                baseDamage /= 2;
            }
        }
        return baseDamage;
    }
}