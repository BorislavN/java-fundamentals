package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines=Integer.parseInt(reader.readLine());
        int sum=0;

        while (lines-->0){
            sum+=reader.readLine().charAt(0);
        }
        System.out.println("The sum equals: "+sum);
    }
}