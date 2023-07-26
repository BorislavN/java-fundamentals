package data_types.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftToRight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());


        while (lines-- > 0) {
            String line = reader.readLine();
            int spaceIndex = line.indexOf(' ');

            long firstNum = Long.parseLong(line.substring(0, spaceIndex));
            long secondNum = Long.parseLong(line.substring(spaceIndex + 1));
            int charSum = 0;

            long highestNumber = Math.abs(Math.max(firstNum, secondNum));

            while (highestNumber > 0) {
                charSum += highestNumber % 10;
                highestNumber /= 10;
            }
            System.out.println(charSum);
        }
    }
}