package objects_and_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        List<Student> students = new ArrayList<>();

        while (lines-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            students.add(new Student(data[0], data[1], Double.parseDouble(data[2])));
        }
        students.stream().sorted().forEach(System.out::println);
    }

    private static class Student implements Comparable<Student> {
        private String firstName;
        private String lastName;
        private double grade;

        private Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        private String getFirstName() {
            return this.firstName;
        }

        private void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        private String getLastName() {
            return this.lastName;
        }

        private void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private double getGrade() {
            return this.grade;
        }

        private void setGrade(double grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }


        @Override
        public int compareTo(Student s) {
            return Double.compare(s.getGrade(), this.grade);
        }
    }
}