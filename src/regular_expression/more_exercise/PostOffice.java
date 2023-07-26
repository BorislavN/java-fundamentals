package regular_expression.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\|");

        Pattern startPattern = Pattern.compile("([#$%*&])[A-Z]+\\1");
        String lengthPattern = "(?<start>%d):(?<length>\\d{2})";
        String wordPattern = "(?:^|\\s)(?<word>%c[^\\s]{%d})(?:\\s|$)";

        Matcher matcher = startPattern.matcher(data[0]);
        String letters = "";

        if (matcher.find()) {
            letters = matcher.group();
            letters = letters.substring(1, letters.length() - 1);
        }

        for (char letterCode : letters.toCharArray()) {
            matcher.usePattern(Pattern.compile(String.format(lengthPattern, (int) letterCode)));
            matcher.reset(data[1]);

            if (matcher.find()) {
                matcher.usePattern(Pattern.compile(String.format(wordPattern
                        , (char) Integer.parseInt(matcher.group("start"))
                        , Integer.parseInt(matcher.group("length")))));
            }

            matcher.reset(data[2]);

            if (matcher.find()) {
                System.out.println(matcher.group("word"));
            }
        }
    }
}