package arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EncryptArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        int[] output = new int[lines];

        for (int line = 0; line < lines; line++) {
            String input = reader.readLine();
            int score = 0;

            for (int index = 0; index < input.length(); index++) {
                char letter = input.charAt(index);

                switch (letter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        score += (letter * input.length());
                        break;
                    default:
                        score += (letter / input.length());
                        break;
                }
            }
            output[line] = score;
        }
        Arrays.sort(output);

        for (int element : output) {
            System.out.println(element);
        }
    }
}