package exam.final_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DestinationMapper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("([/=])([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(reader.readLine());

        List<String> results = matcher.results()
                .map(e -> e.group(2))
                .collect(Collectors.toList());

        System.out.printf("Destinations: %s%n", String.join(", ", results));
        System.out.printf("Travel Points: %d%n", results.stream().mapToInt(String::length).sum());
    }
}