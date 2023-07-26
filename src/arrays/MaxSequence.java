package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        int longestCount = 0;
        String longestChar = "";
        int tempCount = 0;
        String tempChar = "";

        for (String current : elements) {
            if ("".equals(tempChar) || tempChar.equals(current)) {
                tempChar = current;
                tempCount++;

                if (tempCount > longestCount) {
                    longestCount = tempCount;
                    longestChar = tempChar;
                }
                continue;
            }
            tempChar = current;
            tempCount = 1;
        }
        System.out.println((longestChar + " ").repeat(longestCount).trim());
    }
}