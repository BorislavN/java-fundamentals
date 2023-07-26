package data_types.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        boolean isBalanced = false;
        String combination = "";

        while (lines-- > 0) {
            String input = reader.readLine();

            if ("(".equals(input) || ")".equals(input)) {
                combination += input;

                if ("()".equals(combination)) {
                    isBalanced = true;
                    combination = "";

                } else {
                    isBalanced = false;
                }
            }
        }
        System.out.println(isBalanced ? "BALANCED" : "UNBALANCED");
    }
}