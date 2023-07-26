package regular_expression.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<str>\\D+)(?<count>\\d+)");
        Matcher matcher = pattern.matcher(reader.readLine());

        StringBuilder output = new StringBuilder();

        while (matcher.find()) {
            output.append(matcher.group("str")
                    .toUpperCase().repeat(Integer
                            .parseInt(matcher.group("count"))));

        }

        System.out.printf("Unique symbols used: %d%n", output.chars().distinct().count());
        System.out.println(output);
    }
}