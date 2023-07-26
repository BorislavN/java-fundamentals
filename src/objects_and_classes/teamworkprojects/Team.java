package objects_and_classes.teamworkprojects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Team implements Comparable<Team> {
    private String name;
    private User creator;
    private List<User> users;

    public Team(String name, User creator) {
        this.name = name;
        this.creator = creator;
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(this.users);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addUser(User user) {
        if (!this.isAlreadyInTheTeam(user.getUsername())) {
            this.users.add(user);
            return true;
        }
        return false;
    }

    public User getCreator() {
        return this.creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public boolean removeUser(User user) {
        return this.users.remove(user);
    }

    public boolean isAlreadyInTheTeam(String username) {
        for (User user : this.users) {
            if (username.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s%n- %s%n%s"
                , this.name
                , this.creator.getUsername()
                , this.users.stream()
                        .sorted()
                        .map(e -> "-- " + e.getUsername())
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    @Override
    public int compareTo(Team o) {
        int result = Integer.compare(o.getUsers().size(), this.users.size());

        if (result == 0) {
            result = this.name.compareTo(o.getName());
        }

        return result;
    }
}