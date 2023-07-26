package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number=reader.readLine();
        int sum=0;

        for (int index = 0; index < number.length(); index++) {
            sum+=(number.charAt(index)-'0');
        }
        System.out.println(sum);
    }
}