package methods.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MultiplicationSign {
    private static int negativeCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());

        System.out.println(getMultiplicationSign(num1, num2, num3));
//        System.out.println(getSignV2(num1, num2, num3));
    }

    private static String getMultiplicationSign(int num1, int num2, int num3) {
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            return "zero";
        }

        checkSign(num1);
        checkSign(num2);
        checkSign(num3);

        return negativeCounter % 2 == 0 ? "positive" : "negative";
    }

    private static void checkSign(int num) {
        if (num < 0) {
            negativeCounter++;
        }
    }

    private static String getSignV2(int... numbers) {
        if (Arrays.stream(numbers).filter(e -> e == 0).count() != 0) {
            return "zero";
        }

        if (Arrays.stream(numbers).filter(e -> e < 0).count() % 2 == 0) {
            return "positive";
        }
        return "negative";
    }
}