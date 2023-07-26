package objects_and_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VehicleCatalogue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Vehicle> garage = new ArrayList<>();
        String line;

        while (!"End".equals(line = reader.readLine())) {
            garage.add(Vehicle.getInstance(line.split("\\s+")));
        }


        while (!"Close the Catalogue".equals(line = reader.readLine())) {
            String model = line;

            garage.stream().filter(v -> model.equals(v.getModel())).forEach(System.out::println);
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n"
                , garage.stream()
                        .filter(e -> "Car".equals(e.getType()))
                        .mapToInt(Vehicle::getHorsepower).average().orElse(0));

        System.out.printf("Trucks have average horsepower of: %.2f.%n"
                , garage.stream()
                        .filter(e -> "Truck".equals(e.getType()))
                        .mapToInt(Vehicle::getHorsepower).average().orElse(0));
    }

    private static class Car extends Vehicle {
        private Car(String model, String color, int horsepower) {
            super("Car", model, color, horsepower);
        }
    }

    private static class Truck extends Vehicle {
        private Truck(String model, String color, int horsepower) {
            super("Truck", model, color, horsepower);
        }
    }

    private static abstract class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        private Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d"
                    , this.getClass().getSimpleName()
                    , this.model
                    , this.color
                    , this.horsepower);
        }

        private String getType() {
            return this.type;
        }

        private String getModel() {
            return this.model;
        }

        private String getColor() {
            return this.color;
        }

        private int getHorsepower() {
            return this.horsepower;
        }

        private static Vehicle getInstance(String[] data) {
            if ("car".equals(data[0])) {
                return new Car(data[1], data[2], Integer.parseInt(data[3]));
            } else if ("truck".equals(data[0])) {
                return new Truck(data[1], data[2], Integer.parseInt(data[3]));
            }
            return null;
        }
    }
}