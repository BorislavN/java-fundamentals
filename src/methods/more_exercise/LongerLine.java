package methods.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongerLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double bestDistance = -1;
        String bestLine = "";

        for (int i = 0; i < 2; i++) {
            int startX = Integer.parseInt(reader.readLine());
            int startY = Integer.parseInt(reader.readLine());
            int endX = Integer.parseInt(reader.readLine());
            int endY = Integer.parseInt(reader.readLine());

            double distance = findDistanceBetween(startX, startY, endX, endY);

            if (distance > bestDistance) {
                bestDistance = distance;

                bestLine = formatOutput(startX, startY, endX, endY);
            }
        }
        System.out.println(bestLine);
    }

    private static double findDistanceBetween(int startX, int startY, int endX, int endY) {
        return Math.sqrt(Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
    }

    private static String formatOutput(int startX, int startY, int endX, int endY) {
        double distanceFromCenterOne = findDistanceBetween(0, 0, startX, startY);
        double distanceFromCenterTwo = findDistanceBetween(0, 0, endX, endY);

        if (distanceFromCenterOne <= distanceFromCenterTwo) {
            return String.format("(%d, %d)(%d, %d)", startX, startY, endX, endY);
        } else {
            return String.format("(%d, %d)(%d, %d)", endX, endY, startX, startY);
        }
    }
}