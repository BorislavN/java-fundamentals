package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elevator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int people=Integer.parseInt(reader.readLine());
        int capacity=Integer.parseInt(reader.readLine());

        System.out.println((int)Math.ceil(people*1.0/capacity));
    }
}