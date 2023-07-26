package text_processing.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractInformation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines=Integer.parseInt(reader.readLine());

        while (lines-->0){
            System.out.println(getNameAndAge(reader.readLine()));
        }
    }

    private static String getNameAndAge(String input) {
        int nameStart = input.indexOf("@");
        int nameEnd = input.indexOf("|");
        int ageStart = input.indexOf("#");
        int ageEnd = input.indexOf("*");

        return String.format("%s is %s years old."
                , input.substring(nameStart + 1, nameEnd)
                , input.substring(ageStart + 1, ageEnd)
        );
    }
}