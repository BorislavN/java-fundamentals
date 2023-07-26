package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiceMustFlow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int startYield=Integer.parseInt(reader.readLine());
        int spice=0;
        int days=0;

        for (int yield = startYield; yield >=100 ; yield-=10) {
            spice+=(yield-26);
            days++;
        }

        if (spice-26>=0){
            spice-=26;
        }
        System.out.println(days);
        System.out.println(spice);
    }
}