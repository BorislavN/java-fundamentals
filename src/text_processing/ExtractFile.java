package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path = reader.readLine();
        int index = path.lastIndexOf(92);

        String[] data = path.substring(index+1).split("\\.");

        System.out.printf("File name: %s%nFile extension: %s%n"
                , data[0]
                , data[1]
        );
    }
}