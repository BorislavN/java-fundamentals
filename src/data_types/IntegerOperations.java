package data_types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number1=Integer.parseInt(reader.readLine());
        int number2=Integer.parseInt(reader.readLine());
        int number3=Integer.parseInt(reader.readLine());
        int number4=Integer.parseInt(reader.readLine());

        System.out.println(((number1+number2)/number3)*number4);
    }
}