package objects_and_classes.more_exercise.companyroster;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String... arguments) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.setEmailAndAge(arguments);
    }

//    public Employee(String name, double salary, String position, String department, String email) {
//        this.name = name;
//        this.salary = salary;
//        this.position = position;
//        this.department = department;
//        this.email = email;
//        this.age = -1;
//    }
//
//    public Employee(String name, double salary, String position, String department, int age, char c) {
//        this.name = name;
//        this.salary = salary;
//        this.position = position;
//        this.department = department;
//        this.email = "n/a";
//        this.age = age;
//    }
//
//    public Employee(String name, double salary, String position, String department, String email, int age) {
//        this.name = name;
//        this.salary = salary;
//        this.position = position;
//        this.department = department;
//        this.email = email;
//        this.age = age;
//    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void setEmailAndAge(String[] arguments) {
        //the method counts on the email being valid
        for (String argument : arguments) {
            if (argument.contains("@")) {
                this.email = argument;
            } else {
                this.age = Integer.parseInt(argument);
            }
        }

        if (this.age == 0) {
            this.age = -1;
        }

        if (this.email == null) {
            this.email = "n/a";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.getSalary(), this.salary);
    }

    public static Employee createEmployee(String[] data) {
        if (data.length == 6) {
            return new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4], data[5]);
        }
        if (data.length == 5) {
            return new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4]);
        }

        return new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]);
    }
}