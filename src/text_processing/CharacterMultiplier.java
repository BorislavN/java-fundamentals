package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        String[] data = reader.readLine().split("\\s+");

        for (int index = 0; index < Math.max(data[0].length(), data[1].length()); index++) {
            sum += getDigitScore(data[0], index) * getDigitScore(data[1], index);
        }

        System.out.println(sum);
    }

    private static int getDigitScore(String word, int index) {
        if (index >= 0 && index < word.length()) {
            return word.charAt(index);
        }
        return 1;
    }
}