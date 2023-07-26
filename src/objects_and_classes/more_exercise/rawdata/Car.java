package objects_and_classes.more_exercise.rawdata;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public static Car createCar(String[] data) {
        String model = data[0];

        int speed = Integer.parseInt(data[1]);
        int power = Integer.parseInt(data[2]);

        int weight = Integer.parseInt(data[3]);
        String cargoType = data[4];

        int tire1Age = Integer.parseInt(data[6]);
        double tire1Pressure = Double.parseDouble(data[5]);

        int tire2Age = Integer.parseInt(data[8]);
        double tire2Pressure = Double.parseDouble(data[7]);

        int tire3Age = Integer.parseInt(data[10]);
        double tire3Pressure = Double.parseDouble(data[9]);

        int tire4Age = Integer.parseInt(data[12]);
        double tire4Pressure = Double.parseDouble(data[11]);

        List<Tire> temp = List.of(
                new Tire(tire1Age, tire1Pressure),
                new Tire(tire2Age, tire2Pressure),
                new Tire(tire3Age, tire3Pressure),
                new Tire(tire4Age, tire4Pressure)
        );

        return new Car(
                model,
                new Engine(speed, power),
                new Cargo(weight, cargoType),
                temp
        );
    }

    public boolean hasLowPressureTire() {
        for (Tire tire : this.tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
