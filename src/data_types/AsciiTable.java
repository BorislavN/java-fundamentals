package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int start=Integer.parseInt(reader.readLine());
        int end=Integer.parseInt(reader.readLine());

        for (int code = start; code <= end; code++) {
            System.out.printf("%c ",code);
        }
    }
}