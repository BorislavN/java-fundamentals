package data_types.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloatingEquality {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double precision=0.000001;
        double first=Double.parseDouble(reader.readLine());
        double second=Double.parseDouble(reader.readLine());

        if (Math.max(first,second)-Math.min(first,second)>=precision){
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}