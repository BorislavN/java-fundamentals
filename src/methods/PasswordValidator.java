package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordValidator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(checkPassword(reader.readLine()));
    }

    private static String checkPassword(String pass) {
        StringBuilder output = new StringBuilder();

        if (!checkPassLength(pass)) {
            output.append("Password must be between 6 and 10 characters")
                    .append(System.lineSeparator());
        }

        if (!checkPassCharacters(pass)) {
            output.append("Password must consist only of letters and digits")
                    .append(System.lineSeparator());
        }

        if (!checkIfPassContainsDigits(pass)) {
            output.append("Password must have at least 2 digits")
                    .append(System.lineSeparator());
        }

        return output.toString().trim().length() == 0
                ? "Password is valid" : output.toString().trim();
    }

    private static boolean checkPassLength(String pass) {
        return pass.length() >= 6 && pass.length() <= 10;
    }

    private static boolean checkPassCharacters(String pass) {
        boolean flag = true;

        for (char symbol : pass.toLowerCase().toCharArray()) {
            if (!((symbol >= '0' && symbol <= '9') || (symbol >= 'a' && symbol <= 'z'))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean checkIfPassContainsDigits(String pass) {
        int count = 0;

        for (char symbol : pass.toLowerCase().toCharArray()) {
            if (symbol >= '0' && symbol <= '9') {
                count++;
            }
        }
        return count >= 2;
    }
}