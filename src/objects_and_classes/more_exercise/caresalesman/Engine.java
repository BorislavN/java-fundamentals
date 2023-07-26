package objects_and_classes.more_exercise.caresalesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, String... arguments) {
        this.model = model;
        this.power = power;
        this.setOptionalFields(arguments);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    private void setOptionalFields(String[] arguments) {
        for (String argument : arguments) {
            if (Character.isDigit(argument.charAt(0))) {
                this.displacement = Integer.parseInt(argument);
            } else {
                this.efficiency = argument;
            }
        }
    }

    public static Engine createEngine(String[] data) {
        if (data.length == 4) {
            return new Engine(data[0], Integer.parseInt(data[1]), data[2], data[3]);
        } else if (data.length == 3) {
            return new Engine(data[0], Integer.parseInt(data[1]), data[2]);
        }
        return new Engine(data[0], Integer.parseInt(data[1]));
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s"
                , this.model
                , this.power
                , this.displacement == 0 ? "n/a" : this.displacement
                , this.efficiency == null ? "n/a" : this.efficiency
        );
    }
}
