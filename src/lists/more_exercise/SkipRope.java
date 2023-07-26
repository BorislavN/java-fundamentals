package lists.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SkipRope {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> letters = new ArrayList<>();
        List<Integer> take = new ArrayList<>();
        List<Integer> skip = new ArrayList<>();

        for (char element : reader.readLine().toCharArray()) {
            if (Character.isDigit(element)) {
                if (take.size() == skip.size()) {
                    take.add(Character.getNumericValue(element));
                    continue;
                }
                skip.add(Character.getNumericValue(element));

            } else {
                letters.add(String.valueOf(element));
            }
        }
        System.out.println(decode(letters, take, skip));
    }

    private static String decode(List<String> letters, List<Integer> take, List<Integer> skip) {
        String output = "";
        int wordIndex = 0;

        for (int index = 0; index < Math.min(take.size(), skip.size()); index++) {
            int toTake = take.get(index);
            int toSkip = skip.get(index);

            output += String.join(""
                    , letters.subList(wordIndex, Math.min(wordIndex + toTake, letters.size())));

            wordIndex += toTake + toSkip;
        }
        return output;
    }
}