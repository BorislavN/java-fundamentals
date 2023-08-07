package exam.mid_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reception {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int totalEfficiencyPerHour = Integer.parseInt(reader.readLine())
                + Integer.parseInt(reader.readLine())
                + Integer.parseInt(reader.readLine());

        double students = Double.parseDouble(reader.readLine());

        int hours = (int) Math.ceil(students / totalEfficiencyPerHour);

        System.out.printf("Time needed: %dh.%n", hours + (hours - 1) / 3);

        //we calculate how many work hours will be needed
        //he breaks are every three hours
        //we subtract 1 to avoid counting a break after the job hase been done
        //nine work hours look like this = 3 + break + 3 + break + 3
        //not like this =  3 + break + 3 + break + 3 + break
    }
}