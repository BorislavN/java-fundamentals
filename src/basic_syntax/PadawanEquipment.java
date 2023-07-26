package basic_syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadawanEquipment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double budget = Double.parseDouble(reader.readLine());
        int students = Integer.parseInt(reader.readLine());
        double lightsaberPrice = Double.parseDouble(reader.readLine());
        double robePrice = Double.parseDouble(reader.readLine());
        double beltPrice = Double.parseDouble(reader.readLine());

        double totalCost = (Math.ceil(students * 1.1) * lightsaberPrice)
                + (students * robePrice)
                + ((students - Math.floor(students / 6)) * beltPrice);

        if (totalCost > budget) {
            System.out.printf("George Lucas will need %.2flv more.%n", totalCost - budget);
        } else {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalCost);
        }
    }
}