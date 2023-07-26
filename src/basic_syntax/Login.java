package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String username = reader.readLine();

        for (int attempt = 0; attempt < 4; attempt++) {
            StringBuilder password = new StringBuilder(reader.readLine());

            if (username.equals(password.reverse().toString())) {
                System.out.printf("User %s logged in.%n", username);
                return;

            } else if (attempt == 3) {
                break;
            }
            System.out.println("Incorrect password. Try again.");
        }
        System.out.printf("User %s blocked!%n", username);
    }
}