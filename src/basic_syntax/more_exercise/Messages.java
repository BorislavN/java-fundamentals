package basic_syntax.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Messages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String combination = reader.readLine();
            int digit = Character.getNumericValue(combination.charAt(0));

            if (digit == 0) {
                System.out.print(" ");
            } else {
                int offset = (digit - 2) * 3;//the count of characters before our group

                if (digit == 8 || digit == 9) {
                    offset += 1;//add 1 if the group is larger
                }

                System.out.print((char) ('a' + offset + combination.length() - 1));
                //to the count of the previous chars we add the index of the letter in the current group
            }
        }
    }
}