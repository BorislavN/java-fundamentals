package text_processing.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MoresCodeTranslator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Map<String, String> morseMap = new HashMap<>();

        for (int index = 0; index < morseCode.length; index++) {
            String code = morseCode[index];
            morseMap.put(code, Character.toString('A' + index));
        }

        System.out.println(Arrays.stream(reader.readLine().split("\\s+\\|\\s+"))
                .map(element -> Arrays.stream(element.split("\\s+"))
                        .map(morseMap::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" ")));
    }
}