package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder output=new StringBuilder();

        reader.readLine().chars().map(e->e+3).forEach(code->{
            output.append((char)code);
        });

        System.out.println(output);
    }
}