package objects_and_classes.more_exercise.caresalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, String... arguments) {
        this.model = model;
        this.engine = engine;
        this.setOptionalFields(arguments);
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

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void setOptionalFields(String[] arguments) {
        for (String argument : arguments) {
            if (Character.isDigit(argument.charAt(0))) {
                this.weight = Integer.parseInt(argument);
            } else {
                this.color = argument;
            }
        }
    }

    public static Car createCar(String[] data, Engine engine) {
        if (data.length == 4) {
            return new Car(data[0], engine, data[2], data[3]);
        } else if (data.length == 3) {
            return new Car(data[0], engine, data[2]);
        }
        return new Car(data[0], engine);
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%nWeight: %s%nColor: %s"
                , this.model
                , this.engine.toString()
                , this.weight == 0 ? "n/a" : this.weight
                , this.color == null ? "n/a" : this.color
        );
    }
}
