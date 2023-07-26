package text_processing.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreasureFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] keys = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String line;

        while (!"find".equals(line = reader.readLine())) {
            String decryptedMessage = decrypt(keys, line);

            int itemStart = decryptedMessage.indexOf('&');
            int itemEnd = decryptedMessage.lastIndexOf('&');
            int coordinatesStart = decryptedMessage.indexOf('<');
            int coordinatesEnd = decryptedMessage.lastIndexOf('>');

            System.out.printf("Found %s at %s%n"
                    , decryptedMessage.substring(itemStart + 1, itemEnd)
                    , decryptedMessage.substring(coordinatesStart + 1, coordinatesEnd)
            );
        }
    }

    private static String decrypt(int[] keys, String line) {
        StringBuilder output = new StringBuilder(line);

        for (int index = 0; index < output.length(); index++) {
            int key = keys[index % keys.length];

            output.setCharAt(index, (char) (line.charAt(index) - key));
        }
        return output.toString();
    }
}