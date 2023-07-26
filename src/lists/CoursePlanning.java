package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoursePlanning {
    private static List<String> schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        schedule = Arrays.stream(reader.readLine().split(",\\s+"))
                .collect(Collectors.toList());

        String line;

        while (!"course start".equals(line = reader.readLine())) {
            String[] arguments = line.split(":");

            switch (arguments[0]) {
                case "Add":
                    addLesson(arguments[1]);
                    break;
                case "Insert":
                    insertLesson(arguments[1], Integer.parseInt(arguments[2]));
                    break;
                case "Remove":
                    removeLesson(arguments[1]);
                    break;
                case "Swap":
                    swapLessons(arguments[1], arguments[2]);
                    break;
                case "Exercise":
                    addExercise(arguments[1]);
                    break;
            }
        }

        for (int index = 0; index < schedule.size(); index++) {
            System.out.printf("%d.%s%n", index + 1, schedule.get(index));
        }
    }

    private static void addLesson(String title) {
        if (!schedule.contains(title)) {
            schedule.add(title);
        }
    }

    private static void removeLesson(String title) {
        if (schedule.remove(title)) {
            schedule.remove(title + "-Exercise");
        }
    }

    private static void addExercise(String lesson) {
        int lessonIndex = schedule.indexOf(lesson);
        String exercise = lesson + "-Exercise";

        if (lessonIndex != -1) {
            if (!schedule.contains(exercise)) {
                schedule.add(lessonIndex + 1, exercise);
            }
        } else {
            schedule.add(lesson);
            schedule.add(exercise);
        }
    }

    private static void insertLesson(String lesson, int index) {
        if (!schedule.contains(lesson)) {
            if (index >= 0 && index < schedule.size()) {
                schedule.add(index, lesson);
            }
        }
    }

    private static void swapLessons(String lesson1, String lesson2) {
        int indexOfFirst = schedule.indexOf(lesson1);
        int indexOfSecond = schedule.indexOf(lesson2);

        if (indexOfFirst != -1 && indexOfSecond != -1) {
            String firstTemp = schedule.get(indexOfFirst);
            String secondTemp = schedule.get(indexOfSecond);

            schedule.set(indexOfFirst, secondTemp);
            schedule.set(indexOfSecond, firstTemp);

            moveExercise(firstTemp, indexOfSecond);
            moveExercise(secondTemp, indexOfFirst);
        }
    }

    private static void moveExercise(String lesson, int newIndex) {
        String exercise = lesson + "-Exercise";
        int index = schedule.indexOf(exercise);

        if (index != -1) {
            schedule.remove(index);
            schedule.add(newIndex + 1, exercise);
        }
    }
}