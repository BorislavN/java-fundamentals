package regular_expression.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("([@#^$])\\1{5,9}");

        for (String ticket : reader.readLine().split("\\s*,\\s*")) {
            if (ticket.length() == 20) {
                String left = ticket.substring(0, 10);
                String right = ticket.substring(10);

                Matcher matcher = pattern.matcher(left);
                String leftResult = matcher.find() ? matcher.group() : "";

                matcher.reset(right);
                String rightResult = matcher.find() ? matcher.group() : "";

                if (!leftResult.isBlank() && !rightResult.isBlank() && leftResult.charAt(0) == rightResult.charAt(0)) {
                    int minLength = Math.min(leftResult.length(), rightResult.length());

                    System.out.printf("ticket \"%s\" - %d%s%s%n"
                            , ticket
                            , minLength
                            , leftResult.charAt(0)
                            , minLength == 10 ? " Jackpot!" : ""
                    );

                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            } else if (!ticket.isBlank()) {
                System.out.println("invalid ticket");
            }
        }
    }
}