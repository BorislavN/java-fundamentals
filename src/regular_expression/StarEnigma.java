package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StarEnigma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern starPattern = Pattern.compile("[star]", Pattern.CASE_INSENSITIVE);
        Pattern decryptionPattern = Pattern.compile("[^@!:>-]*@(?<planet>[A-Za-z]+)[^@!:>-]*:\\d+[^@!:>-]*!(?<type>[AD])![^@!:>-]*->\\d+[^@!:>-]*");

        int lines = Integer.parseInt(reader.readLine());

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        while (lines-- > 0) {
            String message = reader.readLine();
            Matcher matcher = starPattern.matcher(message);

            int cipher = matcher.results().mapToInt(e -> 1).sum();

            message = message.chars()
                    .mapToObj(e -> Character.toString(e - cipher))
                    .collect(Collectors.joining(""));

            matcher.usePattern(decryptionPattern);
            matcher.reset(message);

            while (matcher.find()) {
                if ("A".equals(matcher.group("type"))) {
                    attacked.add(matcher.group("planet"));
                } else {
                    destroyed.add(matcher.group("planet"));
                }
            }
        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.stream().sorted().forEach(e -> System.out.printf("-> %s%n", e));

        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.stream().sorted().forEach(e -> System.out.printf("-> %s%n", e));
    }
}