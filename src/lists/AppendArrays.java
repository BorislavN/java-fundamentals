package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = Arrays.stream(reader.readLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(list);

        String output = String.join(" ", list);

        System.out.println(output.replaceAll("\\s+", " "));
    }
}