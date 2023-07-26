package data_types.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecryptMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int key=Integer.parseInt(reader.readLine());
        int lines=Integer.parseInt(reader.readLine());

        while (lines-->0){
            System.out.print((char)(key + reader.readLine().charAt(0)));
        }
    }
}