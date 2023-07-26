package regular_expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("%([A-Z][a-z]+)%.*<(\\w+)>.*\\|(\\d+)\\|\\D*(\\d+|\\d+\\.\\d+)\\$");
        String line;

        StringBuilder output = new StringBuilder();
        double income = 0;

        while (!"end of shift".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                double cost = Double.parseDouble(matcher.group(3))
                        * Double.parseDouble(matcher.group(4));

                income += cost;
                output.append(String.format("%s: %s - %.2f%n"
                        , matcher.group(1)
                        , matcher.group(2)
                        , cost)
                );
            }
        }

        output.append(String.format("Total income: %.2f", income));

        System.out.println(output);
    }
}