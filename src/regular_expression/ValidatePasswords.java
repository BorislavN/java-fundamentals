package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidatePasswords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        Pattern pattern = Pattern.compile("^_\\.+[A-Z][A-Za-z0-9]{4,}[A-Z]_\\.+$");
        Pattern countDigits = Pattern.compile("\\d");

        while (lines-- > 0) {
            Matcher matcher = pattern.matcher(reader.readLine());

            if (matcher.matches()) {
                matcher.usePattern(countDigits);
                matcher.reset();

                String group = matcher.results()
                        .map(MatchResult::group)
                        .collect(Collectors.joining());

                System.out.printf("Group: %s%n", group.isBlank() ? "default" : group);
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}