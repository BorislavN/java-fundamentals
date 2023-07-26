package objects_and_classes.more_exercise.rawdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            cars.add(Car.createCar(data));
        }
        String command = reader.readLine();

        if ("fragile".equals(command)) {
            cars.stream()
                    .filter(car -> car.hasLowPressureTire()
                            && "fragile".equals(car.getCargo().getCargoType()))
                    .forEach(System.out::println);

        } else if ("flamable".equals(command)) {
            cars.stream()
                    .filter(car -> car.getEngine().getEnginePower() > 250
                            && "flamable".equals(car.getCargo().getCargoType()))
                    .forEach(System.out::println);
        }
    }
}