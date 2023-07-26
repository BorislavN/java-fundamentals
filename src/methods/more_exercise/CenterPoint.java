package methods.more_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CenterPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x1 = Integer.parseInt(reader.readLine());
        int y1 = Integer.parseInt(reader.readLine());
        int x2 = Integer.parseInt(reader.readLine());
        int y2 = Integer.parseInt(reader.readLine());

        double distanceOne = distanceFromCenter(x1, y1);
        double distanceTwo = distanceFromCenter(x2, y2);

//      System.out.println(distanceOne);
//      System.out.println(distanceTwo);

        if (distanceOne <= distanceTwo) {
            System.out.println(formatOutput(x1, y1));
        } else {
            System.out.println(formatOutput(x2, y2));
        }

//        findClosestPoint(x1, y1, x2, y2);
    }

    private static double distanceFromCenter(int x, int y) {
        return Math.sqrt(Math.pow((-x), 2) + Math.pow((-y), 2));
    }

    private static String formatOutput(int x, int y) {
        return String.format("(%d, %d)", x, y);
    }

    private static void findClosestPoint(int x1, int y1, int x2, int y2) {
        int firstSum = Math.abs(x1) + Math.abs(y1);
        int secondSum = Math.abs(x2) + Math.abs(y2);

        if (firstSum <= secondSum) {
            System.out.println(formatOutput(x1, y1));
        } else {
            System.out.println(formatOutput(x2, y2));
        }
    }
}