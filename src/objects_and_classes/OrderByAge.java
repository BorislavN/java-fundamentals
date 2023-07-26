package objects_and_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] data = line.split("\\s+");

            people.add(new Person(data[0], data[1], Integer.parseInt(data[2])));
        }

        people.stream()
                .sorted(Comparator.comparingInt(p -> p.age))
                .forEach(System.out::println);
    }

    private static class Person {
        private String name;
        private String id;
        private int age;

        private Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }
    }
}