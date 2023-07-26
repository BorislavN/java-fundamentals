package objects_and_classes.more_exercise.caresalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Engine> engines;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            Engine temp = Engine.createEngine(reader.readLine().split("\\s+"));
            engines.add(temp);
        }

        lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            Engine temp = null;

            for (Engine engine : engines) {
                if (data[1].equals(engine.getModel())) {
                    temp = engine;
                    break;
                }
            }

            cars.add(Car.createCar(data, temp));
        }
        cars.forEach(System.out::println);
    }
}