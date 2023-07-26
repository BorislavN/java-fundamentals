package text_processing.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiSumator {
    private static int startIndex;
    private static int endIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        startIndex = reader.readLine().charAt(0);
        endIndex = reader.readLine().charAt(0);

        System.out.println(reader.readLine().chars().map(AsciiSumator::getScore).sum());
    }

    private static int getScore(int current) {
        if (current > startIndex && current < endIndex) {
            return current;
        }
        return 0;
    }
}