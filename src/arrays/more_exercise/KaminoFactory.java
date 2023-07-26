package arrays.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class KaminoFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());
        int counter = 0;
        String line;

        int[] best = new int[length];
        int bestSum = -1;
        int bestStartIndex = Integer.MAX_VALUE;
        int bestLength = -1;
        int bestCounter = -1;

        while (!"Clone them!".equals(line = reader.readLine())) {
            int[] sequence = Arrays.stream(line.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();

            int currentLongestLength = 0;
            int currentStartIndex = Integer.MAX_VALUE;
            String temp = "";
            counter++;

            for (int index = 0; index < sequence.length; index++) {
                int currentElement = sequence[index];

                if (currentElement == 1) {
                    temp += currentElement;

                    if (temp.length() > currentLongestLength) {
                        currentLongestLength = temp.length();
                        currentStartIndex = index;
                    }
                } else {
                    temp = "";
                }
            }
            int currentSum = Arrays.stream(sequence).sum();

            if ((currentLongestLength > bestLength)
                    || ((currentLongestLength == bestLength) && (currentStartIndex < bestStartIndex))
                    || ((currentLongestLength == bestLength) && (currentStartIndex == bestStartIndex) && (currentSum > bestSum))) {

                best = sequence;
                bestLength = currentLongestLength;
                bestStartIndex = currentStartIndex;
                bestCounter = counter;
                bestSum = currentSum;
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n%s%n"
                , bestCounter
                , bestSum
                , Arrays.stream(best).mapToObj(Objects::toString).collect(Collectors.joining(" ")));
//        Map<Integer, int[]> map = new HashMap<>();
//
//        while (!"Clone them!".equals(line = reader.readLine())) {
//            int[] sequence = Arrays.stream(line.split("!+"))
//                    .mapToInt(Integer::parseInt).toArray();
//
//            map.put(++counter, sequence);
//        }
//
//        map.entrySet().stream().sorted((e1, e2) -> {
//            int[] e1Data = getData(e1.getValue());
//            int[] e2Data = getData(e2.getValue());
//
//            int result = e2Data[0] - e1Data[0];
//
//            if (result == 0) {
//                result = e1Data[1] - e2Data[1];
//            }
//
//            if (result == 0) {
//                result = e2Data[2] - e1Data[2];
//            }
//
//            return result;
//        }).limit(1).forEach(e -> {
//            System.out.printf("Best DNA sample %d with sum: %d.%n%s%n"
//                    , e.getKey()
//                    , getData(e.getValue())[2]
//                    , Arrays.stream(e.getValue()).mapToObj(Objects::toString).collect(Collectors.joining(" ")));
//        });
//    }
//
//    private static int[] getData(int[] entry) {
//        int sum = Arrays.stream(entry).sum();
//        int startIndex = Integer.MAX_VALUE;
//        int longestSequence = 0;
//        String temp = "";
//
//        for (int index = 0; index < entry.length; index++) {
//            int currentElement = entry[index];
//
//            if (currentElement == 1) {
//                temp += currentElement;
//
//                if (temp.length() > longestSequence) {
//                    longestSequence = temp.length();
//                    startIndex = index;
//                }
//            } else {
//                temp = "";
//            }
//        }
//        return new int[]{longestSequence, startIndex, sum};
    }
}