package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split("\\s+");
        String[] second = reader.readLine().split("\\s+");

        for (String secondElement : second) {
            for (String firstElement : first) {
                if (firstElement.equals(secondElement)) {
                    System.out.print(firstElement + " ");
                }
            }
        }
    }
}