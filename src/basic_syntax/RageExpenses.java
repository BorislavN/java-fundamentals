package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RageExpenses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lostGames = Integer.parseInt(reader.readLine());
        double headsetTotal = Double.parseDouble(reader.readLine()) * (lostGames / 2);
        double mouseTotal = Double.parseDouble(reader.readLine()) * (lostGames / 3);
        double keyboardTotal = Double.parseDouble(reader.readLine()) * (lostGames / 6);
        double displayTotal = Double.parseDouble(reader.readLine()) * (lostGames / 12);

        System.out.printf("Rage expenses: %.2f lv.%n", headsetTotal
                + mouseTotal
                + keyboardTotal
                + displayTotal);
    }
}