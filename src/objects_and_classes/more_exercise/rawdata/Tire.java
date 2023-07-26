package objects_and_classes.more_exercise.rawdata;

public class Tire {
    private int age;
    private double pressure;

    public Tire(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }

    public double getPressure() {
        return this.pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
