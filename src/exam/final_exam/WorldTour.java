package exam.final_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorldTour {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder travelPlan = new StringBuilder(reader.readLine());

        String input;

        while (!"Travel".equals(input = reader.readLine())) {
            String[] data = input.split(":");

            switch (data[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(data[1]);
                    if (isValid(index, travelPlan.length())) {
                        travelPlan.insert(index, data[2]);
                    }
                    break;
                case "Remove Stop":
                    int start = Integer.parseInt(data[1]);
                    int end = Integer.parseInt(data[2]);
                    if (isValid(start, travelPlan.length()) && isValid(end, travelPlan.length())) {
                        travelPlan.delete(start, end + 1);
                    }
                    break;
                case "Switch":
                    travelPlan = new StringBuilder(travelPlan.toString().replaceAll(data[1], data[2]));
                    break;
            }
            System.out.println(travelPlan);
        }

        System.out.printf("Ready for world tour! Planned stops: %s%n", travelPlan);
    }

    private static boolean isValid(int index, int limit) {
        return index >= 0 && index < limit;
    }
}