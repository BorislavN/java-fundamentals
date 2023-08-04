package objects_and_classes.groomingsalon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return Collections.unmodifiableList(this.data);
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> name.equals(pet.getName()));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(pet -> name.equals(pet.getName()) && owner.equals(pet.getOwner()))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        output.append("The grooming salon has the following clients:");
        output.append(System.lineSeparator());

        this.data.forEach(pet -> output.append(String.format("%s %s%n", pet.getName(), pet.getOwner())));

        return output.toString().trim();
    }
}