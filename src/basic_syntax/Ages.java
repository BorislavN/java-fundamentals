package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ages {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       int age=Integer.parseInt(reader.readLine());
       var output="";

       if (age>=0&&age<=2){
           output="baby";
       } else if (age >= 3 && age <= 13) {
           output="child";
       }else if (age >= 14 && age <= 19) {
           output="teenager";
       }else if (age >= 20 && age <= 65) {
           output="adult";
       }else if (age >= 66) {
           output="elder";
       }
        System.out.println(output);
    }
}