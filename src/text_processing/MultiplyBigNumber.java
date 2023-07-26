package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number1 = removeLeadingZeroes(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());

        if (number2 == 0) {
            System.out.println(0);
            return;
        }

        int carryOn = 0;
        StringBuilder output = new StringBuilder();

        for (int index = number1.length() - 1; index >= 0; index--) {
            int temp = Character.getNumericValue(number1.charAt(index));
            int result = (temp * number2) + carryOn;

            carryOn = result / 10;
            output.insert(0, result % 10);
        }

        output.insert(0, carryOn != 0 ? carryOn : "");

        System.out.println(output);
    }

    private static String removeLeadingZeroes(String input) {
        int actualBeginningIndex = -1;

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) != '0') {
                actualBeginningIndex = index;
                break;
            }
        }

        return actualBeginningIndex != -1 ? input.substring(actualBeginningIndex) : "0";
    }
}