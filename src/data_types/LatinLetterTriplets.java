package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LatinLetterTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int letters = Integer.parseInt(reader.readLine());

        for (int firstLetter = 0; firstLetter < letters; firstLetter++) {
            for (int secondLetter = 0; secondLetter < letters; secondLetter++) {
                for (int thirdLetter = 0; thirdLetter < letters; thirdLetter++) {
                    System.out.printf("%c%c%c%n"
                            , 'a' + firstLetter
                            , 'a' + secondLetter
                            , 'a' + thirdLetter);
                }
            }
        }
    }
}