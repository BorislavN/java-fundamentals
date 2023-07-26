package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Train {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines=Integer.parseInt(reader.readLine());
        int[] train=new int[lines];

        for (int index = 0; index < lines; index++) {
            train[index]=Integer.parseInt(reader.readLine());

            System.out.print(train[index]+" ");
        }
        System.out.printf("%n%s%n",Arrays.stream(train).sum());
    }
}