package regular_expression.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SantaSecretHelper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int key = Integer.parseInt(reader.readLine());
        Pattern pattern = Pattern.compile("[^@\\-!:>]*@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behaviour>[GN])![^@\\-!:>]*");
        String message;

        while (!"end".equals(message = reader.readLine())) {
            Matcher matcher = pattern.matcher(message.chars()
                    .mapToObj(e -> Character.toString(e - key))
                    .collect(Collectors.joining())
            );

            if (matcher.find() && "G".equals(matcher.group("behaviour"))) {
                System.out.println(matcher.group("name"));
            }
        }
    }
}