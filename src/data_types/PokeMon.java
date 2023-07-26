package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PokeMon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int pokePower = Integer.parseInt(reader.readLine());
        int distance = Integer.parseInt(reader.readLine());
        int exhaustionFactor = Integer.parseInt(reader.readLine());

        int currentPower = pokePower;
        int targets = 0;

        while (currentPower >= distance) {
            currentPower -= distance;
            targets++;

            if (currentPower == pokePower * 0.5 && exhaustionFactor != 0) {
                currentPower /= exhaustionFactor;
            }
        }
        System.out.println(currentPower);
        System.out.println(targets);
    }
}