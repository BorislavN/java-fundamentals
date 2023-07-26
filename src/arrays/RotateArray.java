package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] array = reader.readLine().split("\\s+");
        int rotations = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < rotations%array.length; cycles++) {
            String temp = array[0];

            for (int index = 0; index < array.length - 1; index++) {
                array[index] = array[index + 1];
            }
            array[array.length - 1] = temp;
        }
        System.out.println( String.join(" ",array));
    }
}