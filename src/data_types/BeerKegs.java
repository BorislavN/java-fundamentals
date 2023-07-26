package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeerKegs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String biggestKeg = "";
        double biggestKegVolume = 0;

        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String name = reader.readLine();
            double radius = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > biggestKegVolume) {
                biggestKegVolume = volume;
                biggestKeg = name;
            }
        }
        System.out.println(biggestKeg);
    }
}