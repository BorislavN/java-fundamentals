package objects_and_classes.teamworkprojects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Team> teams;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        teams = new ArrayList<>();
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {
            String[] data = reader.readLine().split("-");

            if (indexOfTeam(data[1]) != -1) {
                System.out.printf("Team %s was already created!%n", data[1]);
                continue;
            }
            if (checkIfUserHasCreatedTeam(data[0])) {
                System.out.printf("%s cannot create another team!%n", data[0]);
                continue;
            }

            teams.add(new Team(data[1], new User(data[0])));
            System.out.printf("Team %s has been created by %s!%n", data[1], data[0]);
        }

        String line;

        while (!"end of assignment".equals(line = reader.readLine())) {
            String[] data = line.split("->");
            int index = indexOfTeam(data[1]);

            if (index == -1) {
                System.out.printf("Team %s does not exist!%n", data[1]);
                continue;
            }
            if (checkIfUserIsAlreadyInTeam(data[0]) || checkIfUserHasCreatedTeam(data[0])) {
                System.out.printf("Member %s cannot join team %s!%n", data[0], data[1]);
                continue;
            }

            teams.get(index).addUser(new User(data[0]));
        }

        teams.stream().sorted().forEach(team -> {
            if (team.getUsers().size() > 0) {
                System.out.println(team);
            }
        });

        System.out.println("Teams to disband:");

        teams.stream()
                .filter(team -> team.getUsers().size() == 0)
                .sorted()
                .map(Team::getName)
                .forEach(System.out::println);
    }

    private static int indexOfTeam(String name) {
        for (int index = 0; index < teams.size(); index++) {
            if (name.equals(teams.get(index).getName())) {
                return index;
            }
        }
        return -1;
    }

    private static boolean checkIfUserHasCreatedTeam(String name) {
        for (Team team : teams) {
            if (name.equals(team.getCreator().getUsername())) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfUserIsAlreadyInTeam(String name) {
        for (Team team : teams) {
            if (team.isAlreadyInTheTeam(name)) {
                return true;
            }
        }
        return false;
    }
}