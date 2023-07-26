package objects_and_classes.more_exercise.companyroster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Department> company;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        company = new ArrayList<>();

        while (lines-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            Employee temp = Employee.createEmployee(data);
            Department tempDepartment = getByName(temp.getDepartment());

            tempDepartment.addEmployee(temp);
        }

        company.sort((d1, d2) -> Double.compare(d2.averageSalary(), d1.averageSalary()));
        Department winner = company.get(0);

        System.out.printf("Highest Average Salary: %s%n", winner.getName());

        winner.getEmployees()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static Department getByName(String name) {
        Department temp = null;

        for (Department department : company) {
            if (name.equals(department.getName())) {
                temp = department;
                break;
            }
        }

        if (temp == null) {
            temp = new Department(name);

            company.add(temp);
        }

        return temp;
    }
}