package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile(">>(\\w+)<<(\\d+|\\d+\\.\\d+)!(\\d+)");
        String line;

        double total = 0;
        StringBuilder output = new StringBuilder("Bought furniture:");

        while (!"Purchase".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                output.append(System.lineSeparator());
                output.append(matcher.group(1));

                total += (Double.parseDouble(matcher.group(2))
                        * Double.parseDouble(matcher.group(3)));
            }
        }

        output.append(String.format("%nTotal money spend: %.2f", total));

        System.out.println(output);
    }
}