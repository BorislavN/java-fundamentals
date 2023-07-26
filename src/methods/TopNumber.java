package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int number = 1; number <= n; number++) {
            if (isNumberTop(number)) {
                System.out.println(number);
            }
        }
    }

    private static boolean isNumberTop(int n) {
        boolean flag = false;
        int sum = 0;

        while (n > 0) {
            int current = n % 10;
            sum += current;

            if (current % 2 == 1) {
                flag = true;
            }

            n /= 10;
        }

        return (sum % 8 == 0) && flag;
    }
}