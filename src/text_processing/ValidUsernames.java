package text_processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(\\w|-){3,16}$");

        for (String word : reader.readLine().split(", ")) {
//            if (isValid(word) && hasValidLength(word)) {
//                System.out.println(word);
//            }
            Matcher matcher = pattern.matcher(word);

            if (matcher.matches()) {
                System.out.println(word);
            }
        }
    }

//    private static boolean isHyphenOrUnderscore(char letter) {
//        return letter == 45 || letter == 95;
//    }
//
//    private static boolean isValid(String username) {
//        for (char current : username.toCharArray()) {
//            if (!(isHyphenOrUnderscore(current) || Character.isLetterOrDigit(current))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean hasValidLength(String word) {
//        return word.length() >= 3 && word.length() <= 16;
//    }
}