package basic_syntax.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnglishNameOfDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number=Integer.parseInt(reader.readLine());
        String output="";

        switch (number%10){
            case 0:output="zero";break;
            case 1:output="one";break;
            case 2:output="two";break;
            case 3:output="three";break;
            case 4:output="four";break;
            case 5:output="five";break;
            case 6:output="six";break;
            case 7:output="seven";break;
            case 8:output="eight";break;
            case 9:output="nine";break;
        }
        System.out.println(output);
    }
}