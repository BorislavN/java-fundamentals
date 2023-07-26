package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterOverflow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines=Integer.parseInt(reader.readLine());
        final int capacity=255;
        int total=0;

        while (lines-->0){
            int water =Integer.parseInt(reader.readLine());

            if (water<=capacity-total){
                total+=water;
            }else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(total);
    }
}