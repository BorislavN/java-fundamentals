package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern emailPattern = Pattern.compile(" ([A-Za-z0-9+]+[\\-_.]*[A-Za-z0-9+]+)@([A-Za-z]+[\\-.]*[A-Za-z]+)(\\.[A-Za-z]+[.\\-]*[A-Za-z]+)+");
        Matcher matcher = emailPattern.matcher(reader.readLine());

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}